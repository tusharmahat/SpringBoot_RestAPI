package com.takeo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.entity.User;
import com.takeo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("api/users/")
public class UserController {
	@Autowired
	private UserServiceImpl serviceImpl;

	// build create user Rest API

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = serviceImpl.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// build read user Rest API
	@GetMapping("/fetch/{id}")
	public ResponseEntity<User> readUser(@PathVariable("id") Long uid) {
		User user = serviceImpl.readUser(uid);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		User existingUser = serviceImpl.readUser(user.getUname());
		String msg = "";
		if (existingUser != null) {
			if (user.getPassword().equals(existingUser.getPassword())) {
				msg = "login successful, welcome " + existingUser.getFname() + "!";
				return new ResponseEntity<>(msg, HttpStatus.OK);
			} else {
				msg = "password wrong!";
				return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
			}
		}
		
		msg = "User not found!";
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/forgot")
	public ResponseEntity<String> forgot(@RequestBody User user) {
		User existingUser = serviceImpl.readUser(user.getUname());
		String msg = "";
		if (existingUser != null) {
			msg = "Your password is " + existingUser.getPassword();
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
		msg = "User not found!";
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

	// build read all users Rest API
	@GetMapping("/fetch")
	public ResponseEntity<List<User>> readUsers() {
		List<User> users = serviceImpl.readUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// build update user Rest API
	@PutMapping("/put/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long uid, @RequestBody User user) {
		user.setUid(uid);
		User updatedUser = serviceImpl.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// build delete user Rest API
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long uid) {
		boolean updatedUser = serviceImpl.deleteUser(uid);
		String msg = "";
		if (updatedUser) {
			msg = "User deletion successful!";
		} else {
			msg = "User not found!";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
