<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="row no-margin new-project">	
	<div class="row">
		<h2 class="main-title">Add New Project</h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<form:form class="form-horizontal" method="POST" action="/projects/new" modelAttribute="project">
			  <div class="form-group">
			    <form:label class="control-label col-sm-2" path="name">Project Name:</form:label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="name" placeholder="Enter project name" required="required" />
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
				  <form:label class="control-label col-sm-4" path="startDate">Start Date:</form:label>
				    <div class="col-sm-8">
				      <form:input type="date" class="form-control" path="startDate" required="required" />
				    </div>
				  </div>
				  <div class="col-sm-6">
				    <form:label class="control-label col-sm-4" path="endDate">End Date:</form:label>
				    <div class="col-sm-8">
				      <form:input type="date" class="form-control" path="endDate" required="required" />
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
	</div>
</div>
<%@ include file = "../footer.jsp" %>	