<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header.jsp" %>
<div class="row no-margin">		
	<h1>Add a Release</h1>

	<c:url var="addAction" value="/release/add"></c:url>

	<form:form action="${addAction}" commandName="release">
			<c:if test="${!empty release.description}">
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="releaseId"  for="id">Id</form:label>
					<div class="col-md-7">
						<form:input type="text" path="releaseId" id="id" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="releaseId" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
			</c:if>
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable"  path="version"  for="version">Release Version</form:label>
					<div class="col-md-7">
						<form:input type="text" path="version" id="version" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="version" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:label class="col-md-3 control-lable" path="description"  for="description">Description</form:label>
					<div class="col-md-7">
						<form:input type="text" path="description" id="description" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="description" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" path="releaseDate"  for="releaseDate">Release Date</label>
					<div class="col-md-7">
						<form:input type="date" path="releaseDate" id="releaseDate" value="${release.releaseDate}" pattern="yyyy-MM-dd"  class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="releaseDate" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${!empty release.description}">
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
	<h3>Releases List</h3>
	<c:if test="${!empty listReleases}">
		<table class="tg">
			<tr>
				<th width="80">Release Id</th>
				<th width="120">Release Version</th>
				<th width="120">Release Release Date</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listReleases}" var="release">
				<tr>
					<td>${release.releaseId}</td>
					<td>${release.version}</td>
					<td>${release.releaseDate}</td>
					<td><a href="<c:url value='/release/edit/${release.releaseId}' />">Edit</a></td>
					<td><a href="<c:url value='/release/remove/${release.releaseId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<%@ include file = "footer.jsp" %>