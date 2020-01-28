package com.example.whiteboard.controller;

import com.example.whiteboard.models.UserModel;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	static ArrayList<UserModel> users = new ArrayList<UserModel>();
	static {
		users.add(new UserModel(123, "alice", "Alice"));
		users.add(new UserModel(234, "bob", "Bob"));
		users.add(new UserModel(345, "charlie", "Charlie"));
		users.add(new UserModel(456, "dan", "Dan"));
	}
	
	@GetMapping("/users")
	public ArrayList<UserModel> findAllUsers() {
		return users;
	}
} 