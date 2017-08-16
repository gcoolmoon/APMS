<%-- <%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>

<div class="well lead">User Profile</div>
<form:form method="POST" modelAttribute="user" class="form-horizontal">
	<form:input type="hidden" path="id" id="id" />
	<table class="table table-user-information">
		<tbody>
			<tr>
				<td>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="employeeId">User
								Id : ${user.employeeId}</label>

						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="firstName">First
								Name : ${user.firstName}</label>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="lastName">Last
								Name : ${user.lastName}</label>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="row">
						<div class="form-group col-md-2">
							<label class="col-md-3 control-lable" for="userRoles">Roles:
							</label>
						</div>
					</div> <c:forEach var="userRole" items="${user.userRoles}">
						<label class="col-md-3"> ${userRole.role} </label>
					</c:forEach>
				</td>

			</tr>
		</tbody>
	</table>
		<div class="row">
			<div class="form-actions floatRight">
<!-- 				<input type="submit" value="Update" class="btn btn-primary btn-sm" /> -->
				<a class="btn btn-primary btn-sm" href="<c:url value='/userprofileedit/${user.id}' />"> Edit</a></td>
			</div>
		</div>

</form:form>

</body>
<%@include file="footer.jsp"%>