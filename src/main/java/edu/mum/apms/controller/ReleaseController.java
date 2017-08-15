package edu.mum.apms.controller;

import java.text.SimpleDateFormat;

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

import edu.mum.apms.model.Project;
import edu.mum.apms.model.Release;
import edu.mum.apms.service.ReleaseService;

@Controller
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService;
	
	
	@RequestMapping("/release")
	public String setUpForm() {
		return "/release";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Data.class, new CustomDateEditor(sdf, false));
    }
	
	@RequestMapping(value = "/releases", method = RequestMethod.GET)
	public String listSprints(Model model) {
		model.addAttribute("release", new Release());
		model.addAttribute("listReleases", this.releaseService.getAll());
		return "release";
	}
	
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
	 
	 @RequestMapping("/release/edit/{id}")
	    public String editRelease(@PathVariable("id") int id, Model model){
	        model.addAttribute("release", this.releaseService.get(id));
	        model.addAttribute("listReleases", this.releaseService.getAll());
	        return "release";
	    }
	 @RequestMapping("/release/remove/{id}")
	    public String removeRelease(@PathVariable("id") int id, Model model){
		 
				//existing project, call update
			this.releaseService.delete(id);
			

			return "redirect:/releases";
	    }
	 @RequestMapping("/releases")
	    public String getReleases(@PathVariable("id") int id, Model model){
	        model.addAttribute("listReleases", this.releaseService.getAll());
	        return "release";
	    }
	
}
