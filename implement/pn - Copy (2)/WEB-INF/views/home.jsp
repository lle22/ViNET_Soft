<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Văn phòng phẩm Phương Nam</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<%@include file="header.jsp"%>        	
        	<label class="TextSectionHeaders">Danh sách khách hàng đã liên hệ</label><br>
        	<hr><br>  
        	<table border="0" height="10%">
        	<c:choose><c:when test="${countRemindOver != 0}">
        	<tr ><td width="20%" align="center"> <img height="30px" width="30px" src="<c:url value="/resources/images/reminder.jpg"/>"/> </td>
        	<td>
				<a href="retrieveComments?filter=remindOver">${countRemindOver} - khách hàng đang chờ bạn liên hệ lại.</a>
			</td></tr>
			</c:when></c:choose>
			<tr ><td width="20%" align="center"> <img height="30px" width="30px" src="<c:url value="/resources/images/reminder.jpg"/>"/> </td>
        	<td>
				<a href="retrieveComments?filter=inMonth">${countInMonth} - khách hàng bạn đã chào được trong tháng này.</a>
			</td>
			</tr>
			<tr height="150px"></tr>
			</table>
<%@include file="footer.jsp"%>
	
</body>
</html>
