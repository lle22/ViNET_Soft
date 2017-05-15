n<%@ include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Văn phòng phẩm Phương Nam</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/themes/base/jquery.ui.all.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/demos.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/wkrte.css"/>">
	<link rel="stylesheet" href="/resources/demos/style.css" />
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.widget.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/ui/jquery.ui.datepicker.js"/>"></script>
	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.3.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/wkrte.js"/>"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		var arr = $('.wkrte-1').rte({
			width: 820,
			height: 320,
			controls_rte: rte_toolbar,
			controls_html: html_toolbar
		});		
	});
	function sendEmail(){
		if (confirm('Bạn muốn gửi email?')) { 
			var b = $("#emailContent1").contents().find("body").html();
			$("#emailContent").val(b);
			$("#fileName").val($('#attach').val());
			if($("#emailContent").val() != '<br>'){
				return true;
			} else {
				return false;
			}
		} else {
			return false;			
		}
	}
	function backModify(id){
		window.location = "modifyComment?id=" + id;
	}
	$(document).ready(function(){
		   $('#clearAttach').click(function(){ 
				$('#attach').val(''); 
		   });
		});
</script>	
	</head>
<body>
<%@include file="header.jsp"%>        	
        	<label class="TextSectionHeaders">New Message</label><br>
        	<hr><br>
        	<form:form modelAttribute="fileUploadForm" method="POST" action="sendEmail" enctype="multipart/form-data" accept-charset="utf-8">
        			<table border="0"><tr><td colspan="4"><label class="asterisk">${message}</label></td></tr>
					<tr><td width="5%">To</td>
					<td width="30%"><form:input size="60" path="emailTo" />
					</td><td><font size="2" style="font-weight: normal">Gửi nhiều email ngăn cách nhau dấu phải</font></td></tr>
					
					<tr><td width="5%">Cc</td>
					<td width="30%"><form:input  size="60" path="emailCc"/>
					</td><td>vd: <font size="2" style="font-weight: normal">abc@yahoo.com,def@yahoo.com</font></td></tr>
	
					<tr><td width="5%">Bcc</td>
					<td width="30%"><form:input size="60" path="emailBcc" />
					</td><td></td></tr>

					<tr><td width="5%">From</td>
					<td width="30%"><form:input   size="60" path="emailFrom" readonly="true"/>
					</td><td></td></tr>
					
					<tr><td width="5%">Subject</td>
					<td width="30%" colspan="2"><form:input size="60" path="emailSubject" />
					</td></tr>				
					<tr><td colspan="3" valign="middle" height="40"><hr></td></tr>				
					<tr><td colspan="3">
					<div id="container">
						<article><section>				
							<textarea cols="70" rows="20" class="wkrte-1" id="emailContent1" name="emailContent1">
							${fileUploadForm.emailContent}
							</textarea>	
						</section></article>
					</div>					
					<form:hidden path="emailContent"/>
					</td></tr>
					<c:choose><c:when test="${fileUploadForm.fileName != null && fileUploadForm.fileName != ''}">
					<tr><td colspan="2"><font size="2" style="font-weight: normal">File attached: &nbsp;&nbsp;${fileUploadForm.fileName}</font></td></tr>
					</c:when></c:choose>
					<tr height="40"><td width="5%">Attachment</td>
					<td colspan="2" valign="middle">
					<form:hidden path="fileName"/>
					<form:input type="file" path="attach" size="71"/>
					<input type="button" value="Clear Attach" id="clearAttach" name="clearAttach" onclick="clearAttach();">
					<input type="submit" value="Send email" id="send" name="send" onclick="return sendEmail()">
					<input type="button" value="Back" onclick="return backModify('${fileUploadForm.id}')">
					<form:hidden path="id"/>
					</td></tr>
					</table>
			</form:form>
<%@include file="footer.jsp"%>
	
</body>
</html>
