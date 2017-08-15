package edu.mum.apms.aspect;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	// When the task is 'COMPLETED', send a notification email to a Scrum Master
	@After("execution(* edu.mum.apms.service.TaskService.updateTask(..)) && args(task) ")
	public void notifyTaskStatus(Task task) {

		if (task.getStatus() == Status.COMPLETED) {

			List<TeamMember> teamMembers = tmService.getTeamMembersByPosition("Scrum Master");
			String mailTo = "";

			for (TeamMember team : teamMembers) {
				mailTo = mailTo + "," + team.getUser().getEmail();
			}

			mailUtil.sendEmail(task.getTeamMember().getUser().getEmail(), mailTo,
					"Task :" + task.getTitle() + " is Completed!",
					"Description : " + task.getDescription() + " is completed!");
		}

	}

}
