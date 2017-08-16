<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<div class="row">

	<!-- NavBar -->
	<div class="row">
		<div class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs">
					<li class="active"><a id="addForm" href="#tab1default"
						data-toggle="tab">Open</a></li>
					<li><a href="#tab2default" data-toggle="tab">In Progess</a></li>
					<li><a href="#tab3default" data-toggle="tab">Done</a></li>
					<h4 class="boardTitle">Backlog Items</h4>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab1default">
						<input type="hidden" value="${projectId}" id="project_id" />

						<div>
							<a href="#addBacklog" data-toggle="modal"
								class="btn btn-default-btn-xs btn-success addNewBacklog"
								data-projectId="${projectId}"><i
								class="glyphicon glyphicon-plus"></i>New</a>
						</div>
						<!-- Backlog -Box -Start-->
						<c:forEach var="backlog" items="${backlogs}">

							<c:if test="${backlog.status == 'OPEN'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/Task/${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>

										<div>
											<p>
												<a name="${backlog.id}" data-toggle="modal"
													href="#teamMember" class="viewTeams" name="${backlog.id}">Team
													Members</a>

											</p>
										</div>

										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated} H | </span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}
												| </span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status} |
											</span>
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Spent"><span><i
													class="glyphicon glyphicon-time"></i> <c:set
														var="totalhourspent" value="${0}" /> <c:forEach
														var="task" items="${backlog.taskList}">
														<c:forEach var="worklog" items="${task.workLog}">
															<c:set var="totalhourspent"
																value="${totalhourspent + worklog.hourLogged}" />
														</c:forEach>
													</c:forEach> ${totalhourspent} </span></li>

										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}">Update |</a>

											<span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delBacklog" name="${backlog.id}"
												href="#deleteBacklog"> Delete | </a></span> <a
												href="/WorkLog/${backlog.id}"><span
												data-toggle="tooltip" data-placement="top" title="Worklog">
													<i class="glyphicon glyphicon-eye-open"></i> View WorkLog
											</span> </a>
										</p>

									</div>
								</div>
							</c:if>
							<!-- Backlog-Box-End -->
						</c:forEach>

					</div>
					<div class="tab-pane fade" id="tab2default">

						<!-- Backlog -Box -Start-->
						<c:forEach var="backlog" items="${backlogs}">

							<c:if test="${backlog.status == 'IN_PROGRESS'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/Task/${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>
										<div>
											<p>
												<a data-toggle="modal" href="#teamMember" class="viewTeams"
													name="${backlog.id}">Team Members</a>
											</p>
										</div>
										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated} H | </span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}
												| </span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status} |
											</span>
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Spent"><span><i
													class="glyphicon glyphicon-time"></i> <c:set
														var="totalhourspent" value="${0}" /> <c:forEach
														var="task" items="${backlog.taskList}">
														<c:forEach var="worklog" items="${task.workLog}">
															<c:set var="totalhourspent"
																value="${totalhourspent + worklog.hourLogged}" />
														</c:forEach>
													</c:forEach> ${totalhourspent} </span></li>

										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}">Update |</a>

											<span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delBacklog" name="${backlog.id}"
												href="#deleteBacklog"> Delete | </a></span> <a
												href="/WorkLog/${backlog.id}"><span
												data-toggle="tooltip" data-placement="top" title="Worklog">
													<i class="glyphicon glyphicon-eye-open"></i> View WorkLog
											</span> </a>
										</p>
									</div>
								</div>
							</c:if>
							<!-- Backlog-Box-End -->
						</c:forEach>

					</div>
					<div class="tab-pane fade" id="tab3default">

						<!-- Backlog -Box -Start-->
						<c:forEach var="backlog" items="${backlogs}">

							<c:if test="${backlog.status == 'COMPLETED'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/Task/${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>
										<div>
											<p>
												<a data-toggle="modal" href="#teamMember" class="viewTeams"
													name="${backlog.id}">Team Members</a>
											</p>
										</div>
										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated} H | </span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}
												| </span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status} |
											</span>
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Spent"><span><i
													class="glyphicon glyphicon-time"></i> <c:set
														var="totalhourspent" value="${0}" /> <c:forEach
														var="task" items="${backlog.taskList}">
														<c:forEach var="worklog" items="${task.workLog}">
															<c:set var="totalhourspent"
																value="${totalhourspent + worklog.hourLogged}" />
														</c:forEach>
													</c:forEach> ${totalhourspent} </span></li>

										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}"> Update |</a>

											<span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delBacklog" name="${backlog.id}"
												href="#deleteBacklog"> Delete | </a></span> <a
												href="/WorkLog/${backlog.id}"><span
												data-toggle="tooltip" data-placement="top" title="Worklog">
													<i class="glyphicon glyphicon-eye-open"></i> View WorkLog
											</span> </a>
										</p>
									</div>
								</div>
							</c:if>
							<!-- Backlog-Box-End -->
						</c:forEach>

					</div>
				</div>
				<!-- Tab-Content -->
			</div>
		</div>

	</div>


	<!-- Add Backlog Section -Start-->
	<div class="row">
		<form class="form-horizontal" id="addBacklogForm" method="post">
			<div class="modal fade" id="addBacklog" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add Backlog</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<div class="form-group required">
									<label for="backlogTitle"
										class="control-label col-md-2  requiredField">Title<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8" id="featureListDiv">

										<select class="form-control" id="backlogTitOption">
										</select>

									</div>
								</div>

								<div class="form-group required">
									<label for="hourEstimated"
										class="control-label col-md-2  requiredField">Hour
										Estimated<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="hourEstimated" maxlength="30" name="hourEstimated"
											placeholder="Add Estimated Hour" style="margin-bottom: 10px"
											type="text" />
									</div>
								</div>

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- Add Backlog Section -End-->

	<!-- Update Backlog Section -Start -->
	<div class="modal fade" id="updateBacklog" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 id="featureTitle" class="modal-title">BacklogItem
						${projectId}</h4>
				</div>

				<form id="updBacklogForm" action="/updateBacklog/" method="post">
					<div class="modal-body">
						<p id="featureDescription">Backlog Description</p>
						<hr />
						<input id="featureIdVal" type="hidden" name="featureId" value="" />
						<div class="row">

							<div class="col-md-4">
								<p id="blPriority"></p>
							</div>

							<div class="col-md-4">
								<label for="estimatedHour">Estimated Hour : </label> <input
									type="text" id="estimatedHour" name="hourEstimated" value="" />
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="selStatus">Status:</label> <select
										class="form-control" id="selStatus" name="status">
										<option value="OPEN">OPEN</option>
										<option value="IN_PROGRESS">IN_PROGRESS</option>
										<option value="COMPLETED">COMPLETED</option>
									</select>
								</div>
							</div>

						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">Save</button>
					</div>
				</form>
			</div>
			<!-- model content  -->

		</div>
	</div>
	<!-- End Update Backlog -->

	<!-- Delete Backlog Section START -->
	<form id="delBacklogForm" action="/deleteBacklog/" method="post">
		<div class="modal fade" id="deleteBacklog" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
						<h3>Delete</h3>
					</div>
					<div class="modal-body">
						<p>You are about to delete a Backlog item.</p>
						<p>Do you want to proceed?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
						<button type="submit" class="btn btn-danger">Yes</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- END Delete Backlog Section -->


	<!-- Team Member START -->
	<div class="modal fade" id="teamMember" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
					<h3>Member Detail</h3>
				</div>
				<div class="modal-body">
					<table id="tblMember" class="pull-left col-md-8 ">
						<thead>
							<tr>
								<td>Name</td>
								<td>Role</td>
							</tr>
						</thead>
						<tbody id="memberTbody">
							<tr>
								<td class="h6"><strong>Name</strong></td>
								<td class="h5">Dinesh</td>
							</tr>
							<tr>
								<td class="h6"><strong>Position</strong></td>
								<td class="h5">Developer</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>

	</div>
	<!-- END Team Member Section -->

</div>


<jsp:include page="../footer.jsp" />