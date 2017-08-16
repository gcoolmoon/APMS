<%-- <%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("/");
	}
%> --%>
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
					<h4 class="boardTitle">
						Showing Task Board for Backlog <strong>${backlog.feature.title}</strong> 
						
						<a href="/Backlog/${backlog.id}" style="float:right">Goto Backlog</a>
					</h4>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab1default">
						<input type="hidden" value="${backlog.id}" id="task_id" />

						<div>
							<a href="#addTask" data-toggle="modal"
								class="btn btn-default-btn-xs btn-success addNewTask"
								data-backlogId="${backlog.id}"><i
								class="glyphicon glyphicon-plus"></i>New</a>
						</div>
						<!-- Task -Box -Start-->
						<c:forEach var="task" items="${tasks}">

							<c:if test="${task.status == 'OPEN'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/WorkLog/${backlog.id}">${task.title}</a>
										</h4>
										<p>${task.description}</p>
										<p>
											<a href="#" data-toggle="tooltip" data-placement="top" title="Assignee">${task.teamMember.user.firstName} ${task.teamMember.user.lastName} </a>
										</p>
										<ul class="list-inline list-unstyled">
											<span data-toggle="tooltip" data-placement="top"
												title="Hour Logged"><i
												class="glyphicon glyphicon glyphicon-time"></i> <c:set
													var="total" value="${0}" /> <c:forEach var="worklog"
													items="${task.workLog}">
													<c:set var="total" value="${total + worklog.hourLogged}" />
												</c:forEach> ${total}H |</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${task.status}
											</span>
										</ul>
										<p>

											<a data-toggle="modal" href="#assignMember"
												class="assignTask" name="${task.id}"
												data-backlogid="${backlog.id}">Assign |</a> <a
												data-toggle="modal" href="#updateTask" class="updTask"
												name="${task.id}" data-backlogid="${backlog.id}">Update
												|</a> <span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delTask" name="${task.id}" href="#deleteTask">
													Delete</a></span>
										</p>

									</div>
								</div>
							</c:if>
							<!-- Task-Box-End -->
						</c:forEach>

					</div>
					<div class="tab-pane fade" id="tab2default">

						<!-- Task -Box -Start-->
						<c:forEach var="task" items="${tasks}">

							<c:if test="${task.status == 'IN_PROGRESS'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/WorkLog/${task.id}">${task.title}</a>
										</h4>
										<p>${task.description}</p>
										<p>
											<a href="#" data-toggle="tooltip" data-placement="top" title="Assignee">${task.teamMember.user.firstName} ${task.teamMember.user.lastName} </a>
										</p>
										<ul class="list-inline list-unstyled">
											<span data-toggle="tooltip" data-placement="top"
												title="Hour Logged"><i
												class="glyphicon glyphicon glyphicon-time"></i> <c:set
													var="total" value="${0}" /> <c:forEach var="worklog"
													items="${task.workLog}">
													<c:set var="total" value="${total + worklog.hourLogged}" />
												</c:forEach> ${total}H |</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${task.status}
											</span>
										</ul>
										<p>
											<a data-toggle="modal" href="#assignMember"
												class="assignTask" name="${task.id}"
												data-backlogid="${backlog.id}">Assign |</a> <a
												data-toggle="modal" href="#updateTask" class="updTask"
												name="${task.id}" data-backlogid="${backlog.id}">Update
												|</a> <span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delTask" name="${task.id}" href="#deleteTask">
													Delete</a></span>
										</p>

									</div>
								</div>
							</c:if>
							<!-- Task-Box-End -->
						</c:forEach>

					</div>
					<div class="tab-pane fade" id="tab3default">

						<!-- Task -Box -Start-->
						<c:forEach var="task" items="${tasks}">

							<c:if test="${task.status == 'COMPLETED'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/WorkLog/${task.id}">${task.title}</a>
										</h4>
										<p>${task.description}</p>
										<p>
											<a href="#" data-toggle="tooltip" data-placement="top" title="Assignee">${task.teamMember.user.firstName} ${task.teamMember.user.lastName} </a>
										</p>
										<ul class="list-inline list-unstyled">
											<span data-toggle="tooltip" data-placement="top"
												title="Hour Logged"><i
												class="glyphicon glyphicon glyphicon-time"></i> <c:set
													var="total" value="${0}" /> <c:forEach var="worklog"
													items="${task.workLog}">
													<c:set var="total" value="${total + worklog.hourLogged}" />
												</c:forEach> ${total}H |</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${task.status}
											</span>
										</ul>
										<p>
											<a data-toggle="modal" href="#assignMember"
												class="assignTask" name="${task.id}"
												data-backlogid="${backlog.id}">Assign |</a> <a
												data-toggle="modal" href="#updateTask" class="updTask"
												name="${task.id}" data-backlogid="${backlog.id}">Update
												|</a> <span data-toggle="tooltip" data-placement="top"
												title="delete"> <a data-toggle="modal"
												class="delTask" name="${task.id}" href="#deleteTask">
													Delete</a></span>
										</p>

									</div>
								</div>
							</c:if>
							<!-- Task-Box-End -->
						</c:forEach>

					</div>
				</div>
				<!-- Tab-Content -->
			</div>
		</div>

	</div>


	<!-- Add Task Section -Start-->
	<div class="row">
		<form class="form-horizontal" id="addTaskForm"
			action="/addTask/${backlog.id}" method="post">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
			<div class="modal fade" id="addTask" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">
								Add Task for Backlog: <strong>${backlog.feature.title}</strong>
							</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<div class="form-group required">
									<label for="taskTitle"
										class="control-label col-md-2  requiredField">Title<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="taskTitle" maxlength="30" name="title"
											placeholder="Add Title" style="margin-bottom: 10px"
											type="text" />
									</div>
								</div>

								<div class="form-group required">
									<label for="taskDescription"
										class="control-label col-md-2  requiredField">Task
										Description<span class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="taskDescription" maxlength="30" name="description"
											placeholder="Add Description" style="margin-bottom: 10px"
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
	<!-- Add Task Section -End-->

	<!-- Update Task Section -Start -->
	<div class="modal fade" id="updateTask" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 id="backlogTitle" class="modal-title">Update Task</h4>
				</div>

				<form id="updTaskForm" action="/updateTask/" method="post">
					<div class="modal-body">
					<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
						<p id="taskTitle1">Task Title</p>
						<input type="hidden" id="tskTitle" name="title" value="" />
						<input type="hidden" id="tmIdval" name="teamMember" value="" />
						<hr />

						<input id="taskIdVal" type="hidden" name="taskId" value="" />
						<div class="row">

							<div class="col-md-4">
								<label for="taskDescription1">Description : </label> <input
									type="text" id="taskDescription1" name="description" value="" />
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

		</div>
	</div>
	<!-- End Update Task -->

	<!-- Delete Task Section START -->
	<form id="delTaskForm" action="/deleteTask/" method="post">
	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		<div class="modal fade" id="deleteTask" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
						<h3>Delete</h3>
					</div>
					<div class="modal-body">
						<p>You are about to delete a Task.</p>
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
	<!-- END Delete Task Section -->

	<!-- Assign Task Section START -->
	<form id="assignTaskForm" action="/assignTask/" method="post">
	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		<div class="modal fade" id="assignMember" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
						<h3>Assign Task</h3>
					</div>
					<div class="modal-body">

						<label for="backlogTitle"
							class="control-label col-md-2  requiredField">Select
							Assignee<span class="asteriskField">*</span>
						</label>

						<div class="controls col-md-8" id="assigneeListDiv">

							<select class="form-control" id="assignMemberOption">
								<c:forEach var="team" items="${teams}">
									<option class="teamMemberId" value="${team.id}">${team.user.firstName}
										${team.user.lastName}</option>
								</c:forEach>
							</select>

						</div>
						<br />

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-success">Save</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- END Assign Task Section -->

</div>


<jsp:include page="../footer.jsp" />