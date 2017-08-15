<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<div class="row">


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>Team Members</h4>
				<div>
					<input type="hidden" /> <a href="#addTeam" data-toggle="modal"
						class="btn btn-default-btn-xs btn-success addNewTeam"><i
						class="glyphicon glyphicon-plus"></i>New</a>
				</div>
				<div class="table-responsive">

					<table id="tblTeam" class="table table-bordred table-striped">

						<thead>
							<th>EMPLOYEE ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>EMAIL</th>
							<th>POSITION</th>
							<th>ACTION</th>
						</thead>
						<tbody>
							<c:forEach var="team" items="${teams}">

								<tr>
									<td>${team.user.employeeId}</td>
									<td>${team.user.firstName}</td>
									<td>${team.user.lastName}</td>
									<td>${team.user.email}</td>
									<td>${team.position}</td>
									<td><p data-placement="top" data-toggle="tooltip"
											title="Delete">
											
											<button class=" delTMMember btn btn-danger btn-xs"
												name="${team.id}" data-title="Delete" data-toggle="modal"
												data-target="#delTeam">
												<span class="glyphicon glyphicon-trash"></span>
											</button>

										</p></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>

				</div>

			</div>
		</div>
	</div>


	<!-- Add Team Section -Start-->
	<div class="row">
		<form class="form-horizontal" id="addTeamForm" method="post">
			<div class="modal fade" id="addTeam" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add Team Member</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<div class="form-group required">
									<label for="userInfo11"
										class="control-label col-md-2  requiredField">User<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8" id="userInfo11">

										<select class="form-control" id="userInfoOption">
										</select>

									</div>
								</div>

								<div class="form-group required">
									<label for="memberPosition11"
										class="control-label col-md-2  requiredField">Position<span
										class="asteriskField">*</span>
									</label>
									<div class="controls col-md-8 ">
										<input class="input-md  textinput textInput form-control"
											id="memberPosition11" maxlength="30" name="description"
											placeholder="Add Position" style="margin-bottom: 10px"
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
	<!-- Add Team Section -End-->

	<!-- Delete TEAM Section START -->
	<form id="delTeamForm" action="/deleteTeam/" method="post">
		<div class="modal fade" id="delTeam" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
						<h4 class="modal-title custom_align" id="Heading">Delete this
							team entry</h4>
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