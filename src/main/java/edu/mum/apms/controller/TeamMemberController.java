package edu.mum.apms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.apms.service.TeamMemberService;

@Controller
public class TeamMemberController {

	@Autowired
	private TeamMemberService tmService;

	// @Autowired
	// UserService userService;

	// Show seasons
	@RequestMapping(value = "/Team", method = RequestMethod.GET)
	public String showTeam(Model model) {

		model.addAttribute("teams", tmService.getAllTeamMember());

		return "/team/team";
	}

	// Ajax call, to collect list of addable features
	// @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	// @ResponseBody
	// public List<User> getUsers() {
	//
	// // return userService.getAll();
	// return null;
	// }

}
