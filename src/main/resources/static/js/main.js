$(document).ready(function() {
	if ($('#addMsg').text() === "")
		$('#addAlert').hide();
	setTimeout(() => {
		$('#addAlert').hide();
	}, 3000);
});
