<%@ include file = "header.jsp" %>
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
			<th>Completed</th>
			<th>Action</th>
		</tr>
		<tr>
			<td>some name</td>
			<td>some name</td>
			<td>some name</td>
			<td>some name</td>
			<td class="green-txt">10%</td>
			<td>
				<button class="btn btn-sm btn-warning" title="edit"><span class="glyphicon glyphicon-edit"></span></button>
				<button class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></button>
			</td>
		</tr>
		<tr>
			<td>some name</td>
			<td>some name</td>
			<td>some name</td>
			<td>some name</td>
			<td class="green-txt">50%</td>
			<td>
				<button class="btn btn-sm btn-warning" title="edit"><span class="glyphicon glyphicon-edit"></span></button>
				<button class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></button>
			</td>
		</tr>
	</table>
</div>
<%@ include file = "footer.jsp" %>	