<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "../header.jsp" %>
<div class="row no-margin new-role">	
	<div class="row">
		<h2 class="main-title">Edit Users Role Types</h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<form:form class="form-horizontal" method="POST" action="/roles/new" modelAttribute="userRole">
			 <div class="form-group">
			    <form:label class="control-label col-sm-2" path="id">Role Id:</form:label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="id" placeholder="Enter Role " required="required" value="${userRole.role}" />
			    </div>
			  </div>
			  <div class="form-group">
			    <form:label class="control-label col-sm-2" path="role">Role Type:</form:label>
			    <div class="col-sm-10">
			      <form:input type="text" class="form-control" path="role" placeholder="Enter Role " required="required" value="${userRole.role}" />
			    </div>
			  </div>
			
			  <div class="form-group space-lg"> 
			  	<div class="text-center">
			      <a href="/role/manage" class="btn btn-default green-btn">BACK</a>
			      <button type="submit" class="btn btn-default green-btn">DONE</button>
			  	</div>
			  </div>
			</form:form>
		</div>
<!-- 		<div class="col-sm-12"> -->
<!-- 			<h4 class="main-title">List of Roles</h4> -->
<!-- 		</div>	 -->
<!-- 		<div class="col-sm-11 space-lg"> -->
<!-- 			<table class="table table-striped"> -->
<!-- 				<tr> -->
<!-- 					<th>Id</th>	 -->
<!-- 					<th>Role</th>	 -->
<!-- 				</tr> -->
<%-- 				<c:forEach items="${roles}" var="feature"> --%>
<!-- 					<tr> -->
<%-- 						<td>${feature.title}</td> --%>
<%-- 						<td>${feature.description}</td> --%>
<%-- 						<td>${feature.priority}</td> --%>
<%-- 						<td>${feature.status}</td> --%>
<!-- 						<td> -->
<%-- 							<a class="btn btn-sm btn-warning" href="/projects/features/edit/${feature.featureId}" title="edit"><span class="glyphicon glyphicon-edit"></span></a> --%>
<%-- 							<a href="/projects/features/delete/${feature.featureId}" id="deleteFeatureFromProject" class="btn btn-sm btn-danger" title="delete"><span class="glyphicon glyphicon-trash"></span></a> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->
<!-- 		</div> -->
	</div>
</div>
<%@ include file = "../footer.jsp" %>	