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

	private User activeUser;

	// register user
	@RequestMapping("/user")
	public String setUpForm() {
		//model.addAttribute("sprint", new Sprint());
		return "user";
	}
	
//	@RequestMapping("/projects")
//	public String viewProjects(HttpServletRequest request, Model model) {
//		model.addAttribute("message", request.getAttribute("message"));
//		model.addAttribute("projects", this.sprintService.getAll());
//		return "sprint";
//	}
	
	//review users
		// model.addAttribute("sprint", new Sprint());

	// @RequestMapping("/projects")
	// public String viewProjects(HttpServletRequest request, Model model) {
	// model.addAttribute("message", request.getAttribute("message"));
	// model.addAttribute("projects", this.sprintService.getAll());
	// return "sprint";
	// }

	// review users
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", this.userRoleService.getAll());
		model.addAttribute("listUsers", this.userService.getAll());
		return "register";
	}

	// display user profile
	@RequestMapping(value = "/userprofile/{id}", method = RequestMethod.GET)
	public String getUserProfile(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.get(id));
		return "userProfile";
	}

	@RequestMapping(value = "/userprofile/{id}", method = RequestMethod.POST)
	public String editUserProfile(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.get(id));
		activeUser = this.userService.get(id);
		return "redirect:/userProfileEdit";
	}

	@RequestMapping(value = "/userprofileedit/{id}", method = RequestMethod.GET)
	public String showUserProfile(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.get(id));
		activeUser = this.userService.get(id);
		return "/userProfileEdit";
	}

	@RequestMapping(value = "/userprofileedit/{id}", method = RequestMethod.POST)
	public String editUserProfile(@PathVariable("id") int id, @ModelAttribute("user") User p, Model model) {
		if (p.getEmployeeId() == null) {
			// new sprint, add it
			this.userService.add(p);
		} else {
			// existing sprint, call update
			//p.setUserRoles(activeUser.getUserRoles());
			this.userService.edit(p);
		}
		return "userProfile";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUsers(@ModelAttribute("user") User p) {
		return addUser(p);
	}

	// For add and update sprint both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p) {

		if (p.getEmployeeId() == null) {
			// new sprint, add it
			this.userService.add(p);
		} else {
			// existing sprint, call update
			this.userService.edit(p);
		}
		
		return "redirect:/register";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public String editUserPopulate(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.get(id));
		model.addAttribute("listUsers", this.userService.getAll());
		return "user";
	}

	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.userService.delete(id);// .deleteUserByEmpId(this.userService.get(id));
		return "redirect:/users";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public String editUser(@PathVariable("id") int id, Model model) {
		return addUser(this.userService.get(id));
	}
	
//	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
//	public String editUserProfile(@ModelAttribute("user") User p, Model model) {
//		return addUser(this.userService.get(id));
//	}

}
