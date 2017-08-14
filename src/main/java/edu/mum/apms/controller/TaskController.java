package edu.mum.apms.controller;

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

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Status;
import edu.mum.apms.model.Task;
import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private BacklogService backlogService;

	// Show Tasks
	@RequestMapping(value = "/Task/{backlogId}", method = RequestMethod.GET)
	public String showTask(HttpServletRequest request, Model model, @PathVariable int backlogId) {

		model.addAttribute("tasks", taskService.getAllTaskByBacklog(backlogService.getBacklogById(backlogId)));
		model.addAttribute("backlog", backlogService.getBacklogById(backlogId));

		request.getSession().setAttribute("backlogId", backlogId);

		return "/task/task";
	}

	// Add Task
	@RequestMapping(value = "/addTask/{backlogId}", method = RequestMethod.POST)
	public String addNewBacklog(HttpServletRequest request, @ModelAttribute("task") Task task,
			@PathVariable int backlogId) {

		task.setBacklog(backlogService.getBacklogById(backlogId));
		task.setStatus(Status.OPEN);

		taskService.addTask(task);

		return "redirect:/Task/" + request.getSession().getAttribute("backlogId");
	}

	// Ajax call, to fill the update form data
	@RequestMapping(value = "/updateTask", method = RequestMethod.GET)
	@ResponseBody
	public Task taskDetail(@RequestParam(value = "taskId") int taskId) {

		return taskService.getTaskById(taskId);
	}

	// Update Task
	@RequestMapping(value = "/updateTask/{backlogId}/{taskId}", method = RequestMethod.POST)
	public String updateBacklog(HttpServletRequest request, @ModelAttribute("task") Task task,
			@PathVariable int backlogId, @PathVariable int taskId) {

		task.setId(taskId);
		task.setBacklog(backlogService.getBacklogById(backlogId));
		taskService.updateTask(task);

		request.getSession().setAttribute("task", task);

		return "redirect:/Task/" + request.getSession().getAttribute("backlogId");
	}

	// Delete Backlog
	@RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.POST)
	public String deleteBacklog(HttpServletRequest request, @PathVariable int taskId) {

		taskService.deleteTask(taskId);

		return "redirect:/Task/" + request.getSession().getAttribute("backlogId");
	}
}
