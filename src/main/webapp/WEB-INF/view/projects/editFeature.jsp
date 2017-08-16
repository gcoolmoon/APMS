<%-- <%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="row no-margin new-project">	
	<div class="row">
		<h2 class="main-title">Edit Your Feature <small class="green-txt">: ${feature.title}</small></h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<div class="modal-body">
	          <form:form class="form-horizontal" method="POST" action="/projects/features/edit" modelAttribute="feature">
			   	  <form:input type="hidden" value="${feature.featureId}" path="featureId" />
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
					  <div class="col-sm-6">
					  <form:label class="control-label col-sm-4" path="status">Status:</form:label>
					    <div class="col-sm-8">
					      <form:select class="form-control" path="status">
					      	<form:option value="OPEN">OPEN</form:option>
					      	<form:option value="COMPLETED">COMPLETED</form:option>
					      	<form:option value="ON_HOLD">ON_HOLD</form:option>
					      	<form:option value="IN_PROGRESS">IN_PROGRESS</form:option>
					      </form:select>
					    </div>
					  </div>
				  </div>
				  <div class="form-group space-lg"> 
				  	<div class="text-center">
				      <a href="/projects/edit/${feature.project.projectId}" class="btn btn-default green-btn">BACK</a>
				      <button type="submit" class="btn btn-default green-btn">DONE</button>
				  	</div>
				  </div>
	          </form:form>
	        </div>
		</div>
	</div>
</div>
<%@ include file = "../footer.jsp" %>	