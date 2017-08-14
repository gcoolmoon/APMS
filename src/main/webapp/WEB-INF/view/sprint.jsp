<%@ include file = "header.jsp" %>
<div class="row no-margin">		
	<h1>Add a Sprint</h1>

	<c:url var="addAction" value="/sprint/add"></c:url>

	<form:form action="${addAction}" commandName="sprint">
		<table>
			<c:if test="${!empty sprint.release}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8" disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="sprint">
						<spring:message text="Sprint" />
					</form:label></td>
				<td><form:input path="sprint" /></td>
			</tr>
			<tr>
				<td><form:label path="release">
						<spring:message text="Release" />
					</form:label></td>
				<td><form:input path="release" /></td>
			</tr>
			<tr>
				<td><form:label path="startDate">
						<spring:message text="StartDate" />
					</form:label></td>
				<td><form:input path="startDate" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">
						<spring:message text="Enddate" />
					</form:label></td>
				<td><form:input path="endDate" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><c:if test="${!empty sprint.release}">
						<input type="submit" value="<spring:message text="Edit Sprint"/>" />
					</c:if> <c:if test="${empty sprint.release}">
						<input type="submit" value="<spring:message text="Add Sprint"/>" />
					</c:if></td>
			</tr>
		</table>
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
					<td><a href="<c:url value='/sprint/edit/${sprint.id}' />">Edit</a></td>
					<td><a href="<c:url value='/sprint/remove/${sprint.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<%@ include file = "footer.jsp" %>