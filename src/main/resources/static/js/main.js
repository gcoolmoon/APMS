$(document).ready(function() {
	
	$('#deleteProject').click(function(e){
		let answer = confirm("Are you sure you want to remove this project?");
		if (!answer){
			e.preventDefault();
		}
	});
	$('.showFeatures').click(function(){
		let projectId = $(this).attr("data-pid");	
		let data = 'projectId=' + encodeURIComponent(projectId);

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/projects/feature/all",
			data : data,
			dataType : 'json',

			success : function(features) {
				$('.features-list').empty();
				$.each(features, function(index, Feature ) {	
					let list = $('<li>');	
					let div = $('<div>');
					let h4 = $('<h4>', {
						text	:	Feature.title,
						class : 'clearfix grey-txt'
							});
					let small = $('<small>', {text: Feature.status, class: 'pull-right'});
					let pDesc = $('<p>');
					let spanDesc = $('<span>', {text: 'Description: ',class: 'grey-txt'});
					let pPriority = $('<p>');
					let spanPriority = $('<span>', {text: 'Priority: ',class: 'grey-txt'});
					pPriority.append(spanPriority).append(Feature.priority);
					pDesc.append(spanDesc).append(Feature.description);
					h4.append(small);
					div.append(h4).append(pDesc).append(pPriority);
					list.append(div);
					$('.features-list').append(list);
				});				
			},
			error : function() {
				alert("failure");
			}
		});
	});	

			// Add Backlog
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
			});
				
			
				$("#backlogTitOption").change(function() {
					$('#addBacklogForm').attr('action','/addBacklog/'+ $(this).find('option:selected').val());
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
					return e.preventDefault(); // stops modal from being shown

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
		
			// Delete Backlog			
			$(".delBacklog").on('click', function() {

				const backlogId = this.name;
				$('#delBacklogForm').attr('action','/deleteBacklog/' + backlogId);
				
			});	

			
			//Update Task
			// Open Update Backlog toggle with list of features
			$(".updTask").on('click', function() {

				var taskId = this.name;
				
				const backlogId = $(this).data("backlogid");
				
				var data = 'taskId=' + encodeURIComponent(taskId);

				if (!data)
					return e.preventDefault(); // stops modal from being shown

				$.ajax({

					type : "GET",
					contentType : "application/json",
					url : "/updateTask",
					data : data,
					dataType : 'json',

					success : function(task) {
						
						$('#updTaskForm').attr('action','/updateTask/' + backlogId + "/" +task.id);
											
						$("#taskTitle1").text(task.title);
						$("#tskTitle").val(task.title);
						$("#taskDescription1").val(task.description);
						
					},
					error : function() {
						alert("failure");
					}
				});

			}); //End of Update Task
			
			
			// Delete Task			
			$(".delTask").on('click', function() {

				const taskId = this.name;
				$('#delTaskForm').attr('action','/deleteTask/' + taskId);
				
			});	

			
			//Add Worklog			
			$(".addNewWorklog").on('click', function() {
				const backlogId = $("#backlogId").val();
								
				const data = 'backlogId=' + encodeURIComponent(backlogId);
				
				$.ajax({
		
					type : "GET",
					contentType : "application/json",
					url : "/getTasks",
					data : data,
					dataType : 'json',
		
					success : function(tasks) {
						
						$('#taskTitOption').empty();
						let optionData = "";
						$.each(tasks, function(index, Task ) {
							
							let optionData = $('<option/>', {						        
								value: Task.id,
						        text : Task.title 	
						        
						    });	
							
							$('#taskTitOption').append(optionData);
						});
						$('#addWorklogForm').attr('action','/addWorklog/'+ tasks[0].id);
						
					},
					error : function() {
						alert("failure");
					}
				});
			});
				
			
			$("#backlogTitOption").change(function() {
				$('#addBacklogForm').attr('action','/addBacklog/'+ $(this).find('option:selected').val());
			});

			
			//Update Worklog
			// Open Update Worklog toggle with list of features
			$(".updWorklog").on('click', function() {
					
				let worklogId = this.name;
				const taskId = $(this).data("taskid");
				
				const data = 'worklogId=' + encodeURIComponent(worklogId);

				if (!data)
					return e.preventDefault(); // stops modal from being shown

				$.ajax({

					type : "GET",
					contentType : "application/json",
					url : "/updateWorklog",
					data : data,
					dataType : 'json',

					success : function(worklog) {
						
						$('#updWorklogForm').attr('action','/updateWorklog/' + taskId + "/" +worklog.id);
											
						$("#wldesc").val(worklog.description);
						$("#wlhour").val(worklog.hourLogged);
						$("#wldate").val(worklog.loggedDate);
						$("#wlTitle").text(worklog.task.title);
						
						
					},
					error : function() {
						alert("failure");
					}
				});

			}); //End of Update Worklog
				
			// Delete Worklog			
			$(".delWKlog").on('click', function() {
				
				const worklogId = this.name;
				$('#delWorklogForm').attr('action','/deleteWorklog/' + worklogId);
				
			});	
			
			
			// Populate Backlog Members
			/*$(".viewTeam").on('click', function() {
					
				let backlogId = $(this).name;
				
				let data = 'backlogId=' + encodeURIComponent(backlogId);
				
				$.ajax({
		
					type : "GET",
					contentType : "application/json",
					url : "/getTeamMembers",
					data : data,
					dataType : 'json',
		
					success : function(members) {
						$('#memberTbody').empty();
						let tableData = "";
						$.each(members, function(index, Member) {
							
							$("#tblMember").find('tbody')
						    .append($('<tr>')
						        .append($('<td>')
						            
						                .attr('class', 'h6')
						                .text(Member.user.firstName)
						            )
						        )
						    );							

						});						
						
					},
					error : function() {
						alert("failure");
					}
				});
			});*/
			
			
			// Add Team Member
			$(".addTeam").on('click', function() {
				alert("cal");
				$.ajax({
		
					type : "GET",
					contentType : "application/json",
					url : "/getUsers",
					data : data,
					dataType : 'json',
		
					success : function(Users) {
						$('#userInfoOption').empty();
						let optionData = "";
						$.each(Users, function(index, User) {
							
							let optionData = $('<option/>', {						        
								value: User.id,
						        text : User.firstName + User.lastName 	
						        
						    });	
							
							$('#userInfoOption').append(optionData);
						});
						$('#addTeamForm').attr('action','/addTeam/'+ users[0].id);
						
					},
					error : function() {
						alert("failure");
					}
				});
			});
				
			
			$("#userInfoOption").change(function() {
				$('#addTeamForm').attr('action','/addTeam/'+ $(this).find('option:selected').val());
			});
				
				
			
			
	if ($('#addMsg').text() === "")
		$('#addAlert').hide();
	setTimeout(() => {
		$('#addAlert').hide();
	}, 3000);
	
	$('.addFeature').click(function(e){
		let pid = $(this).attr('data-pid');
		$('#addFeatureSubmit').val(pid);
	});
	
});
