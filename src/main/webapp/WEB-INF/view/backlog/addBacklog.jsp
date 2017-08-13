<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Backlog</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/tvseries.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/apms.js"></script>
<script>
	$(document).ready(
			function() {
				$('#addForm').attr(
						'action',
						'/addNewBacklog/'
								+ $(this).find('option:selected').val());
				$("#feature").change(
						function() {							
							$('#addForm').attr(
									'action',
									'/addNewBacklog/'
											+ $(this).find('option:selected')
													.val());

						});
			});
</script>
</head>
<body>
	<div class="container">
		<h3>Add Backlog: ${project.name}</h3>
		<hr />
		<form id="addForm" action="/" method="post">
			<input type="hidden" id="status" name="status" value="OPEN" />
			<table>
				<tr>
					<td>Feature:</td>
					<td><select id="feature" name="feature">
							<c:forEach var="feature" items="${features}">
								<option value="${feature.featureId}">${feature.description}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>HourEstimated:</td>
					<td><input type="text" name="hourEstimated" /></td>
				</tr>

			</table>
			<input type="submit" />
		</form>
	</div>
</body>
</html>