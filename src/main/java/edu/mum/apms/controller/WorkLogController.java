package edu.mum.apms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.apms.model.Task;
import edu.mum.apms.model.User;
import edu.mum.apms.model.WorkLog;
import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.TaskService;
import edu.mum.apms.service.TeamMemberService;
import edu.mum.apms.service.WorklogService;

@Controller
public class WorkLogController {

	@Autowired
	private BacklogService backlogService;

	@Autowired
	private WorklogService worklogService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TeamMemberService tmService;

	// Show Worklog
	@RequestMapping(value = "/WorkLog/{backlogId}", method = RequestMethod.GET)
	public String showWorklog(HttpServletRequest request, Model model, @PathVariable int backlogId) {
		
		model.addAttribute("tasks", taskService.getAllTaskByBacklog(backlogService.getBacklogById(backlogId)));
		model.addAttribute("backlog", backlogService.getBacklogById(backlogId));

		request.getSession().setAttribute("backlogId", backlogId);

		return "/task/worklog";
	}

	// Ajax call, to collect list of tasks
	@RequestMapping(value = "/getTasks", method = RequestMethod.GET)
	@ResponseBody
	public List<Task> getTasks(@RequestParam(value = "backlogId") int backlogId) {

		return taskService.getAllTaskByBacklog(backlogService.getBacklogById(backlogId));

	}

	// Add Worklog
	@RequestMapping(value = "/addWorklog/{taskId}", method = RequestMethod.POST)
	public String addNewWorklog(HttpServletRequest request, @ModelAttribute("worklog") WorkLog worklog,
			@PathVariable int taskId) {

		worklog.setTask(taskService.getTaskById(taskId));

		worklog.setLoggedDate(new Date());
		
		User user = (User) request.getSession().getAttribute("user");
		
		worklog.setTeamMember(tmService.getTeamMemberByUser(user));
		worklogService.addWorklog(worklog);

		return "redirect:/WorkLog/" + request.getSession().getAttribute("backlogId");
	}

	// Ajax call, to fill the update form data
	@RequestMapping(value = "/updateWorklog", method = RequestMethod.GET)
	@ResponseBody
	public WorkLog worklogDetail(@RequestParam(value = "worklogId") int worklogId) {

		return worklogService.getWorklogById(worklogId);
	}

	// Update Worklog
	@RequestMapping(value = "/updateWorklog/{taskId}/{worklogId}", method = RequestMethod.POST)
	public String updateWorklog(HttpServletRequest request, @ModelAttribute("worklog") WorkLog worklog,
			@PathVariable int taskId, @PathVariable int worklogId) {

		worklog.setId(worklogId);
		worklog.setTask(taskService.getTaskById(taskId));
		worklogService.updateWorklog(worklog);

		return "redirect:/WorkLog/" + request.getSession().getAttribute("backlogId");
	}

	// Delete Worklog
	@RequestMapping(value = "/deleteWorklog/{worklogId}", method = RequestMethod.POST)
	public String deleteWorklog(HttpServletRequest request, @PathVariable int worklogId) {

		worklogService.deleteWorklog(worklogId);

		return "redirect:/WorkLog/" + request.getSession().getAttribute("backlogId");
	}
}
