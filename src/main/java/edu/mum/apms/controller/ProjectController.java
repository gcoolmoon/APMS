package edu.mum.apms.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Project;
import edu.mum.apms.model.Status;
import edu.mum.apms.model.User;
import edu.mum.apms.model.Feature;
import edu.mum.apms.service.FeatureService;
import edu.mum.apms.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private FeatureService featureService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
	
	@RequestMapping("/projects")
	public String viewProjects(HttpServletRequest request, Model model) {		
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("projects", projectService.getByUser(user));
		return "/projects/projects";
	}
	@RequestMapping("/projects/{msg}")
	public String viewProjectsWithMsg(HttpServletRequest request, Model model, @PathVariable String msg) {		
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("message", msg);
		model.addAttribute("projects", projectService.getByUser(user));
		return "/projects/projects";
	}
	@RequestMapping(value = "/projects/manage", method = RequestMethod.GET)
	public String manageProjects(HttpServletRequest request,Model model) {			
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("projects", projectService.getByUser(user));
		model.addAttribute("feature", new Feature());
		return "/projects/manage";
	}
	@RequestMapping(value = "/projects/new", method = RequestMethod.GET)
	public String newProject(HttpServletRequest request, Model model) {
		model.addAttribute("project", new Project());
		return "/projects/new";
	}
	@RequestMapping(value = "/projects/new", method = RequestMethod.POST)
	public String addNewProject(HttpServletRequest request, @ModelAttribute("project") Project project) {
		project.setFeatures(new ArrayList<Feature>());
		project.setCreatedBy((User) request.getSession().getAttribute("user"));
		projectService.add(project);
		String msg =  "New project is successfully added!";
		return "redirect:/projects/"+msg;
	}
	@RequestMapping(value = "/projects/edit/{pid}", method = RequestMethod.GET)
	public String editProject(HttpServletRequest request, Model model, @PathVariable int pid) {
		model.addAttribute("project", projectService.get(pid));
		return "/projects/edit";
	}
	@RequestMapping(value = "/projects/edit", method = RequestMethod.POST)
	public String editExistingProject(HttpServletRequest request, @ModelAttribute("project") Project project) {
		project.setCreatedBy((User) request.getSession().getAttribute("user"));
		projectService.edit(project);
		request.setAttribute("message", "Project successfully updated!");
		String msg = "Project successfully updated!";
		return "redirect:/projects/"+msg;
	}
	@RequestMapping(value = "/projects/delete/{id}", method = RequestMethod.GET)
	public String deleteProject(HttpServletRequest request, @PathVariable int id) {
		projectService.delete(id);
		return "redirect:/projects/manage";
	}
	@RequestMapping(value = "/projects/addFeature", method = RequestMethod.POST)
	public String addFeatureForProject(HttpServletRequest request, @ModelAttribute("feature") Feature feature) {
		Project current = projectService.get(Integer.parseInt(request.getParameter("pid")));
		feature.setStatus(Status.OPEN);
		feature.setProject(current);
		featureService.add(feature);
		current.getFeatures().add(feature);
		projectService.edit(current);
		return "redirect:/projects/manage";
	}
	@RequestMapping(value = "/projects/features/delete/{id}", method = RequestMethod.GET)
	public String deleteProjectFeature(HttpServletRequest request, @PathVariable int id) {
		featureService.delete(id);
		return "redirect:/projects/manage";
	}
	Project editProj;
	@RequestMapping(value = "/projects/features/edit/{id}", method = RequestMethod.GET)
	public String editProjectFeature(HttpServletRequest request, @PathVariable int id, Model model) {
		Feature f = featureService.get(id);
		model.addAttribute("feature", f);
		editProj = f.getProject();
		return "/projects/editFeature";
	}
	@RequestMapping(value = "/projects/features/edit", method = RequestMethod.POST)
	public String editExistingFeature(HttpServletRequest request, @ModelAttribute("feature") Feature feature) {
		//feature
		feature.setProject(editProj);
		featureService.edit(feature);
		request.setAttribute("message", "Project successfully updated!");
		String msg = "Feature successfully updated!";
		return "redirect:/projects/edit/" + editProj.getProjectId();
	}
	@RequestMapping(value = "/projects/feature/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Feature> getFeatures(@RequestParam(value = "projectId") int projectId) {

		return featureService.getAll(projectId);

	}

}
