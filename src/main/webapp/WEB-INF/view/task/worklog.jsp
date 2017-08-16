<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<div class="row">


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>
					Work Logged for backlog <strong> ${backlog.feature.title}</strong>
					<a href="/Task/${backlog.id}" style="float:right">Goto Task</a>
				</h4>
				<div>
					<input type="hidden" value="${backlog.id}" id="backlogId" /> <a
						href="#addWorklog" data-toggle="modal" id="backlogIdRef"
						class="btn btn-default-btn-xs btn-success addNewWorklog"
						data-backlogId="${backlog.id}"><i
						class="glyphicon glyphicon-plus"></i>New</a>
				</div>
				<div class="table-responsive">

					<table id="mytable" class="table table-bordred table-striped">

						<thead>
							<th>DATE</th>
							<th>Logged By</th>
							<th>WORKED ON</th>
							<th>DESCRIPTION</th>
							<th>HOUR LOGGED</th>
							<th>ACTION</th>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<c:forEach var="worklog" items="${task.getWorkLog()}">
									<tr>
										<td>${worklog.loggedDate}</td>
										<td>${worklog.teamMember.user.firstName} ${worklog.teamMember.user.lastName}
										<td>${task.title}</td>
										<td>${worklog.description}</td>
										<td>${worklog.hourLogged }</td>
										<td><p data-placement="top" data-toggle="tooltip"
												title="Edit">
												<button class=" updWorklog btn btn-primary btn-xs"
													class="updWorklog" name="${worklog.id}" data-title="Edit"
													data-toggle="modal" class="updWorklog"
													data-target="#updateWorklog" data-taskId="${task.id}">
													<span class="glyphicon glyphicon-pencil"></span>
												</button>
												<button class=" delWKlog btn btn-danger btn-xs"
													name="${worklog.id}"
														data-title="Delete" data-toggle="modal"
														data-target="#delWorklog">
														<span class="glyphicon glyphicon-trash"></span>
												</button>
												<%-- <span data-placement="top" data-toggle="tooltip"
													title="Delete">
													<button class=" deleteWorklog btn btn-danger btn-xs"
														name="${worklog.id}"
														data-title="Delete" data-toggle="modal"
														data-target="#delWorklog">
														<span class="glyphicon glyphicon-trash"></span>
													</button>
												</span> --%>
											</p></td>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>

					</table>

				</div>

			</div>
		</div>
	</div>


	<!-- Add Worklog Section -Start-->
	<div class="row">
		<form class="form-horizontal" id="addWorklogForm" method="post">
			<div class="modal fade" id="addWorklog" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add WorkLog</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<div class="form-group required">
									<label for="taskListDiv"
										class="control-label col-md-2  requiredField">Task<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8" id="taskListDiv">

										<select class="form-control" id="taskTitOption">
										</select>

									</div>
								</div>

								<div class="form-group required">
									<label for="logDescription"
										class="control-label col-md-2  requiredField">Description<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="logDescription" maxlength="30" name="description"
											placeholder="Add Description" style="margin-bottom: 10px"
											type="text" />
									</div>
								</div>
								<div class="form-group required">
									<label for="loggedHour"
										class="control-label col-md-2  requiredField">Hour<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="loggedHour" maxlength="30" name="hourLogged"
											placeholder="Add Hour" style="margin-bottom: 10px"
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
	<!-- Add Worklog Section -End-->


	<!-- Edit Starts here -->
	<div class="modal fade" id="updateWorklog" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 id="featureTitle" class="modal-title">Update Worklog</h4>
				</div>

				<form id="updWorklogForm" action="/updateWorklog/" method="post">
					<div class="modal-body">
						<p id="wlTitle">WorkLog Title</p>
						<hr />
						<input id="taskIdVal" type="hidden" name="taskId" value="" />
						<div class="row">
							<div class="col-md-4">
								<label for="wldate">Logged Date : </label> <input type="text"
									id="wldate" name="loggedDate" value="" />
							</div>
							<div class="col-md-4">
								<label for="wldesc">Description : </label> <input type="text"
									id="wldesc" name="description" value="" />
							</div>
							<div class="col-md-4">
								<label for="wlhour">Hour : </label> <input type="text"
									id="wlhour" name="hourLogged" value="" />
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
		<!-- /.modal-dialog -->
	</div>
	<!-- Edit Ends here -->


	<!-- Delete Worklog Section START -->
	<form id="delWorklogForm" action="/deleteWorklog/" method="post">
		<div class="modal fade" id="delWorklog" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
						<h4 class="modal-title custom_align" id="Heading">Delete this
							worklog entry</h4>
					</div>
					<div class="modal-body">

						<div class="alert alert-danger">
							<span class="glyphicon glyphicon-warning-sign"></span> Are you
							sure you want to delete this Record?
						</div>

					</div>
					<div class="modal-footer ">
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-ok-sign"></span> Yes
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> No
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</form>
</div>


<jsp:include page="../footer.jsp" />