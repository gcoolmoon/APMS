<%@ include file = "header.jsp" %>
<!-- NavBar -->
<div class="row no-margin">				
	<div class="panel with-nav-tabs">
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
					<div class="col-md-4">
						<div class="well">
							<h4 class="center">ProjectY</h4>
							<h4 class="media-heading">
								<a href="/viewTasks/id=${backlog.id}">BacklogItem 1</a>
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing
								elit.</p>
							<ul class="list-inline list-unstyled">
								<li data-toggle="tooltip" data-placement="top"
									title="Hour Estimated"><span><i
										class="glyphicon glyphicon-time"></i> hour estimated|</span></li>
								<span data-toggle="tooltip" data-placement="top"
									title="Priority"><i
									class="glyphicon glyphicon glyphicon-pushpin"></i>Priority|</span>
								<span data-toggle="tooltip" data-placement="top"
									title="Status"> <i
									class="glyphicon glyphicon-eye-open"></i>Status|
								</span>
								<span><a data-toggle="modal" href="#backlogDetail"><i
										class="glyphicon glyphicon-eye-open"></i>Update|</a></span>
							</ul>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="tab2default">Default 2</div>
				<div class="tab-pane fade" id="tab3default">Default 3</div>
			</div> <!-- Tab-Content -->
		</div>
	</div>
</div>
<%@ include file = "footer.jsp" %>