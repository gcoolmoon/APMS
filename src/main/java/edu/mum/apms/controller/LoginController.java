package edu.mum.apms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.User;
import edu.mum.apms.service.SecurityService;
import edu.mum.apms.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private SecurityService securityService;
	
	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("user", new User());
		return "/index";
	}
	@RequestMapping("/{msg}")
	public String loginAgain(HttpServletRequest request, Model model, @PathVariable("msg") String msg) {
		model.addAttribute("user", new User());
		model.addAttribute("message", msg);
		return "/index";
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request, Model model, @ModelAttribute("user") User user) {
		User result = userService.checkPassword(user.getEmail(), user.getPassword());
		String msg = "Invalid Username or Password. Please try again.";
		if (result == null) {
			return "redirect:/"+msg;
		} else {
			request.getSession().setAttribute("user", result);
			return "redirect:/projects/";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}
}
