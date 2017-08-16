<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>APMS</title>
	<link type="text/css" rel="stylesheet" href="/bootstrap-3.0.3/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="/css/main.css"/>
	
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/bootstrap-3.0.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>	
</head>
<body>
	<div class="container-fluid login-wrapper">
		<div class="mainmenu-area">
			<nav class="navbar navbar-default">
			  <div class="container-fluid clearfix">
			    <div class="navbar-header logo">
			      <strong><a class="navbar-brand" href="#">APMS</a></strong>
			    </div>
			    <ul class="nav navbar-nav pull-right">
		            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Sign Up</a></li>
			    </ul>
			  </div>
			</nav>
	    </div> <!-- End mainmenu area -->
		<img alt="background" src="/images/login-bg.jpg">
		<div class="login-form">
			<div>
				<h3 class="main-title green-txt"><small class="glyphicon glyphicon-lock"></small>Login Here</h3>
			</div>			
			<form:form class="form-horizontal" method="POST" action="#">
				<div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="text" class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="form-group">
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
            <button type="submit" class="btn btn-default green-btn btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
            </div>
			</form:form>
		</div>
		<div class="bottom-style"></div>
    </div>
</body>
</html>
