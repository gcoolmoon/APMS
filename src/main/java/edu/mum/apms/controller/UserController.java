package edu.mum.apms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.User;
import edu.mum.apms.service.UserRoleService;
import edu.mum.apms.service.UserService;
import edu.mum.apms.service.UserServiceImpl;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	// register user
	@RequestMapping("/user")
	public String setUpForm() {
		//model.addAttribute("sprint", new Sprint());
		return "/user";
	}
	
//	@RequestMapping("/projects")
//	public String viewProjects(HttpServletRequest request, Model model) {
//		model.addAttribute("message", request.getAttribute("message"));
//		model.addAttribute("projects", this.sprintService.getAll());
//		return "sprint";
//	}
	
	//review users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", this.userRoleService.getAll());
		model.addAttribute("listUsers", this.userService.getAll());
		return "user";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String addUsers(@ModelAttribute("user") User p) {
		return addUser(p);
	}
	
	//For add and update sprint both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		if(p.getEmployeeId() == null){
			//new sprint, add it
			this.userService.add(p);
		}else{
			//existing sprint, call update
			this.userService.edit(p);
		}
		
		return "redirect:/users";
	}
	
	@RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.delete(id);//.deleteUserByEmpId(this.userService.get(id));
        return "redirect:/users";
    }
 
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("sprint", this.userService.get(id));
        model.addAttribute("listUsers", this.userService.getAll());
        return "sprint";
    }
	

}
