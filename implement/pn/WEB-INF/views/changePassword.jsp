<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Văn phòng phẩm Phương Nam</title>
</head>

<body>
<%@include file="header.jsp"%>
     <h4>Change password</h4>
     <hr><br>     
      	<table border="0" align="center" width="100%"><tr><td align="center">
    <form:form modelAttribute="employee" method="POST" action="changePassword">
      	<table border="0" align="center">
      	<tr><td colspan="2"><label class="asterisk">${message}</label> </td></tr>
      	<tr height="30">
      	<td>User name</td><td><form:input path="id" size="20" readonly="true"/></td>
      	</tr><tr height="30">
		<td>New password</td><td><form:password path="passWord"  size="22"/> </td>
 	    </tr ><tr>		 
 	     <td colspan="2" align="center">
			<input type="submit" class="left_button" value="Save" id="login" onclick="return checkSubmit();" align="bottom"/>
		</td></tr>
		<tr><td colspan="2" height="200px"></td></tr>		
		</table>
	</form:form>
	</td></tr></table>
<%@include file="footer.jsp"%>
	
</body>
</html>

