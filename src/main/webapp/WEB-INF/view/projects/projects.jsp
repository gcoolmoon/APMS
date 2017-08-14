<%@ include file = "../header.jsp" %>
<div class="row no-margin">		
	<div class="alert alert-success" id="addAlert">
	  <strong>Success!</strong> <span id="addMsg">${message}</span>
	</div>
	<div class="row">
		<h2 class="main-title">Projects</h2>
	</div>	
	<div class="row projects space-sm">
		<c:forEach items="${projects}" var="project">
			<% project.features.size(); %>
			<div class="col-sm-4 green-txt">
				<div class="text-center">
					<h4><a href="#" class="green-txt upper">${project.name}</a></h4>
					<div class="chart" data-percent="75">
						<span>75%<br>completed</span>
					</div>
					<p>
						${project.description}
					</p>
					<p class="grey-txt no-margin">Start Date: ${project.startDate}</p>
					<p class="grey-txt no-margin">End Date: ${project.endDate}</p>
					<p class="grey-txt no-margin">No. of Features: <span class="green-txt">${project.features.size()}</span> </p>
				</div>
			</div>
		</c:forEach>
	</div>	
</div>
<%@ include file = "../footer.jsp" %>