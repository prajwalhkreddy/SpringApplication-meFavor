package com.prajwal.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prajwal.web.model.User;

@Controller

public class UserController {

	@RequestMapping(value = "/login")
	public String login() {
		String message = "Login page was supposed to be here!";
		return message;
	}
	
	// ex: {context}/user/1
	@RequestMapping(value = "/user/{id}")
	public String getUser(@PathVariable("id") String emailId) {
		User u = new User();
		u.setId("1");
		u.setFirstName("Prajwal");
		//ResponseEntity<User> dummy = new ResponseEntity<User>(new User(), HttpStatus.OK);
		return null;
	}
	
	///user?name="Prajwal"
	@RequestMapping(value = "/user/byname", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@RequestParam("name") String name) {
		return null;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String createUser(@RequestBody User newUser) {
		return null;
	}
}
