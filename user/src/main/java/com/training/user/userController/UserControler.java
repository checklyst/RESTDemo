package com.training.user.userController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.user.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/v1/user")
public class UserControler {
	
	@GetMapping(value = "/userid/{userId}", produces = "application/json")
	String getuserById(@PathVariable("userId") int userId) {
		
		UserService userService = new UserService();
		String response = userService.getUserById(userId);
		return response;
	}
	
	

}


