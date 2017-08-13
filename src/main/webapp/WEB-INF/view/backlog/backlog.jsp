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
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab1default">
						<input type="hidden" value="${projectId}" id="project_id" />
						<!--  <h3>Backlog Items</h3>-->

						<!-- <div class="addNew" data-toggle="modal" data-target="#addBacklog"> -->
						<%-- <div id="addNewBacklog" class="addNewBacklog" name="${projectId}"> --%>
						<div>
							<a <%-- href="/addBacklog/${projectId}" --%>
								href="#addBacklog" data-toggle="modal"
								class="btn btn-default-btn-xs btn-success addNewBacklog" data-projectId = "${projectId}"><i
								class="glyphicon glyphicon-plus" ></i>New</a>
						</div>
						<!-- Backlog -Box -Start-->
						<c:forEach var="backlog" items="${backlogs}">

							<c:if test="${backlog.status == 'OPEN'}">
								<div class="col-md-4">
									<div class="well">
										<h4 class="media-heading">
											<a href="/Task/id=${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>
										<p>
											<a href="#">Team members</a>
										</p>
										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated}|</span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}|</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status}
											</span>
										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}">Update</a>
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
											<a href="/Task/id=${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>
										<p>
											<a href="#">Team members</a>
										</p>
										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated}|</span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}|</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status}
											</span>
										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}">Update</a>
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
											<a href="/Task/id=${backlog.id}">${backlog.feature.title}</a>
										</h4>
										<p>${backlog.feature.description}</p>
										<p>
											<a href="#">Team members</a>
										</p>
										<ul class="list-inline list-unstyled">
											<li data-toggle="tooltip" data-placement="top"
												title="Hour Estimated"><span><i
													class="glyphicon glyphicon-time"></i>
													${backlog.hourEstimated}|</span></li>
											<span data-toggle="tooltip" data-placement="top"
												title="Priority"><i
												class="glyphicon glyphicon glyphicon-pushpin"></i>${backlog.feature.priority}|</span>
											<span data-toggle="tooltip" data-placement="top"
												title="Status"> <i
												class="glyphicon glyphicon-eye-open"></i>${backlog.status}
											</span>
										</ul>
										<p>
											<a data-toggle="modal" href="#updateBacklog"
												class="updBacklog" name="${backlog.id}"
												data-featureid="${backlog.feature.featureId}"
												data-featuretitle="${backlog.feature.title}"
												data-featuredesc="${backlog.feature.description}"
												data-featureprio="${backlog.feature.priority}">Update</a>
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
								<!-- <div class="form-group required">
									<label for="description"
										class="control-label col-md-2  requiredField">Description<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="description" maxlength="30" name="description"
											placeholder="Add Description" style="margin-bottom: 10px"
											type="text" />
									</div>
								</div> -->
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
								<!-- <div class="form-group required">
									<label for="priority"
										class="control-label col-md-2  requiredField">Priority<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<select class="form-control" id="priority">
											<option>High</option>
											<option>Medium</option>
											<option>Low</option>
										</select>
									</div>
								</div> -->
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

		</div>
	</div>
	<!-- End Update Backlog -->

</div>


<jsp:include page="../footer.jsp" />