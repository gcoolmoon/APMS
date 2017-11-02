package edu.mum.apms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.apms.model.Task;
import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.TaskService;

@RestController
public class TaskRestController {

	@Autowired
	TaskService taskService;
	@Autowired
	BacklogService backlogService;

	//Get all tasks by BacklogId
	@RequestMapping(value = "/getTaskByBacklogId/{backlogId}", method = RequestMethod.GET)
	public List<Task> getAllTaskByBacklog(@PathVariable int backlogId) {

		return taskService.getAllTaskByBacklog(backlogService.getBacklogById(backlogId));

	}
	
	//Remove task by id
	@RequestMapping(value = "/removeTaskById/{taskId}", method = RequestMethod.GET)
	public String removeTaskById(@PathVariable int taskId) {

		taskService.deleteTask(taskId);
		return "success";

	}
}
