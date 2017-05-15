<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/themes/base/jquery.ui.all.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/demos.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.widget.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.datepicker.js"/>"></script>
	<title>Văn phòng phẩm Phương Nam</title>
	<script>
	$(function() {
		$( "#from" ).datepicker(/*{
			showOn: "button",
			buttonImage: "<html:rootPath/>images/calendar.gif",
			buttonImageOnly: true
		}*/);
	});
	$(function() {
		$( "#to" ).datepicker(/*{
			showOn: "button",
			buttonImage: "<html:rootPath/>images/calendar.gif",
			buttonImageOnly: true
		}*/);
	});
	
	function populateCombo(){
		var curTxt = document.getElementById("maCty").value.toUpperCase();
		var curTxtValue = document.getElementById("maCty");
		var comboComp = document.getElementById("dTCongNo");
		for(i=0;i< comboComp.options.length; i++){
			if(comboComp.options[i].value.substr(0,curTxt.length).toUpperCase() == curTxt){
				comboComp.selectedIndex = i;
				break;
			}
		}		
	}
	function updateMaKhachHang(){
		//populateCombo();		
		var curTxt = document.getElementById("maCty");
		var comboComp = document.getElementById("dTCongNo");
		if(comboComp.selectedIndex > 0){
			curTxt.value = comboComp.options[comboComp.selectedIndex].value;
		}
		getCustomerInfor(curTxt.value);
		dispPathServer();
	}
	function dispPathServer(){
		var curTxt = document.getElementById("maCty");
		var comboComp = document.getElementById("dTCongNo");
		var pathServerDiv = document.getElementById("pathServer")
		if(comboComp.selectedIndex > 0){
			curTxt.value = comboComp.options[comboComp.selectedIndex].value;
			pathServerDiv.style.display = "none";
		} else {
			curTxt.value = "";
			pathServerDiv.style.display = "block";		
		}
		getCustomerInfor(curTxt.value);
	}
	function checkSubmit(){
		var from = document.getElementById("from");
		var to = document.getElementById("to");
		var dTCongNo = document.getElementById("dTCongNo");
		var curTxt = document.getElementById("maCty");
		var isBangKe = document.getElementById("isBangKe");
		var isCongNo = document.getElementById("isCongNo");
		var isTongHopMatHang = document.getElementById("isTongHopMatHang");
		var isTongSoKHtrongThang = document.getElementById("isTongSoKHtrongThang");		
		var chietKhau = document.getElementById("chietKhau");
		var result = false;
		if (from.value.length == 0) {
		   alert("Từ ngày không được trống.");
		} else if (to.value.length == 0) {
		   alert("Đến ngày không được trống.");
		} else if(isCongNo.checked == false && isBangKe.checked == false && isTongHopMatHang.checked == false && isTongSoKHtrongThang.checked == false){
			alert('Phải chọn "Export công nợ", "Export bảng kê", "Tổng số KH trong kỳ" hoặc "Tổng số mặt hàng".');
		} else if (isTongHopMatHang.checked == true && chietKhau.value != "" && !isNumeric("chietKhau", "Chiết khấu", true)){
		} else {
			var message = document.getElementById("message");
			message.style.display = "none";			
			result = true;
			var form = document.getElementById("reportCongNoKHBean");
			form.submit();				
			if(curTxt.value == ""){
				//disable(form);
			}
		}
		return result;
	}
	function isCheckedAllCust(isAllCust){
		var isBangKe = document.getElementById("isBangKe");
		var isCongNo = document.getElementById("isCongNo");
		var isTongHopMatHang = document.getElementById("isTongHopMatHang");
		var isTongSoKHtrongThang = document.getElementById("isTongSoKHtrongThang");		
		if(!isAllCust &&  (isCongNo.checked == true || isBangKe.checked == true || isTongHopMatHang.checked == true)){
			isTongSoKHtrongThang.checked = false;			
		} else if(isTongSoKHtrongThang.checked == true){
			isCongNo.checked = false;
			isBangKe.checked = false;
			isTongHopMatHang.checked = false;
		}

	}
	function tonghop(){
		var r=confirm("Chương trình sẽ cần vài giây để tổng hợp dữ liệu từ phần mềm kế toán. Bạn có muốn tiếp tục không?");
		if (r==true){
			var message = document.getElementById("message");
			message.innerHTML = "Chương trình đang tổng hợp vui lòng chờ trong giây lát...";
			var form = document.getElementById("reportCongNoKHBean");
			form.action = "tonghop";
			form.submit();
			disable(form);
		}
				
	}
	function disable(form) {
	    var limit = form.elements.length;
	    for (i=0;i<limit;i++) {
		    document.forms[0].elements[i].disabled = true;
		}
	}
	function getCustomerInfor(id) {
		jQuery.ajax({
		    type:"GET",
		    data: "customerID=" + id,
		    url:"info",
		    success:function(customer){
		   	 jQuery("#dienTthoai").html(customer.dienThoai);
		   	 jQuery("#diaChi").html(customer.diaChi);
		   	 jQuery("#nguoiGiaoDich").html(customer.nguoiGiaoDich);
		   	jQuery("#email").html(customer.email);
		 	}, 
		 	error:function(e){
		 		alert("error: " + e);
		 	}
    	});
	}	
	</script>
</head>

<body>
<%@include file="header.jsp"%>        	
        	<label class="TextSectionHeaders">Export công nợ khách hàng</label><br>
        	<hr><br> 
			<form:form modelAttribute="reportCongNoKHBean" method="POST" action="congnokhachhang">
				<table border="0" align="center" class="label-lft">
				<tr><td colspan="4" align="left" height="10"><span class="asterisk" id="message">${message}</span></td></tr>
				<tr height="15">
			   <td colspan="4" style="color: #000000;"><div id="pathServer" style="display: block;">Export tất cả các KH công nợ ở //phuongnam: &nbsp;&nbsp;${pathServer}</div>			   
			   </tr>				
				<tr height="30">
					<td width="130px">Từ ngày:</td>
					<td> <form:input path="tuNgay" id="from" readonly="false"/></td>
					<td width="110px">Đến ngày:</td>
					<td><form:input path="denNgay" id="to" readonly="false"/></td>
				</tr>
				<tr height="30"><td><form:label path="maCty">Mã khách hàng:</form:label></td>
					<td><form:input path="maCty" onkeyup="populateCombo()" onblur="updateMaKhachHang();"/></td>
					<td colspan="2"><div id="maKhachHangList">
					<form:select path="dTCongNo" onchange="updateMaKhachHang();"> 
						<form:option value="0"> All </form:option>
						<c:forEach items="${khachHang}" var="cn">
			            	<form:option value="${cn.id}">${cn.tenDoiTuongCongNo}</form:option>                  
			            </c:forEach> 
			       	</form:select>
			    	</div></td>
			   </tr >
			   <tr>
			  		<td>Điện thoại:</td><td class="text"><div id="dienTthoai"></div></td>
			  		<td>Địa chỉ:</td><td class="text"><div id="diaChi"></div></td>
			   </tr>
			   <tr>
			  		<td>Người giao dịch:</td><td class="text"><div id="nguoiGiaoDich"></div></td>
			  		<td>Email:</td><td class="text"><div id="email"></div></td>
			    </tr>
			    <tr height="30">
			    	<td>Export công nợ: </td>
					<td colspan="1"><form:checkbox path="isCongNo" id="isCongNo" onclick="isCheckedAllCust(false);"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Export bảng kê:&nbsp;</td>
					<td><form:checkbox path="isBangKe" id="isBangKe" onclick="isCheckedAllCust(false);"/></td>
				 </tr>
				 <tr height="30">
			    	<td nowrap="nowrap">Chiết khấu KH: </td><td><form:checkbox path="isTongHopMatHang" id="isTongHopMatHang" onclick="isCheckedAllCust(false);"/>
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chiết khấu: </td>
					<td colspan="1"><form:input path="chietKhau" id="chietKhau" size="3" maxlength="3"/>%</td>
				 </tr>
				 <tr height="30">
			    	<td nowrap="nowrap">Tổng số KH trong kỳ: </td>
					<td colspan="1"><form:checkbox path="isTongSoKHtrongThang" id="isTongSoKHtrongThang" onclick="isCheckedAllCust(true);"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hiện mã hàng: </td>					
					<td colspan="1"><form:checkbox path="isShowMaHang" id="isShowMaHang"/></td>					
				 </tr>
				 <tr>
			  		<td colspan="4" align="left">
			 		<table border="0"><tr>			  
			  			<td width="100px">
					<input type="button" class="left_button" value="Tong Hop" id="export" onclick="tonghop();" align="bottom" alt="Tổng hợp dữ liệu từ phần mềm kế toán."/>
			  			</td>
			  			<td width="100px">
					<input type="button" class="left_button" value="Export" id="export" onclick="checkSubmit();" align="bottom"/>
			  			</td></tr>
			  		</table></td></tr>
			  		<tr height="50px"></tr>
				</table>
			</form:form>
	<%@include file="footer.jsp"%>
	
</body>
</html>