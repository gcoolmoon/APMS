<%@ include file = "../header.jsp" %>
<div class="row no-margin">		
	<div class="alert alert-success" id="addAlert">
	  <strong>Success!</strong> <span id="addMsg">${message}</span>
	</div>
	<div class="row">
		<h2 class="main-title">Projects</h2>
	</div>	
	<div class="row projects space-sm">
		<div class="col-sm-4 green-txt">
			<div class="text-center">
				<h4><a href="#" class="green-txt">PROJECT NAME</a></h4>
				<div class="chart" data-percent="75">
					<span>75%<br>completed</span>
				</div>
				<p>
					Some project description goes here...
				</p>
				<p class="grey-txt no-margin">Start Date: 01/01/2017</p>
				<p class="grey-txt no-margin">End Date: 01/01/2017</p>
				<p class="grey-txt no-margin">No. of Features: <span class="green-txt">10</span> </p>
			</div>
		</div>
	</div>	
</div>
<%@ include file = "../footer.jsp" %>