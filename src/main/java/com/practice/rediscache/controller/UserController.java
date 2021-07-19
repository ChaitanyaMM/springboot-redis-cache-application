package com.practice.rediscache.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rediscache.entity.User;
import com.practice.rediscache.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User createUser(@RequestBody User user) {

		return userService.save(user);
	}

	@PutMapping("/{userId}")
	public User updateUser(@PathParam(value = "userId") Long userId, @RequestBody User user) {

		return userService.update(user, userId);
	}

	@GetMapping("/{userId}")
	public User getUser(@PathParam(value = "userId") Long userId) {

		return userService.findById(userId).get();
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathParam(value = "userId") Long userId) {

		userService.delete(userId);
	}

}
