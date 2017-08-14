package edu.mum.apms.controller;

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

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Feature;
import edu.mum.apms.model.Status;
import edu.mum.apms.service.BacklogService;
import edu.mum.apms.service.FeatureService;
import edu.mum.apms.service.ProjectService;

@Controller
public class BacklogController {

	@Autowired
	BacklogService backlogService;

	@Autowired
	ProjectService projectService;

	@Autowired
	FeatureService featureService;

	// Show seasons
	@RequestMapping(value = "/Backlog/{id}", method = RequestMethod.GET)
	public String showBacklog(HttpServletRequest request, Model model, @PathVariable int id) {

		model.addAttribute("backlogs", backlogService.getAllBacklogByProject(id));
		model.addAttribute("projectId", id);

		request.getSession().setAttribute("projectId", id);
		return "/backlog/backlog";
	}

//	@RequestMapping(value = "/addBacklog/{id}", method = RequestMethod.GET)
//	public String addBacklog(HttpServletRequest request, Model model, @PathVariable int id) {
//		model.addAttribute("features", backlogService.getAddableFeatures(id));
//		model.addAttribute("project", projectService.get(id));
//		request.getSession().setAttribute("projectId", id);
//		return "/backlog/addBacklog";
//	}

	@RequestMapping(value = "/addBacklog/{featureId}", method = RequestMethod.POST)
	public String addNewBacklog(HttpServletRequest request, @ModelAttribute("backlog") Backlog backlog,@PathVariable int featureId) {
		
		backlog.setFeature(featureService.get(featureId));
		backlog.setStatus(Status.OPEN);
		
		backlogService.addBacklog(backlog);
		
		return "redirect:/Backlog/" + request.getSession().getAttribute("projectId");
	}

	// Ajax call, to collect list of addable features
	@RequestMapping(value = "/getFeatures", method = RequestMethod.GET)
	@ResponseBody
	public List<Feature> getFeatures(@RequestParam(value = "projectId") int projectId) {

		return backlogService.getAddableFeatures(projectId);		

	}

	// Ajax call, to fill the update form data
	@RequestMapping(value = "/updateBacklog", method = RequestMethod.GET)
	@ResponseBody
	public Backlog backlogDetail(@RequestParam(value = "backlogId") int backlogId) {

		return backlogService.getBacklogById(backlogId);

	}

	// Update Backlog
	@RequestMapping(value = "/updateBacklog/{featureId}/{backlogId}", method = RequestMethod.POST)
	public String updateBacklog(HttpServletRequest request, @ModelAttribute("backlog") Backlog backlog,
			@PathVariable int featureId, @PathVariable int backlogId) {

		backlog.setId(backlogId);
		backlog.setFeature(featureService.get(featureId));
		backlogService.updateBacklog(backlog);
		request.getSession().setAttribute("backlog", backlog);

		return "redirect:/Backlog/" + request.getSession().getAttribute("projectId");
	}
}
