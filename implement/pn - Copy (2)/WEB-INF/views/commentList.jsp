<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<c:choose><c:when test="${list != null}">
<table border="0" align="center" class="label-lft" width="100%">
		<thead class="results-header"> 
 	<tr class="portlet-section-header results-header"> 
 		<th><input type="checkbox" id="deleteAll"/></th>
 		<th><spring:message text="Mã KH"/> </th>
 		<th><spring:message text="Tên khách hàng"/> </th>
 		<th><spring:message text="Điện thoại"/> </th>
 		<th><spring:message text="Địa chỉ"/> </th>
 		<th><spring:message text="Ngày tạo"/> </th>
 		<th><spring:message text="Ngày nhắc nhở"/> </th>
 		<th><spring:message text="Người tạo"/> </th>
 	</tr>
		</thead>
 	<c:forEach items="${list}" var="a">
		<tr class="results-row">
			<td><input type="checkbox" id="${a.id}"/></td>
			<td ><a href="javascript:getCommentCustomer('${a.id }')"> ${a.id }</a></td>
			<td class="text" width="20%"> ${a.name }</td>
			<td class="text"> ${a.dienThoai }</td>	
			<td class="text" width="20%"> ${a.diaChi }</td>
			<td class="text"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.createDate}" /></td>
			<td class="text"><fmt:formatDate pattern="dd/MM/yyyy" value="${a.remindDate}" /></td>
			<td class="text"> ${a.dmNhanvien.tenNhanVienKD}</td>	
		</tr>
		</c:forEach>
		<tr>			  		  
	  <td colspan="6" align="left">
		<input type="button" class="left_button" value="Delete" id="delete" onclick="getCustomerInfor()" align="bottom"/>
	 </td></tr>
	</table>
 </c:when></c:choose>
