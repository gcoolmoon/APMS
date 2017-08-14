package edu.mum.apms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.Project;
import edu.mum.apms.model.Release;
import edu.mum.apms.service.ReleaseService;

@Controller
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService;
	
	
	//For add and update project both
	@RequestMapping(value= "/release/add", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("release") Release r){
			
			if(r.getReleaseId() == 0){
				//new project, add it
				this.releaseService.add(r);
			}else{
				//existing project, call update
				this.releaseService.edit(r);
			}
			
			return "redirect:/releases";
			
		}
	
	 @RequestMapping("/release/{id}")
	    public String getRelease(@PathVariable("id") int id, Model model){
	        model.addAttribute("release", this.releaseService.get(id));
	        return "release";
	    }
	 
	 @RequestMapping("/releases")
	    public String getReleases(@PathVariable("id") int id, Model model){
	        model.addAttribute("listReleases", this.releaseService.getAll());
	        return "release";
	    }
	
}
