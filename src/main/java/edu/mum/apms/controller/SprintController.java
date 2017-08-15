package edu.mum.apms.controller;

import java.text.SimpleDateFormat;

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

import com.mysql.fabric.xmlrpc.base.Data;

import edu.mum.apms.model.Sprint;
import edu.mum.apms.service.ReleaseService;
import edu.mum.apms.service.SprintService;

@Controller
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private ReleaseService releaseService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Data.class, new CustomDateEditor(sdf, false));
    }
	
	@RequestMapping("/sprint")
	public String setUpForm() {
		//model.addAttribute("sprint", new Sprint());
		return "/sprint";
	}
	
//	@RequestMapping("/projects")
//	public String viewProjects(HttpServletRequest request, Model model) {
//		model.addAttribute("message", request.getAttribute("message"));
//		model.addAttribute("projects", this.sprintService.getAll());
//		return "sprint";
//	}
	
	@RequestMapping(value = "/sprints", method = RequestMethod.GET)
	public String listSprints(Model model) {
		model.addAttribute("sprint", new Sprint());
		model.addAttribute("releases", this.releaseService.getAll());
		model.addAttribute("listSprints", this.sprintService.getAll());
		return "sprint";
	}
	
	//For add and update sprint both
	@RequestMapping(value= "/sprint/add", method = RequestMethod.POST)
	public String addSprint(@ModelAttribute("sprint") Sprint p){
		
		if(p.getSprintId() == 0){
			//new sprint, add it
			this.sprintService.add(p);
		}else{
			//existing sprint, call update
			this.sprintService.edit(p);
		}
		
		return "redirect:/sprints";
	}
	
	@RequestMapping("/sprint/remove/{id}")
    public String removeSprint(@PathVariable("id") int id){
        this.sprintService.delete(id);
        return "redirect:/sprints";
    }
 
    @RequestMapping(value = "/sprint/edit/{id}", method = RequestMethod.POST)
    public String editSprint(@PathVariable("id") int id, Model model){
        model.addAttribute("sprint", this.sprintService.get(id));
        model.addAttribute("listSprints", this.sprintService.getAll());
        return "sprint";
    }
    
    @RequestMapping(value = "/sprint/edit/{id}", method = RequestMethod.GET)
    public String editSprintPage(@PathVariable("id") int id, Model model){
        model.addAttribute("sprint", this.sprintService.get(id));
        System.out.println("+++++++ " + this.sprintService.get(id).getRelease().getVersion());
        model.addAttribute("listSprints", this.sprintService.getAll());
        return "sprint";
    }

}
