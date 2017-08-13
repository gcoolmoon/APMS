<%@ include file = "header.jsp" %>
<div class="row no-margin new-project">	
	<div class="row">
		<h2 class="main-title">Add New Project</h2>
	</div>	
	<div class="row space-lg">
		<div class="col-sm-8 col-sm-offset-1">
			<form class="form-horizontal">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="name">Project Name:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="name" placeholder="Enter project name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="desc">Description:</label>
			    <div class="col-sm-10"> 
			      <textarea class="form-control" id="desc" placeholder="Enter description"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
				  <div class="col-sm-6">
				  <label class="control-label col-sm-4" for="start">Start Date:</label>
				    <div class="col-sm-8">
				      <input type="date" class="form-control" id="start">
				    </div>
				  </div>
				  <div class="col-sm-6">
				    <label class="control-label col-sm-4" for="end">End Date:</label>
				    <div class="col-sm-8">
				      <input type="date" class="form-control" id="end">
				    </div>
				  </div>
			  </div>
			  <div class="form-group space-lg"> 
			  	<div class="text-center">
			      <button type="submit" class="btn btn-default green-btn">DONE</button>
			  	</div>
			  </div>
			</form>
		</div>
	</div>
</div>
<%@ include file = "footer.jsp" %>	