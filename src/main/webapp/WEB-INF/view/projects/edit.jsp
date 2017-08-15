<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="row no-margin new-project">	
	<div class="row">
		<h2 class="main-title">Edit Your Project <small class="green-txt">: ${project.name}</small></h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<form:form class="form-horizontal" method="POST" action="/projects/edit" modelAttribute="project">
			   <form:input type="hidden" value="${project.projectId}" path="projectId" />
			   <div class="form-group">
			    <form:label class="control-label col-sm-2" path="name">Project Name:</form:label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="name" placeholder="Enter project name" required="required" value="${project.name}" />
			    </div>
			  </div>
			  <div class="form-group">
			    <form:label class="control-label col-sm-2" path="description">Description:</form:label>
			    <div class="col-sm-10"> 
			      <form:textarea class="form-control" path="description" placeholder="Enter description" value="${project.description}" required="required"></form:textarea>
			    </div>
			  </div>
			  <div class="form-group">
				  <div class="col-sm-6">
				  <form:label class="control-label col-sm-4" path="startDate">Start Date:</form:label>
				    <div class="col-sm-8">
				      <form:input type="date" class="form-control" path="startDate" value="${project.startDate}" required="required" />
				    </div>
				  </div>
				  <div class="col-sm-6">
				    <form:label class="control-label col-sm-4" path="endDate">End Date:</form:label>
				    <div class="col-sm-8">
				      <form:input type="date" class="form-control" path="endDate" value="${project.endDate}" required="required" />
				    </div>
				  </div>
			  </div>
			  <div class="form-group space-lg"> 
			  	<div class="text-center">
			      <a href="/projects/manage" class="btn btn-default green-btn">BACK</a>
			      <button type="submit" class="btn btn-default green-btn">DONE</button>
			  	</div>
			  </div>
			</form:form>
		</div>
		<div class="col-sm-12">
			<h4 class="main-title">List of Features</h4>
		</div>	
		<div class="col-sm-11 space-lg">
			<table class="table table-striped">
				<tr>
					<th>Title</th>	
					<th>Description</th>	
					<th>Priority</th>	
					<th>Status</th>	
					<th>Action</th>	
				</tr>
				<c:forEach items="${project.features}" var="feature">
					<tr>
						<td>${feature.title}</td>
						<td>${feature.description}</td>
						<td>${feature.priority}</td>
						<td>${feature.status}</td>
						<td>
							<a class="btn btn-sm btn-warning" href="/projects/features/edit/${feature.featureId}" title="edit"><span class="glyphicon glyphicon-edit"></span></a>
							<a href="/projects/features/delete/${feature.featureId}" id="deleteFeatureFromProject" class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<%@ include file = "../footer.jsp" %>	