$(document).ready(function() {
	
	$('#deleteProject').click(function(e){
		let answer = confirm("Are you sure you want to remove this project?");
		if (!answer){
			e.preventDefault();
		}
	})
	

			//Add Backlog
			$(".addNewBacklog").on('click', function() {
					
				let projectId = $("#project_id").val();
				
				let data = 'projectId=' + encodeURIComponent(projectId);
				
				$.ajax({
		
					type : "GET",
					contentType : "application/json",
					url : "/getFeatures",
					data : data,
					dataType : 'json',
		
					success : function(features) {
						$('#backlogTitOption').empty();
						let optionData = "";
						$.each(features, function(index, Feature ) {
							
							let optionData = $('<option/>', {						        
								value: Feature.featureId,
						        text : Feature.title 	
						        
						    });	
							
							$('#backlogTitOption').append(optionData);
						});
						$('#addBacklogForm').attr('action','/addBacklog/'+ features[0].featureId);
						
					},
					error : function() {
						alert("failure");
					}
				});
				
			
				$("#backlogTitOption").change(function() {
					$('#addBacklogForm').attr('action','/addBacklog/'+ $(this).find('option:selected').val());
				});
				
			});	
						
	
			// Open Update Backlog toggle with list of features
			$(".updBacklog").on('click', function() {

				var backlogId = this.name;
				
				const featureId = $(this).data("featureid");
				const featureTitle = $(this).data("featuretitle");
				const featureDesc = $(this).data("featuredesc");
				const featurePrio = $(this).data("featureprio");				

				$("#featureTitle").text(featureTitle);
				$("#featureDescription").text(featureDesc);
				$("#featureObj").val(featureId);
				$("#featureIdVal").val(featureId);
				$("#blPriority").text("Priority :" +featurePrio);
				
				var data = 'backlogId=' + encodeURIComponent(backlogId);

				if (!data)
					return e.preventDefault() // stops modal from being shown

				$.ajax({

					type : "GET",
					contentType : "application/json",
					url : "/updateBacklog",
					data : data,
					dataType : 'json',

					success : function(backlog) {
						// let Backlog = JSON.parse(response.message);
						$('#updBacklogForm').attr('action','/updateBacklog/' + featureId + "/" +backlog.id);
											
						$("#estimatedHour").val(backlog.hourEstimated);
						
					},
					error : function() {
						alert("failure");
					}
				});
			});
		});

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
