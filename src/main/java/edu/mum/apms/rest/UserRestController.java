package edu.mum.apms.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.apms.model.User;
import edu.mum.apms.model.UserRole;
import edu.mum.apms.service.UserService;

@RestController
public class UserRestController {


	@Autowired
	UserService userService;
	
	
	@RequestMapping("/restusers")
    public List<User> users() {
        return userService.getAll();
    }
	
	@RequestMapping("/restuser/{id}")
    public User user(@PathVariable("id") int id) {
        return userService.get(id);
    }
	
	@RequestMapping("/restrolebyuser/{id}")
    public Set<UserRole> rolesByUser(@PathVariable("id") int id) {
		
        return userService.get(id).getUserRoles();
    }
}
