<%@ include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css" />
	
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
		function openDialogEmail(){
			if($("#email").val() ==''){
				alert("Email không được trống.");
				$("#email").focus();
			} else {	
				window.location = "viewSendEmail?id=" + $("#id").val();
			}
		}
	</script>
</head>

<body>
<%@include file="header.jsp"%>        	
        	<label class="TextSectionHeaders">Sửa khách hàng tiềm năng</label><br>
        	<hr><br>
        	<form:form modelAttribute="commentCustomerBean" method="POST" action="updateComment">
        	<table border="0" align="center" class="label-lft">
        	<tr><td colspan="6"><label class="asterisk">${message}</label></td></tr>
        	<tr height="30">
        		<form:hidden path="id"/>       		
				<td>&nbsp;Tên khách hàng&nbsp;</td><td colspan="1"><form:input path="name" size="50"/> </td>
		  		<td>&nbsp;Điện thoại</td><td><form:input path="dienThoai"/> </td>
			  	<td>&nbsp;Fax</td><td><form:input path="fax" size="30"/> </td>
			  </tr ><tr height="30">
			  		<td>&nbsp;Địa chỉ</td><td colspan="1"><form:input path="diaChi" size="50"/> </td>
			  		<td>&nbsp;Người giao dịch</td><td><form:input path="nguoiGiaoDich"/> </td>
			  		<td>&nbsp;Email</td><td colspan="3"><form:input path="email" size="30"/> </td>
			   </tr><tr height="30">
			  		<td>&nbsp;Người tạo</td><td><form:input path="employeeName" id="employeeName" readonly="true"/>
			  		<form:hidden path="employeeId"/>
			  		</td>
			  		<td>&nbsp;Ngày tạo</td><td><form:input path="createDate" id="createDate" readonly="true"/></td>
			  </tr><tr height="30">
				<td colspan="1" valign="top">Ghi chú cũ</td>
				<td colspan="5"><form:textarea path="ghiChuCu" cols="50" rows="4" readonly="true"></form:textarea> </td>
			  </tr><tr height="30">
				<td colspan="1" valign="top">Ghi chú</td>
				<td colspan="5"><form:textarea path="ghiChu" cols="50" rows="2"></form:textarea> </td>
			   </tr><tr height="30">
				<td>&nbsp;Ngày nhắc nhở</td><td colspan="5" nowrap="nowrap"><form:input path="remindDate" id="remindDate" readonly="false"/>
			  		&nbsp;Khách hàng tiềm năng
				  		<form:select path="ratePotentialId"> 
							<c:forEach items="${rates}" var="cn">
			            	<form:option value="${cn.ratePotentialId}">${cn.description}</form:option>                  
			            	</c:forEach> 
			       		</form:select>
			  	&nbsp;&nbsp;Không theo dõi&nbsp;&nbsp;<form:checkbox path="inactive"/>			  		
			  		</td>
			   </tr><tr height="30">
			  <td colspan="6">
			  <table border="0"><tr>			  
			  <td width="100px">
					<input type="submit" class="left_button" value="Save" id="save" onclick="return checkSubmit();" align="bottom"/>
			  </td>
			  <td width="100px">
					<input type="button" class="left_button" value="New" id="add" onclick="addComment();" align="bottom"/>
			  </td>
			   <td width="100px">
				<input type="button" id="create-user" onclick="return openDialogEmail();" value="Send email" class="left_button">			  
				</td>
		  
			  <td width="100px">
					<input type="button" class="left_button" value="Back" id="add" onclick="window.location = 'backSearchComment'" align="bottom"/>
			  </td>
			  </tr>
			  </table></td></tr>			  
			  </table>		  
			</form:form>
<%@include file="footer.jsp"%>
	
</body>
</html>
