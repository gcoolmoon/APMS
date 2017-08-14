$(document).ready(function() {
	
	$('#deleteProject').click(function(e){
		let answer = confirm("Are you sure you want to remove this project?");
		if (!answer){
			e.preventDefault();
		}
	})
	
	if ($('#addMsg').text() === "")
		$('#addAlert').hide();
	setTimeout(() => {
		$('#addAlert').hide();
	}, 3000);
	
	$('.addFeature').click(function(e){
		let pid = $(this).attr('data-pid');
		$('#addFeatureSubmit').val(pid);
	})
	
});
