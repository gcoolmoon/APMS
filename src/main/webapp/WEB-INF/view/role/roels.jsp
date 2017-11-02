<%@ include file = "../header.jsp" %>
<div class="row no-margin">		
	<div class="alert alert-success" id="addAlert">
	  <strong>Success!</strong> <span id="addMsg">${message}</span>
	</div>
	<div class="row">
		<h2 class="main-title">Roles</h2>
	</div>	
	<div class="row projects space-sm">
	<table class="tg">
			<tr>
				<th width="80">Role Id</th>
				<th width="120">Role</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
		<c:forEach items="${roles}" var="userRole">
				<tr>
					<td>${userRole.id}</td>
					<td>${userRole.role}</td>
					<td><a href="<c:url value='/role/edit/${userRole.id}' />">Edit</a></td>
					<td><a href="<c:url value='/role/remove/${userRole.id}' />">Delete</a></td>
				</tr>	
			
		</c:forEach>
				<!-- Modal -->
			
	</div>	
</div>
<%@ include file = "../footer.jsp" %>