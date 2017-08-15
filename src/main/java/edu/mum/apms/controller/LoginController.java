package edu.mum.apms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.model.User;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("user", new User());
		return "/index";
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request, Model model, @ModelAttribute("user") User user) {
		return "/index";
	}

}
