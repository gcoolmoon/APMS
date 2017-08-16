<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ include file = "../header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row no-margin">		
	<div class="alert alert-success" id="addAlert">
	  <strong>Success!</strong> <span id="addMsg">${message}</span>
	</div>
	<div class="row">
		<h2 class="main-title">Projects</h2>
	</div>	
	<div class="row projects space-sm">
		<c:forEach items="${projects}" var="project">
			<% int count = 0; %>
			<c:forEach items="${project.features}" var="feature">
				<c:if test="${feature.status == 'COMPLETED'}">
					<% count = count+1; %>					
				</c:if>
			</c:forEach>
			<c:set var="size" value="${project.features.size()}" />
			<c:set var="c" value="<%= count*100 %>" />			
			<div class="col-sm-4 project-item">
				<div class="text-center green-txt">
					<h4><a href="/Backlog/${project.projectId}" class="green-txt upper">${project.name}</a></h4>
					<div class="chart" data-percent="${c/size}">
						<c:choose>
						    <c:when test="${size == 0}">
						        <span>0.0%<br>completed</span>
						    </c:when>
						    <c:otherwise>
								<span>
								<fmt:formatNumber value="${c/size}" type="number" pattern="0.00" />%
								<br>completed
								</span>
						    </c:otherwise>
						</c:choose>
					</div>
					<p>
						${project.description}
					</p>
					<p class="grey-txt no-margin">Start Date: ${project.startDate}</p>
					<p class="grey-txt no-margin">End Date: ${project.endDate}</p>
					<p class="grey-txt no-margin">No. of Features: <a data-pid="${project.projectId}" data-toggle="modal" href="#viewFeaturesModal" class="green-txt showFeatures">${project.features.size()}</a> </p>
				</div>
			</div>
		</c:forEach>
				<!-- Modal -->
				  <div class="modal fade" id="viewFeaturesModal" role="dialog">
				    <div class="modal-dialog">
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="green-txt">Features </h4>
				        </div>
				        <div class="modal-body">
				          <ul class="list-unstyled features-list" id="features-list">
				          	<!-- Dynamically generated -->
				          </ul>
				        </div>
				      </div>
				    </div>
				  </div> 
	</div>	
</div>
<%@ include file = "../footer.jsp" %>