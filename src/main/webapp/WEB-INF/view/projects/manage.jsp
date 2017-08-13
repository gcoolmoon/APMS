<%@ include file = "../header.jsp" %>
<div class="row no-margin manage-projects">	
	<div class="row clearfix">
		<h2 class="main-title">Projects
		<a href="/projects/new" class="pull-right btn btn-sm green-btn white-txt">Add New</a></h2>
	</div>	
	<table class="table table-striped space-sm">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>No. of Features:</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>${project.name}</td>
				<td>${project.description}</td>
				<td>${project.startDate}</td>
				<td>${project.endDate}</td>
				<td class="green-txt">${project.features.size()}</td>
				<td>
					<button class="btn btn-sm btn-warning" title="edit"><span class="glyphicon glyphicon-edit"></span></button>
					<button class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file = "../footer.jsp" %>	