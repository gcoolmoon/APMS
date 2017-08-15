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
		<div class="login-form register-form">
			<div>
				<h3 class="main-title green-txt"><small class="glyphicon glyphicon-lock"></small>Register Here</h3>
			</div>				
			<form:form method="POST" modelAttribute="user" class="form-horizontal">
				<form:input type="hidden" path="id" id="id"/>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="firstName">First Name</label>
						<div class="col-md-7">
							<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
							<div class="has-error">
								<form:errors path="firstName" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="lastName">Last Name</label>
						<div class="col-md-7">
							<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="lastName" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="employeeId">Employee ID</label>
						<div class="col-md-7">
							<c:choose>
								<c:when test="${edit}">
									<form:input type="text" path="employeeId" id="employeeId" class="form-control input-sm" disabled="true"/>
								</c:when>
								<c:otherwise>
									<form:input type="text" path="employeeId" id="employeeId" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="employeeId" class="help-inline"/>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="password">Password</label>
						<div class="col-md-7">
							<form:input type="password" path="password" id="password" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="password" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="email">Email</label>
						<div class="col-md-7">
							<form:input type="text" path="email" id="email" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="userRoles">Roles</label>
						<div class="col-md-7">
						<form:select path="userRoles" multiple="true" class="form-control input-sm" >
						
	<%-- 					  <form:option value=0 label="--- Select ---"/> --%>
	  					 <form:options itemValue="id" itemLabel="type" items="${roles}" />
	<%-- 						<form:select path="userRoles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" /> --%>
							</form:select>
							<div class="has-error">
								<form:errors path="userRoles" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="form-actions floatRight text-center">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="UPDATE" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="REGISTER" class="btn green-btn btn-sm"/> or <a class="btn red-btn btn-sm" href="/">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
		<div class="bottom-style"></div>
    </div>
</body>
</html>
