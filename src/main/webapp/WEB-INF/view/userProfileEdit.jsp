<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>

<div class="well lead">Edit USER Profile</div>
<form:form method="POST" value ="/userProfile/Edit/" modelAttribute="user" class="form-horizontal">
	<form:input type="hidden" path="id" id="id" />
    <form:input type="hidden" path="userRoles" id="UserRoles" />
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="firstName">First
				Name</label>
			<div class="col-md-7">
				<form:input type="text" path="firstName" id="firstName"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="firstName" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="lastName">Last
				Name</label>
			<div class="col-md-7">
				<form:input type="text" path="lastName" id="lastName"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="lastName" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="employeeId">Employee
				ID</label>
			<div class="col-md-7">

				<form:input type="text" path="employeeId" id="employeeId"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="employeeId" class="help-inline" />
				</div>

			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="email">Email</label>
			<div class="col-md-7">
				<form:input type="text" path="email" id="email"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="email" class="help-inline" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="password">Password</label>
			<div class="col-md-7">
				<form:input type="password" path="password" id="password"
					class="form-control input-sm" />
				<div class="has-error">
					<form:errors path="password" class="help-inline" />
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-actions floatRight">
			
					<input type="submit" value="Update" class="btn btn-primary btn-sm" /> or <a
						href="<c:url value='/userprofile' />">Cancel</a>
				
		</div>
	</div>
</form:form>


</body>
<%@include file="footer.jsp"%>