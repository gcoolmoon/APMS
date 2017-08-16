<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header.jsp" %>
<div class="row no-margin">		
	<h1>Add a Sprint</h1>

	<c:url var="addAction" value="/sprint/add"></c:url>

	<form:form action="${addAction}" modelAttribute="sprint" >
			<c:if test="${!empty sprint.release}">
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="sprintId"  for="sprintId">Id</form:label>
					<div class="col-md-7">
						<form:input type="text" path="sprintId" id="sprintId" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="sprintId" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
			</c:if>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="release" for="release">Release</form:label>
					<div class="col-md-7">
<%-- 					<c:if test="${!empty sprint.release}"> --%>
<%-- 						<form:select path="release" value="${sprint.release.releaseId}" > --%>
<%-- 						 <form:options  itemValue="releaseId" itemLabel="version" items="${releases}" /> --%>
<%-- 						</form:select> --%>
<%-- 					</c:if> --%>
					
					<form:select path="release" value='<c:if test="${!empty sprint.release}"> ${sprint.release.version }  </c:if>' >
			
					
<%-- 					  <form:option value=0 label="--- Select ---"/> --%>
  					 <form:options id="releaseId"  itemValue="releaseId" itemLabel="version" items="${releases}" />
<%-- 						<form:select path="userRoles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" /> --%>
						</form:select>
<%-- 						<form:select type="text" path="userRelease" id="userRelease" items="${rels}" itemValue="releaseId"  class="form-control input-sm"/> --%>
						<div class="has-error">
							<form:errors path="release" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="startDate"  for="startDate">Start Date</form:label>
					<div class="col-md-7">
						<form:input type="date" path="startDate" id="startDate" pattern="yyyy-MM-dd"  class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="startDate" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="endDate"  for="endDate">End Date</form:label>
					<div class="col-md-7">
						<form:input  type="date" path="endDate" id="endDate" pattern="yyyy-MM-dd"  class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="endDate" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='#' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='#' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
	</form:form>
	<br>
	<h3>Sprints List</h3>
	<c:if test="${!empty listSprints}">
		<table class="tg">
			<tr>
				<th width="80">Sprint</th>
				<th width="120">Release Version</th>
				<th width="120">Sprint Start Date</th>
				<th width="120">Sprint End Date</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listSprints}" var="sprint">
				<tr>
					<td>${sprint.sprintId}</td>
					<td>${sprint.release.version}</td>
					<td>${sprint.startDate}</td>
					<td>${sprint.endDate}</td>
					<td><a href="<c:url value='/sprint/edit/${sprint.sprintId}' />">Edit</a></td>
					<td><a href="<c:url value='/sprint/remove/${sprint.sprintId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
<%@ include file = "footer.jsp" %>