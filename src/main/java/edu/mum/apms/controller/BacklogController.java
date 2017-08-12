package edu.mum.apms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.ProjectService;

@Controller
public class BacklogController {

	@Autowired
	BacklogService backlogService;

	// Show seasons
	@RequestMapping(value = "/Backlog/{id}", method = RequestMethod.GET)
	public String showBacklog( Model model, @PathVariable int id) {
		System.out.println("Controller" +backlogService.getAllBacklogByProject(id));
		//model.addAttribute("backlogs", backlogService.getAllBacklogByProject(id));
		// model.addAttribute("series", tvSeriesService.getSeriesById(id));
		// request.getSession().setAttribute("series",
		// tvSeriesService.getSeriesById(id));

		return "/backlog";
	}
}
