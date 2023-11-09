package com.ecommerce.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.website.entity.User;
import com.ecommerce.website.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping({"/registerNewUser"})
	public User registrNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}
}
