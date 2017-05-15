<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Văn phòng phẩm Phương Nam</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/themes/base/jquery.ui.all.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/demos.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.widget.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.datepicker.js"/>"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#remindDate").datepicker({
				 showButtonPanel: true,
			     beforeShow: function( input ) {
				 setTimeout(function() {
			   		var buttonPane = $( input )
			     	.datepicker( "widget" )
			     	.find( ".ui-datepicker-buttonpane" );
			   			var btn = $('<button class="ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all" type="button">Clear</button>');
			   			btn.unbind("click").bind("click", function () {
			    		$.datepicker._clearDate( input );
			  		});
			  		btn.appendTo( buttonPane );
			 		}, 1 );
			      }
			});
		});	
		function getCommentCustomer(id){
			window.location = "modifyComment?id=" + id;
		}
		function deleted(img){ 
			if (confirm('Bạn muốn xóa thông tin khách hàng này không?')){
				var parent = $(img).closest('tr');
				var id = $(img).attr('id');
				jQuery.ajax({
					type: 'POST',
					url: 'delete',
					data: 'id=' + id,
					success: function(a) {
						parent.slideUp(3,function() {
					          parent.remove();
					    });											
					},
					error: function(e) {
						alert(e);
					}
				});
			}	        
		}	
		
		function checkSubmit(){			
			if(isEmpty("name", "Tên khách hàng", true) && isEmpty("dienThoai", "Điện thoại", true) 
					&& isEmpty("diachi", "Địa chỉ", true) && isEmail('email', "Email", true) && isEmpty("ghichu", "Ghi chú", true)){
				return true;
			} 
			return false;
		}
		function addComment(){	
			window.location = "viewCommentCustomer";
		}
	</script>
</head>

<body>
<%@include file="header.jsp"%>        	  
        	<label class="TextSectionHeaders">Thêm khách hàng tiềm năng</label><br>
        	<hr><br>        		
        	<form:form modelAttribute="commentCustomerBean" method="POST" action="createComment">
        	<table border="0">
        	<tr><td colspan="6"><label class="asterisk">${message}</label></td></tr>
        	<tr height="30">
				<form:hidden path="id" />
				<td>Tên khách hàng&nbsp;</td><td colspan="1"><form:input path="name" size="50"/> </td>
		  		<td>Điện thoại</td><td><form:input path="dienThoai"/> </td>
		  		<td>Fax</td><td><form:input path="fax" size="30"/> </td>			  		
		    </tr><tr height="30">
				<td>Địa chỉ</td><td><form:input path="diaChi" size="50"/></td>
				<td>Người giao dịch&nbsp;</td><td><form:input path="nguoiGiaoDich"/> </td>				
				<td>Email</td><td colspan="3"><form:input path="email" size="30"/> </td>
			</tr><tr height="30">
				<td colspan="1" valign="top">Ghi chú</td>
				<td colspan="5"><form:textarea path="ghiChu" cols="50" rows="4"></form:textarea> </td>
			</tr><tr height="30">
		  		<td>Ngày nhắc nhở&nbsp;</td><td><form:input path="remindDate" id="remindDate" readonly="false"/>
		  		&nbsp;KH tiềm năng&nbsp;
			  		<form:select path="ratePotentialId"> 
						<c:forEach items="${rates}" var="cn">
		            	<form:option value="${cn.ratePotentialId}">${cn.description}</form:option>                  
		            	</c:forEach> 
		       		</form:select>
		  		</td>
		  		<c:choose><c:when test="${commentCustomerBean.employeeName != null}">
		  		<td>&nbsp;Ngày tạo&nbsp;</td><td class="text">${commentCustomerBean.createDate}</td>
		  		</c:when>
		  		</c:choose>  		
			  </tr><tr>
			  <td colspan="6" align="left" height="50px">
			  <table border="0"><tr>			  
			  <td width="90px">
					<input type="submit" class="left_button" value="Save" id="save" onclick="return checkSubmit();" align="bottom"/>
			  </td>
			  <td>
					<input type="button" class="left_button" value="New" id="add" onclick="addComment();" align="bottom"/>
			  </td>
			  
			  </tr>
			  </table></td></tr>			  
			  </table>
			</form:form>
			
			<c:choose><c:when test="${list != null}">
			<label class="TextSectionHeaders">Danh sách khách hàng tiềm năng trong ngày</label><br><hr>
			<table border="0" align="left" width="100%">
	 		<thead class="results-header"> 
		 	<tr class="TextListHeaders"> 
		 		<th><spring:message text="STT"/> </th>
		 		<th><spring:message text="Tên khách hàng"/> </th>
		 		<th><spring:message text="Điện thoại"/> </th>
		 		<th><spring:message text="Địa chỉ"/> </th>
		 		<th><spring:message text="Ngày tạo"/> </th>
		 		<th><spring:message text="Ngày nhắc nhở"/> </th>
		 		<th><spring:message text="Người tạo"/> </th>
		 		<th><spring:message text="Tiềm năng"/> </th>
		 		<th><spring:message text="Xóa"/></th>
		 	</tr>
	 		</thead>
	 		<c:set var="count" value="0" scope="page" />
		 	<c:forEach items="${list}" var="a">
	 		<tr class="results-row">
	 			<c:set var="count" value="${count + 1}" scope="page"/>	 		
	 			<td class="text" align="center"> ${count}</td>	 			 		
	 			<td class="text" width="25%"><a href="javascript:getCommentCustomer('${a.id}')" title="Xem chi tiết">${a.name }</a></td>
	 			<td class="text"> ${a.dienThoai }</td>	
	 			<td class="text" width="25%"> ${a.diaChi }</td>
	 			<td class="text"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.createDate}" /></td>
	 			<td class="text"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.remindDate}" /></td>
	 			<td class="text"> ${a.employee.tenNhanVienKD}</td>
	 			<td class="text"> ${a.ratePotential.description}</td>
	 			<td align="center">
	 			<c:choose><c:when test="${a.employeeId == employee.id || employee.role == 'admin'}">
	 			<img title="Delete" class="delete" src="<c:url value="/resources/images/delete.jpg"/>" id="${a.id}" onclick="deleted(this)"/>
	 			</c:when></c:choose>
	 			</td>	
	 		</tr>
	 		</c:forEach>	 		
		  <tr></tr>
	 	</table>	 	
		  </c:when></c:choose>	  
	  <br>&nbsp;<br>
<%@include file="footer.jsp"%>
	
</body>
</html>
