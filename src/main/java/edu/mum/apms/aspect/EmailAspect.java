package edu.mum.apms.aspect;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Status;
import edu.mum.apms.model.Task;
import edu.mum.apms.model.TeamMember;
import edu.mum.apms.service.TeamMemberService;
import edu.mum.apms.utility.MailUtil;

@Aspect
@Component
public class EmailAspect {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	TeamMemberService tmService;

	private String emailFrom;
	private String emailTo;
	private String emailSubject;
	private String emailBody;

	// When the task is 'COMPLETED', send a notification email to a Scrum Master
	@After("execution(* edu.mum.apms.service.TaskService.updateTask(..)) && args(task) ")
	public void notifyTaskStatus(Task task) {

		if (task.getStatus() == Status.COMPLETED) {

			List<TeamMember> teamMembers = tmService.getTeamMembersByPosition("Scrum Master");

			emailFrom = task.getTeamMember().getUser().getEmail();

			for (TeamMember team : teamMembers) {
				emailTo = emailTo + "," + team.getUser().getEmail();
			}

			emailSubject = "Task :" + task.getTitle() + " is Completed!";
			emailBody = "Description : " + task.getDescription() + " is completed!";

			sendEmail(emailFrom, emailTo, emailSubject, emailBody);

		}

	}

	// When the Backlog is 'COMPLETED', send a notification email to a Scrum Master
	@After("execution(* edu.mum.apms.service.BacklogService.updateBacklog(..)) && args(backlog) ")
	public void notifyBacklogStatus(Backlog backlog) {

		if (backlog.getStatus() == Status.COMPLETED) {

			List<TeamMember> teamMembers = tmService.getTeamMembersByPosition("Scrum Master");

			// emailFrom =
			// backlog.getTaskList().getTeamMember().getUser().getEmail();

			for (TeamMember team : teamMembers) {
				emailTo = emailTo + "," + team.getUser().getEmail();
			}

			emailSubject = "Backlog :" + backlog.getFeature().getTitle() + " is Completed!";
			emailBody = "Description : " + backlog.getFeature().getDescription() + " is completed!";

			sendEmail(emailFrom, emailTo, emailSubject, emailBody);

		}

	}

	public void sendEmail(String from, String to, String subject, String body) {

		mailUtil.sendEmail(from, to, subject, body);

	}

}
