<%@page import="com.pn.model.dmEmployee.Employee"%>
<%@ include file="include.jsp"%>
<%@page pageEncoding="UTF-8"%>
<div id="wrapper"><!-- 
	<div id="topbar">
    	0908446482  |  lka02@yahoo.com  |  <a href="http://sites.google.com/site/vanphongphampn" style="color: #FFFFFF;	text-decoration: none;">http://sites.google.com/site/vanphongphampn</a>
    </div> -->
    <div id="header">
    	<div id="logo">
        	Văn phòng phẩm Phương Nam
            <span>SOME TAG LINE</span>
        </div>
        <ul id="navigation">
        	<%
        	String menuItem = (String)session.getAttribute("menuItem");
        	%>
            <li><%if("home".equals(menuItem)){%><span><%}%> <a href="home">Nhắc nhở</a><%if("home".equals(menuItem)){%></span><%}%></li>
            <li><%if("viewCommentCustomer".equals(menuItem)){%><span><%}%><a href="viewCommentCustomer">Ghi chú</a><%if("viewCommentCustomer".equals(menuItem)){%></span><%}%></li>
            <li><%if("viewSearchComment".equals(menuItem)){%><span><%}%><a href="viewSearchComment">Tìm kiếm</a><%if("viewSearchComment".equals(menuItem)){%></span><%}%></li>
            <li><%if("viewExport".equals(menuItem)){%><span><%}%><a href="viewExport">Báo cáo</a><%if("viewExport".equals(menuItem)){%></span><%}%></li>
            <li><%if("viewWordPrint".equals(menuItem)){%><span><%}%><a href="viewWordPrint">In hoá đơn</a><%if("viewWordPrint".equals(menuItem)){%></span><%}%></li>
            <!-- <li><%if("viewChungTu".equals(menuItem)){%><span><%}%><a href="viewChungTu">Chứng từ</a><%if("viewChungTu".equals(menuItem)){%></span><%}%></li> -->
        </ul>
        <div id="userInfor">        	
            <% 
            	if(request.getSession().getAttribute("employee") != null){
            	   	String nameEmployee = ((Employee)request.getSession().getAttribute("employee")).getTenNhanVienKD();%>
            		 Xin chào  <a href="viewChangePassword" title="Change password"><%=nameEmployee %></a> &nbsp;&nbsp;&nbsp;
            		 <a href="logout" title="Logout">Logout</a>&nbsp;&nbsp;&nbsp;
            	<%}
            %>
        </div>
    </div> 
    <div id="body"><!--
    	<div id="leftmenu">
        <div id="quotestart"></div>
            <p>This is an example of a customer testimonial. Place good reviews or something else here. It will look good :)<br /><br />
            </p><div class="right">
            Gill Bates<br />
            CEO &amp; Founder<br />
			randomsite.com
            </div><br clear="all" />
        <div id="quoteend"></div><br clear="all" />
        <div class="seperator"></div>
        <div class="form">
        	<h3>Quick contact</h3>
            This form is not coded, you will need to most likely configure a serverside script to make this emailer work! 
            <br /><br />
            <label for="form_name">Name</label>
            <input type="text" id="form_name" value="John Smith" /> 
            <label for="form_email">Contact Method</label>
            <input type="text" name="email" id="form_email" value="hello@aim.com" />      
            <label for="form_comments">Message</label> 
            <textarea id="form_comments" rows="4" cols="22">I would like to request your services</textarea>
            <button value="Submit" class="send_button" onclick="this.form.submit();">SUBMIT</button>
            <br clear="all" />
        </div>
        <div id="content">
        </div> -->