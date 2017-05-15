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
		$(function() {
			$("#toCreateDate").datepicker({
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
		$(function() {
			$("#createDate").datepicker({
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
		function checkSearch(){		
			if(isNumeric("id", "ID", true)){
				return true;
			} 
			return false;
		}
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
		function sortColumn(sortColumn){
			commentCustomerBean.action = "sortComment";
			commentCustomerBean.sortColumn.value = sortColumn;
			commentCustomerBean.submit();
		}
	</script>
</head>

<body>
<%@include file="header.jsp"%>
        	<label class="TextSectionHeaders">Tìm khách hàng tiềm năng</label><br>
        	<hr><br>
        	<form:form modelAttribute="commentCustomerBean" method="POST" action="searchComment">
        	<table border="0" align="center">
        	<tr height="30">
        		<td>&nbsp;Mã khách hàng</td>
				<td width="160px"><form:input path="id"/></td>
				<td>&nbsp;Tên khách hàng</td><td colspan="1"><form:input path="name" size="40"/> </td>
		  		<td>&nbsp;Người giao dịch</td><td><form:input path="nguoiGiaoDich"/> </td>
  		   </tr ><tr height="30">
		  		<td>&nbsp;Điện thoại</td><td><form:input path="dienThoai"/> </td>
		  		<td>&nbsp;Địa chỉ</td><td colspan="1"><form:input path="diaChi" size="40"/> </td>
		  		<td>&nbsp;Email</td><td colspan="1"><form:input path="email"/> </td>
		    </tr><tr height="30">
		    	<td>&nbsp;Người tạo</td><td>
			  		<form:select path="employeeId" onchange="disp();"> 
						<form:option value=""> --All-- </form:option>
						<c:forEach items="${listEmployees}" var="cn">
			            	<form:option value="${cn.id}">${cn.tenNhanVienKD}</form:option>                  
			            </c:forEach> 
			       	</form:select>
			  	</td>
		  		<td>&nbsp;Ngày nhắc nhở</td><td><form:input path="remindDate"/></td>		  		
		  		<td>&nbsp;Fax</td><td><form:input path="fax"/> </td>
			  		
			   </tr><tr height="30">
			   		<td>&nbsp;Người cập nhật</td><td>
			  		<form:select path="updatedBy" onchange="disp();"> 
						<form:option value=""> --All-- </form:option>
						<c:forEach items="${listEmployees}" var="cn">
			            	<form:option value="${cn.id}">${cn.tenNhanVienKD}</form:option>                  
			            </c:forEach> 
			       	</form:select>
			  		</td>
			  		<td>&nbsp;KH tiềm năng</td><td>
				  		<form:select path="ratePotentialId"> 
				  			<form:option value="">-- All --</form:option>
							<c:forEach items="${rates}" var="cn">
			            	<form:option value="${cn.ratePotentialId}">${cn.description}</form:option>                  
			            	</c:forEach> 
			       		</form:select>
			  		</td>
			  		<td>&nbsp;Ngày tạo từ</td><td colspan="4"><form:input path="createDate"/> đến 
			  				<form:input path="toCreateDate"/>  				
			  		&nbsp;&nbsp;Không theo dõi&nbsp;&nbsp;<form:checkbox path="inactive"/></td>
			   </tr><tr>			  		  
			  <td colspan="6" align="left">
					<input type="submit" class="left_button" value="Search" id="search" align="bottom" onclick="return checkSearch();"/>
			  </td></tr>			  
			  </table>
		<form:hidden path="sortColumn"/>			
 		<table border="0" align="left" width="100%">
			<c:choose><c:when test="${list != null}">
			<hr>
	 		<thead class="results-header"> 
		 	<tr class="TextListHeaders"> 
		 		<th><spring:message text="STT"/> </th>
		 		<th onclick="sortColumn('name')" style="cursor: pointer;">Tên khách hàng</th>
		 		<th onclick="sortColumn('dienThoai')" style="cursor: pointer;">Điện thoại</th>
		 		<th onclick="sortColumn('diaChi')" style="cursor: pointer;">Địa chỉ</th>
		 		<th onclick="sortColumn('createDate')" style="cursor: pointer;">Ngày tạo</th>
		 		<th onclick="sortColumn('remindDate')" style="cursor: pointer;">Ngày nnhở</th>	
		 		<th onclick="sortColumn('updateDate')" style="cursor: pointer;">Ngày cập nhật</th>	 		
		 		<th onclick="sortColumn('updatedBy')" style="cursor: pointer;">Người cập nhật</th>		 		
		 		<th onclick="sortColumn('ratePotentialId')" style="cursor: pointer;">Tiềm năng</th>
		 		<th><spring:message text="Xóa"/></th>
		 	</tr>
	 		</thead>
	 		<c:set var="count" value="0" scope="page" />
	 		<c:forEach items="${list}" var="a">
	 		<tr class="results-row">
	 			<c:set var="count" value="${count + 1}" scope="page"/>	 		
	 			<td class="text" align="center" style="font-weight: bold;cursor: pointer;" onclick="getCommentCustomer('${a.id}')"> ${count}</td>	 		
	 			<td class="text" width="20%" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"><a href="#" title="Xem chi tiết">${a.name }</a></td>
	 			<td class="text" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"> ${a.dienThoai }</td>	
	 			<td class="text" width="25%" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"> ${a.diaChi }</td>
	 			<td class="text" align="center" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.createDate}" /></td>
	 			<td class="text" align="center" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.remindDate}" /></td>
	 			<td class="text" align="center" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.updateDate}" /></td>
	 			<td class="text" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"> ${a.updatedBy}</td>
	 			<td class="text" align="center" onclick="getCommentCustomer('${a.id}')" style="cursor: pointer;"> ${a.ratePotential.description}</td>
	 			<td align="center">
	 			<c:choose><c:when test="${a.employeeId == employee.id || employee.role == 'admin'}">
	 			<img title="Xóa" class="delete" src="<c:url value="/resources/images/delete.jpg"/>" id="${a.id}" onclick="deleted(this)"/>
	 			</c:when></c:choose>
	 			</td>	
	 		</tr>
	 		</c:forEach>	 		
		  </c:when></c:choose>	  
		  <tr></tr>
	 	</table>	 	
	 	</form:form>
	 	
	  <br>&nbsp;<br>
<%@include file="footer.jsp"%>
	
</body>
</html>

