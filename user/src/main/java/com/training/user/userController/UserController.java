package com.training.user.userController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.user.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/v1/user")
public class UserController {
	
	@GetMapping(value = "/userid/{userId}", produces = "application/json")
	String getuserById(@PathVariable("userId") int userId) {
		
		UserService userService = new UserService();
		String response = userService.getUserById(userId);
		return response;
	}
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json"  )
	String addUser(@RequestBody String payload) {
		
		UserService userService = new UserService();
		String response = userService.addUser(payload);
		return response;
	}
	
	@DeleteMapping(value = "/delete/{userId}", produces = "application/json")
	String deleteUser(@PathVariable("userId") int userId) {
		
		UserService userService = new UserService();
		String response = userService.deleteUser(userId);
		return response;
	}
	
	@PutMapping(value = "/update/{userId}", produces = "application/json", consumes = "application/json"  )
	String updateUserDetails(@PathVariable("userId") int userId, @RequestBody String payload ) {
		
		UserService userService = new UserService();
		String response = userService.updateUser(userId, payload);
		return response;
	}

}


