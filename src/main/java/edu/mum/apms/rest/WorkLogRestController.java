package edu.mum.apms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.apms.model.WorkLog;
import edu.mum.apms.service.TaskService;
import edu.mum.apms.service.WorklogService;

@RestController
public class WorkLogRestController {

	@Autowired
	WorklogService worklogService;
	@Autowired
	TaskService taskService;

	// Get all WorkLog by Task
	@RequestMapping("/restgetWorklogsByTaskId/{taskId}")
	public List<WorkLog> getWorklogsByTask(@PathVariable int taskId) {

		return worklogService.getAllWorklogByTask(taskService.getTaskById(taskId));

	}

	// Get Task by id
	@RequestMapping("/restgetWorklog/{worklogId}")
	public WorkLog getWorkLog(@PathVariable int worklogId) {

		return worklogService.getWorklogById(worklogId);

	}

	// Remove worklog by id
	@RequestMapping("/restRemoveWorklogById/{worklogId}")
	public String removeacklog(@PathVariable int worklogId) {

		worklogService.deleteWorklog(worklogId);
		return "success";

	}
}
