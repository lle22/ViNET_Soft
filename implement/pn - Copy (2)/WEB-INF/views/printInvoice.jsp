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
	function doOnload(){
		if(document.getElementById('isKemBangKe').checked){
        	$("#divBangKeTextBox").show();
        	$("#invoiceDetail").hide();
	    } else {
        	$("#invoiceDetail").show();
        	$("#divBangKeTextBox").hide();
	    }
	}
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
	}	
	function checkSubmit(){
		var from = document.getElementById("from");
		var to = document.getElementById("to");
		var dTCongNo = document.getElementById("dTCongNo");
		var maCty = document.getElementById("maCty");
		var isBangKe = document.getElementById("isBangKe");
		var isCongNo = document.getElementById("isCongNo");
		var isTongHopMatHang = document.getElementById("isTongHopMatHang");
		var isTongSoKHtrongThang = document.getElementById("isTongSoKHtrongThang");		
		var chietKhau = document.getElementById("chietKhau");
		var result = false;
		/*if (from.value.length == 0) {
		   alert("Từ ngày không được trống.");
		} else if (to.value.length == 0) {
		   alert("Đến ngày không được trống.");
		}  else*/ if (maCty.value.length == 0) {
		   alert("Mã khách hàng không được trống.");
		} else {
			var message = document.getElementById("message");
			message.style.display = "none";			
			result = true;
			var form = document.getElementById("invoiceBean");
			form.submit();			
			
		}
		return result;
	}	
	
	$(document).ready(function(){
	    $("#isKemBangKe").click(function(){
		    if(this.checked){
	        	$("#divBangKeTextBox").show();
	        	$("#invoiceDetail").hide();
		    } else {
	        	$("#invoiceDetail").show();
	        	$("#divBangKeTextBox").hide();
		    }
	    });
	});	
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
		    jQuery("#tenDonVi").val(customer.tenDoiTuongCongNo);
		   	//jQuery("#tenNguoiMuaHang").val(customer.nguoiGiaoDich);
		   	jQuery("#maSoThue").val(customer.maSoThue);
		   	jQuery("#diaChi").val(customer.diaChi);
		 	}, 
		 	error:function(e){
		 		alert("error: " + e);
		 	}
    	});
	}	
	function viewInvoiceDetail(){
		var from = document.getElementById("from");
		var to = document.getElementById("to");
		var maCty = document.getElementById("maCty");
		var isBangKe = document.getElementById("isBangKe");
		var result = false;
		if (from.value.length == 0) {
		   alert("Từ ngày không được trống.");
		} else if (to.value.length == 0) {
		   alert("Đến ngày không được trống.");
		}  else if (maCty.value.length == 0) {
		   alert("Mã khách hàng không được trống.");
		} else {
			var message = document.getElementById("message");
			message.style.display = "none";			
			result = true;
			var form = document.getElementById("invoiceBean");
			form.action = "viewInvoiceDetail";
			form.submit();		
		}
		return result;
	}
	</script>
</head>

<body onload="doOnload();">
<%@include file="header.jsp"%>        	
        	<label class="TextSectionHeaders">In Hóa Đơn Giá Trị Gia Tăng</label><br>
        	<hr><br> 
			<form:form modelAttribute="invoiceBean" method="POST" action="getDocInvoice">
				<table border="0" align="center" class="label-lft">
				<tr><td colspan="4" align="left" height="10"><span class="asterisk" id="message">${message}</span></td></tr>
				<tr height="15">
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
			   </tr>
			    <tr>
			  		<td>Người mua hàng:</td><td class="text"><form:input path="tenNguoiMuaHang" size="20"/></td>
			  		<td>Tên đơn vị:</td><td class="text"><form:input path="tenDonVi" size="60"/></td>
			    </tr>
			    <tr>
			  		<td>Mã số thuế:</td><td class="text"><form:input path="maSoThue" size="20"/></td>
			  		<td>Địa chỉ:</td><td class="text"><form:input path="diaChi" size="60"/></td>
			    </tr>
			     <tr>
			  		<td>Hình thức thanh toan:</td><td class="text"><form:input path="hinhThucThanhToan" size="20"/></td>
			  		<td>Số tài khoản:</td><td class="text"><form:input path="soTaiKhoan" size="15"/></td>
			    </tr>
			    <tr>
			  		<td>Ngày/Tháng/Năm:</td><td class="text"><form:input path="ngay" size="2"/>/<form:input path="thang" size="2"/>/<form:input path="nam" size="4"/></td>			  		
			    </tr>			    
			    <tr>
			    	<td>Kèm bảng kê:  <form:checkbox path="isKemBangKe" id="isKemBangKe" onclick="isKemBangKeCheck(false);"/></td>
					<td colspan="3">
						<div id="divBangKeTextBox" style="display: block;"><form:textarea cols="25" rows="1" path="bangKeText"></form:textarea></div>
					</td>										
				 </tr>
				 <tr>				 	
			  		<td colspan="4" align="left">
			  		<div id="invoiceDetail" style="display: none;">
			  		<input type="button" class="left_button" value="Xem chi tiết" id="viewDetail" onclick="viewInvoiceDetail();" align="bottom" alt="xem chi tiết hóa đơn."/>
			  		<table border="1" >
			  		<tr>
				  		<td>STT</td>
				  		<td >Tên hàng hóa, dịch vụ</td>
				  		<td>Đơn vị tính</td>
				  		<td>Số lượng</td>
				  		<td>Đơn giá</td>
				  		<td>Thành tiền</td>
			  		</tr>
			  		<tbody>
					    <c:forEach items="${invoiceBean.invoiceDetails}" var="invoiceDetail" varStatus="status">    
					        <tr>
					        	<td><input name="invoiceDetails[${status.index}].soTT" value="${invoiceDetail.soTT}" size="5"/></td>
					        	<td><input name="invoiceDetails[${status.index}].tenHangHoa" value="${invoiceDetail.tenHangHoa}" size="50"/></td>
					        	<td><input name="invoiceDetails[${status.index}].donViTinh" value="${invoiceDetail.donViTinh}" size="15"/></td>
					        	<td><input name="invoiceDetails[${status.index}].soLuong" value="${invoiceDetail.soLuong}" size="10"/></td>
					        	<td><input name="invoiceDetails[${status.index}].donGia" value="${invoiceDetail.donGia}" size="15"/></td>
					        	<td><input name="invoiceDetails[${status.index}].thanhTien" value="${invoiceDetail.thanhTien}" size="15"/></td>					        	
					        </tr>
	    				 </c:forEach>
					</tbody>				
				    </table>    
				    </div>
				    </td>
				    </tr>
				<tr>
			  		<td>Thuế xuất GTGT:</td><td class="text"><form:input path="thueSuatGTGT" size="20"/> %</td>
			  		<td>Cộng Tiền hàng:</td><td class="text"><form:input path="congTienHang" size="15"/></td>
			    </tr>
				<tr>
			  		<td colspan="4" align="left">
			 		<table border="0"><tr>			  
			  			<td width="100px">
					<input type="button" class="left_button" value="Tong Hop" id="export" onclick="tonghop();" align="bottom" alt="Tổng hợp dữ liệu từ phần mềm kế toán."/>
			  			</td>
			  			<td width="100px">
					<input type="button" class="left_button" value="Export-Print" id="export" onclick="checkSubmit();" align="bottom"/>
			  			</td></tr>
			  		</table></td></tr>
			  		<tr height="50px"></tr>
				</table>
			</form:form>
	<%@include file="footer.jsp"%>
	
</body>
</html>