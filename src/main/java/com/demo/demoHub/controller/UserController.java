package com.demo.demoHub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demoHub.model.Result;
import com.demo.demoHub.model.User;
import com.demo.demoHub.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register" ,method = RequestMethod.POST)
	public Result registerUser(@RequestBody User user) {
		try {
			return userService.registerUser(user);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Result();
	}
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public Map<String,Object> loginUser(@RequestBody User user) throws LoginException {
		try {
			return userService.loginUser(user);
		} catch (Exception e) {
			logger.error(e.toString());
			throw new LoginException("user not found");
		}
		
	}
	@PreAuthorize("hasAuthority ('USER')")
	@RequestMapping(value = "/getallusers" ,method = RequestMethod.GET )
	public List<User> getUsers(){
		try {
			return userService.getAllUsers();
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return new ArrayList<User>();
	}
	
	@PreAuthorize("hasAuthority ('USER')")
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public Result logout() throws Exception{
		try {
			return userService.logOutCurrentUser();
		}
		catch(Exception e) {
			logger.error(e.toString());
			throw new Exception("USER NOT FOUND EXCEPTION");
		}
		
	}
}
