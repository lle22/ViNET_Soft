<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Văn phòng phẩm Phương Nam</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.js"/>"></script>			
	<script type="text/javascript">
	function checkSubmit(){			
			if(isEmpty("id", "User name", true) && isEmpty("passWord", "Password", true)){
				return true;
			} 
			return false;
	}
	function Onload(){
		$("#id").focus();
	}		
	</script>
</head>
	
<body onload="Onload();">
<%@include file="header.jsp"%>
     <label class="TextSectionHeaders">Login</label><br>
     <hr><br>     
      	<table border="0" align="center" width="100%"><tr><td align="center">
    <form:form modelAttribute="employee" method="POST" action="employeeLogin">
      	<table border="0" align="center">
      	<tr><td colspan="2"><label class="asterisk">${message}</label> </td></tr>
      	<tr height="30">
      	<td>User name</td><td><form:input path="id" size="20"/></td>
      	</tr><tr height="30">
		<td>Password</td><td><form:password path="passWord"  size="20"/> </td>
 	    </tr ><tr>		 
 	     <td colspan="2" align="center">
			<input type="submit" class="left_button" value="Login" id="login" onclick="return checkSubmit();" align="bottom"/>
		</td></tr>
		<tr><td colspan="2" height="200px"></td></tr>		
		</table>
	</form:form>
	</td></tr></table>
<%@include file="footer.jsp"%>
	
</body>
</html>

