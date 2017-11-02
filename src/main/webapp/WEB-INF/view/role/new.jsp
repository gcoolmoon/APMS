<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="row no-margin new-project">	
	<div class="row">
		<h2 class="main-title">Add New Role</h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<form:form class="form-horizontal" method="POST" action="/role/new" modelAttribute="userRole">
			  <div class="form-group">
			    <form:label class="control-label col-sm-2" path="name">Role :</form:label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="name" placeholder="Enter project name" required="required" />
			    </div>
			  </div>
			 
			  <div class="form-group space-lg"> 
			  	<div class="text-center">
			      <button type="submit" class="btn btn-default green-btn">DONE</button>
			  	</div>
			  </div>
			</form:form>
		</div>
	</div>
</div>
<%@ include file = "../footer.jsp" %>	