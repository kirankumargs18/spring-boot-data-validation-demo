package com.kirangs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirangs.dto.UserRequest;
import com.kirangs.entity.User;
import com.kirangs.exception.UserNotFoundException;
import com.kirangs.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> fetchAllUsers() {

		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {

		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> fetchUserById(@PathVariable Integer userId) {

		return ResponseEntity.ok(userService.getUserByUserId(userId));
	}

}
