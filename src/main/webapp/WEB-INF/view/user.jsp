<%-- <%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<%@include file="header.jsp" %>

		<div class="well lead"> User Registration Form </div>
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
					<form:select path="userRoles" multiple="true" >
					
<%-- 					  <form:option value=0 label="--- Select ---"/>path="userRoles"  value="${userRoles}" selected="${userRoles}"  --%>

					<c:choose>
						<c:when test="${user.firstName != null}">
						
  					 <form:options  itemValue="id" itemLabel="role" items="${user.userRoles}" />
						</c:when>
						<c:otherwise>
  					 <form:options  itemValue="id" itemLabel="role" items="${roles}" />
  					 </c:otherwise>
					</c:choose>
<%-- 						<form:select path="userRoles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" /> --%>
						</form:select>
						<div class="has-error">
							<form:errors path="userRoles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${user.firstName!= null}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/users' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/users' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	
	<br>
	<h3>Users List</h3>
	<c:if test="${!empty listUsers}">
		<table class="tg">
			<tr>
				<th width="80">Employee Id</th>
				<th width="120">First Name</th>
				<th width="120">Last Name</th>
				<th width="120">Email</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.employeeId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td><a href="<c:url value='/user/edit/${user.id}' />">Edit</a></td>
					<td><a href="<c:url value='/user/remove/${user.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
<%@include file="footer.jsp" %>