package com.tejaswi.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejaswi.user.entity.User;
import com.tejaswi.user.service.UserService;

@RestController()
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	ResponseEntity<User> createUser(@RequestBody User user) {
		User userDetails = userService.createUser(user);
		return new ResponseEntity<User>(userDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getUserByEmail")
	ResponseEntity<User> getUser(@RequestBody User user) {
		User userDetails = userService.getUser(user.getEmail());
		return new ResponseEntity<User>(userDetails, HttpStatus.OK);
	}

	@GetMapping("/findAllUser")
	ResponseEntity<List<User>> findAllUser() {

		List<User> users = userService.findAllUser();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
