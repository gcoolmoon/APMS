<jsp:include page="header.jsp" />


<div class="row">


	<!-- NavBar -->
	<div class="row">
		<div class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab1default" data-toggle="tab">Open</a></li>
					<li><a href="#tab2default" data-toggle="tab">In Progess</a></li>
					<li><a href="#tab3default" data-toggle="tab">Done</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab1default">


						<!--  <h3>Backlog Items</h3>-->
						<div class="addNew" data-toggle="modal" data-target="#addBacklog">
							<a class="btn btn-default-btn-xs btn-success"><i
								class="glyphicon glyphicon-plus"></i>New</a>
						</div>
						<!-- Backlog -Box -Start-->
						<div class="col-md-4">

							<div class="well">
								<h4 class="text-right">ProjectY</h4>
								<h4 class="media-heading">
									<a href="/viewTasks/id=${backlog.id}">BacklogItem 1</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								<ul class="list-inline list-unstyled">
									<li data-toggle="tooltip" data-placement="top"
										title="Hour Estimated"><span><i
											class="glyphicon glyphicon-time"></i> hour estimated|</span></li>
									<span data-toggle="tooltip" data-placement="top"
										title="Priority"><i
										class="glyphicon glyphicon glyphicon-pushpin"></i>Priority|</span>
									<span data-toggle="tooltip" data-placement="top" title="Status">
										<i class="glyphicon glyphicon-eye-open"></i>Status|
									</span>
									<span><a data-toggle="modal" href="#backlogDetail"><i
											class="glyphicon glyphicon-eye-open"></i>Update|</a></span>
									<span data-toggle="tooltip" data-placement="top"
										title="delete"><a href="/delete/backlogId"><i
										class="glyphicon glyphicon glyphicon-pushpin"></i>Delete|</a></span>
								</ul>
							</div>
						</div>
						<!-- Backlog-Box-End -->
						<!-- Backlog -Box -Start-->
						<div class="col-md-4">
							<div class="well">
								<h4 class="text-right">ProjectY</h4>
								<h4 class="media-heading">
									<a href="/viewTasks/id=${backlog.id}">BacklogItem 1</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								<ul class="list-inline list-unstyled">
									<li data-toggle="tooltip" data-placement="top"
										title="Hour Estimated"><span><i
											class="glyphicon glyphicon-time"></i> hour estimated|</span></li>

									<span data-toggle="tooltip" data-placement="top"
										title="Priority"><i
										class="glyphicon glyphicon glyphicon-pushpin"></i>Priority|</span>

									<span data-toggle="tooltip" data-placement="top" title="Status">
										<i class="glyphicon glyphicon-eye-open"></i>Status|
									</span>
									<span><a data-toggle="modal" href="#backlogDetail"><i
											class="glyphicon glyphicon-eye-open"></i>Update|</a></span>
								</ul>
							</div>
						</div>
						<!-- Backlog-Box-End -->

					</div>
					<div class="tab-pane fade" id="tab2default">Default 2</div>
					<div class="tab-pane fade" id="tab3default">Default 3</div>
				</div>
				<!-- Tab-Content -->
			</div>
		</div>

	</div>


	<!-- Add Backlog Section -Start-->
	<div class="row">
		<form class="form-horizontal" method="post">
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
									<div class="controls col-md-8 ">

										<select class="form-control" id="backlogTitle">
											<option>Feature1</option>
											<option>Feature2</option>
											<option>Feature3</option>
											<option>Feature4</option>
										</select>

									</div>
								</div>
								<div class="form-group required">
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
								<div class="form-group required">
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
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-success">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- Add Backlog Section -End-->

	<!-- Update Backlog Section -Start -->
	<div class="modal fade" id="backlogDetail" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">BacklogItem 1</h4>
				</div>
				<div class="modal-body">
					<p>Backlog Description</p>
					<hr />

					<div class="row">
						<div class="col-md-4">
							<p>Hour Estimated : 8H</p>
						</div>
						<div class="col-md-4">
							<p>Priority : High</p>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="selStatus">Status:</label> <select
									class="form-control" id="selStatus">
									<option>Open</option>
									<option>In Progress</option>
									<option>Done</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-success">Save</button>
				</div>
			</div>

		</div>
	</div>
	<!-- End Update Backlog -->

</div>


<jsp:include page="footer.jsp" />