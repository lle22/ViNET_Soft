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
	

</head>

<body>
<%@include file="header.jsp"%>
      	<label class="TextSectionHeaders">Tìm chứng từ</label><br>
      	<hr><br>
      	<form:form modelAttribute="chungTuBean" method="POST" action="searchChungTu">
       	<table border="0" align="center">
       		<tr><td>Mã chứng từ</td><td><form:input path="chungTuId"/></td>
       		<td>Tháng</td><td>
       		<form:select path="thang">
    			<form:option value="1" label="Tháng 1" /><form:option value="2" label="Tháng 2" /><form:option value="3" label="Tháng 3" />
    			<form:option value="4" label="Tháng 4" /><form:option value="5" label="Tháng 5" /><form:option value="6" label="Tháng 6" />
    			<form:option value="7" label="Tháng 7" /><form:option value="8" label="Tháng 8" /><form:option value="9" label="Tháng 9" />
    			<form:option value="10" label="Tháng 10" /><form:option value="11" label="Tháng 11" /><form:option value="12" label="Tháng 12" />
			</form:select>	
       		</td></tr>
       		<tr><td colspan="6" align="left">
				<input type="submit" class="left_button" value="Search" id="search" align="bottom" onclick="return checkSearch();"/>
		  </td></tr>
		</table>

		</form:form>
		<table border="0" align="left" width="100%"><tr><td>
	 	<table border="0" align="left">
			<c:choose><c:when test="${list != null}">
			<hr>
	 		<thead class="results-header"> 
		 	<tr class="TextListHeaders"> 
		 		<th><spring:message text="STT"/> </th>
		 		<th onclick="sortColumn('name')" style="cursor: pointer;">Tên hàng</th>
		 		<th onclick="sortColumn('dienThoai')" style="cursor: pointer;">ĐVT</th>
		 		<th onclick="sortColumn('diaChi')" style="cursor: pointer;">Đơn giá</th>
		 		<th onclick="sortColumn('createDate')" style="cursor: pointer;">Số lượng</th>
		 		<th onclick="sortColumn('remindDate')" style="cursor: pointer;">Thành tiền</th>	
		 		<th onclick="sortColumn('updateDate')" style="cursor: pointer;">Quy cách</th>	 		
		 	</tr>
	 		</thead>
	 		<c:set var="count" value="0" scope="page" />
	 		<c:set var="tongTien" value="0" scope="page" />
	 		<c:forEach items="${list}" var="a">
	 		<tr class="results-row">
	 			<c:set var="count" value="${count + 1}" scope="page"/>	
	 			<c:set var="tongTien" value="${tongTien + (a.soLuong * a.donGia)}" scope="page"/> 		
	 			<td class="text" align="center" style="font-weight: bold;cursor: pointer;"> ${count}</td>	 		
	 			<td class="text" > ${a.tenVatTu_ChiTiet}</td>
	 			<td class="text" > ${a.DVT}</td>
	 			<td class="text" > ${a.donGia}</td>
	 			<td class="text" > ${a.soLuong}</td>	 
	 			<td class="text" > ${a.soLuong * a.donGia}</td>	 
	 			<td class="text" > ${a.quyCach}</td>				
	 		</tr>
	 		</c:forEach>	 		
		  </c:when></c:choose>	  
		  <tr>
		  <td colspan="5" align="right" height="30">Tổng tiền:&nbsp;&nbsp;&nbsp;</td><td colspan="1" >${tongTien}</td>
		  </tr>
	 	</table></td></tr></table>	 	
	  <br>&nbsp;<br>
<%@include file="footer.jsp"%>
	
</body>
</html>

