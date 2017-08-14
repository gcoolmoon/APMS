<%@ include file = "../header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<td><a href="/Backlog/${project.projectId}" class="green-txt">${project.name}</a></td>
				<td>${project.description}</td>
				<td>${project.startDate}</td>
				<td>${project.endDate}</td>
				<td class="green-txt">${project.features.size()}</td>
				<td>
					<a data-toggle="modal" data-pid="${project.projectId}" href="#addFeatureModal" class="addFeature btn btn-sm btn-success" title="add feature"><span class="glyphicon glyphicon-plus"></span></a>
					<a class="btn btn-sm btn-warning" href="/projects/edit/${project.projectId}" title="edit"><span class="glyphicon glyphicon-edit"></span></a>
					<a href="/projects/delete/${project.projectId}" id="deleteProject" class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- Modal -->
	  <div class="modal fade" id="addFeatureModal" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="green-txt"><span class="glyphicon glyphicon-plus"></span> Add Feature</h4>
	        </div>
	        <div class="modal-body">
	          <form:form class="form-horizontal" method="POST" action="/projects/addFeature" modelAttribute="feature">
				  <div class="form-group">
				    <form:label class="control-label col-sm-2" path="title">Feature Title:</form:label>
				    <div class="col-sm-10">
				      <form:input type="text" class="form-control" path="title" placeholder="Enter feature title" required="required" />
				    </div>
				  </div>
				  <div class="form-group">
				    <form:label class="control-label col-sm-2" path="description">Description:</form:label>
				    <div class="col-sm-10"> 
				      <form:textarea class="form-control" path="description" placeholder="Enter description" required="required"></form:textarea>
				    </div>
				  </div>
				  <div class="form-group">
					  <div class="col-sm-6">
					  <form:label class="control-label col-sm-4" path="priority">Priority:</form:label>
					    <div class="col-sm-8">
					      <form:select class="form-control" path="priority">
					      	<form:option value="LOW">LOW</form:option>
					      	<form:option value="AVERAGE" selected="selected">AVERAGE</form:option>
					      	<form:option value="HIGH">HIGH</form:option>
					      </form:select>
					    </div>
					  </div>
				  </div>
				  <input type="hidden" id="addFeatureSubmit" name = "pid"/>
	            <button type="submit" class="btn btn-default btn-success btn-block green-btn"><span class="glyphicon glyphicon-plus"></span>Add</button>
	          </form:form>
	        </div>
	      </div>
	    </div>
	  </div> 
</div>
<%@ include file = "../footer.jsp" %>	