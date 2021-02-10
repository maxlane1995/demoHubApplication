package com.demo.demoHub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demoHub.model.Result;
import com.demo.demoHub.model.User;
import com.demo.demoHub.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register")
	public Result registerUser(@RequestBody User user) {
		try {
			return userService.registerUser(user);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Result();
	}
	@RequestMapping(value = "/authenticate")
	public Result loginUser(@RequestBody User user) {
		try {
			return userService.loginUser(user);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Result();
	}
}
