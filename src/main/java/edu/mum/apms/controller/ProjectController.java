package edu.mum.apms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Project;
import edu.mum.apms.model.Feature;
import edu.mum.apms.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
	
	@RequestMapping("/projects")
	public String viewProjects(HttpServletRequest request, Model model) {
		//if (request.getAttribute("message"))
			model.addAttribute("message", request.getAttribute("message"));
		return "/projects/projects";
	}
	@RequestMapping(value = "/projects/manage", method = RequestMethod.GET)
	public String manageProjects(HttpServletRequest request, Model model) {
		model.addAttribute("projects", projectService.getAll());
		return "/projects/manage";
	}
	@RequestMapping(value = "/projects/new", method = RequestMethod.GET)
	public String newProject(HttpServletRequest request, Model model) {
		model.addAttribute("project", new Project());
		return "/projects/new";
	}
	@RequestMapping(value = "/projects/new", method = RequestMethod.POST)
	public String addNewProject(HttpServletRequest request, @ModelAttribute("project") Project project) {
		System.out.println(project.getName());
		System.out.println(project.getDescription());
		System.out.println(project.getStartDate());
		System.out.println(project.getEndDate());
		project.setFeatures(new ArrayList<Feature>());
		projectService.add(project);
		request.setAttribute("message", "New project is successfully added!");
		return "forward:/projects";
		//return "redirect:/projects" +request.getSession().getAttribute("userId");
	}

}
