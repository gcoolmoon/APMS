package edu.mum.apms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.ProjectService;

@Controller
public class BacklogController {

	@Autowired
	BacklogService backlogService;

	@Autowired
	ProjectService projectService;

	// Show seasons
	@RequestMapping(value = "/Backlog/{id}", method = RequestMethod.GET)
	public String showBacklog(Model model, @PathVariable int id) {
		System.out.println("Controller" + backlogService.getAllBacklogByProject(id).size());

		model.addAttribute("backlogs", backlogService.getAllBacklogByProject(id));
		model.addAttribute("projectId", id);
		
		return "/backlog/backlog";
	}

	@RequestMapping(value = "/addBacklog/{id}", method = RequestMethod.GET)
	public String addBacklog(HttpServletRequest request,Model model, @PathVariable int id) {
		model.addAttribute("features",backlogService.getAddableFeatures(id));
		model.addAttribute("project",projectService.get(id));
		request.getSession().setAttribute("projectId", id);
		return "/backlog/addBacklog";
	}
	
	@RequestMapping(value = "/addNewBacklog/{id}", method = RequestMethod.POST)
	public String addNewBacklog(HttpServletRequest request, @ModelAttribute("backlog") Backlog backlog) {
		backlogService.addBacklog(backlog);
		return "redirect:/Backlog/" +request.getSession().getAttribute("projectId");
	}

	/*@RequestMapping(value = "/updateBacklog", method = RequestMethod.GET)
	@ResponseBody
	public Backlog backlogDetail(@RequestParam(value = "backlogId") int backlogId) {
		System.out.println("Ajax Controller" + backlogId);

		// System.out.println("Size::" +featureList.size());
		return backlogService.getBacklogById(backlogId);
		

	}*/
}
