package edu.mum.apms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.apms.model.TeamMember;
import edu.mum.apms.model.User;
import edu.mum.apms.service.TeamMemberService;
import edu.mum.apms.service.UserService;

@Controller
public class TeamMemberController {

	@Autowired
	private TeamMemberService tmService;

	@Autowired
	private UserService userService;

	// Show seasons
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String showTeam(Model model) {

		model.addAttribute("teams", tmService.getAllTeamMember());

		return "/team/team";
	}

	// Ajax call, to collect list of addable features
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {

		return userService.getAll();

	}

	// Add Member
	@RequestMapping(value = "/addTeam/{userId}", method = RequestMethod.POST)
	public String addTeam(HttpServletRequest request, @ModelAttribute("member") TeamMember member,
			@PathVariable int userId) {

		member.setUser(userService.get(userId));

		tmService.addTeamMember(member);

		return "redirect:/team";
	}

	// Update Team Member
	@RequestMapping(value = "/updateTeam/{userId}", method = RequestMethod.POST)
	public String updateTeam(HttpServletRequest request, @ModelAttribute("team") TeamMember member,
			@PathVariable int userId) {

		member.setUser(userService.get(userId));
		tmService.updateTeamMember(member);

		return "redirect:/team";
	}

	// Delete Team Member
	@RequestMapping(value = "/deleteTeam/{teamId}", method = RequestMethod.POST)
	public String deleteTeam(HttpServletRequest request, @PathVariable int teamId) {

		tmService.deleteMember(teamId);

		return "redirect:/team";
	}
}
