package com.c6.replay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c6.replay.dto.User;
import com.c6.replay.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public List<User> listUsers(){
		return userServiceImpl.listUsers();
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public User userXID(@PathVariable(name="id") Long id) {
		User userXID = new User();
		userXID=userServiceImpl.userXID(id);
		
		return userXID;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name="id") Long id, @RequestBody User user) {
		
		User userSel = new User();
		User userAct = new User();
		
		userSel= userServiceImpl.userXID(id);
		
		userSel.setUser_name(user.getUser_name());
		userSel.setEmail(user.getEmail());
		userSel.setPassword(user.getPassword());
		userSel.setFirst_name(user.getFirst_name());
		userSel.setLast_name(user.getLast_name());
		userSel.setRole(user.getRole());
		
		userAct=userServiceImpl.updateUser(userSel);
		
		return userAct;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) {
		try {
			userServiceImpl.deleteUser(id);
			return "User successfully deleted.";
		}catch (Exception e) {
			return "Error: you cannot delete this user";
		}
	}
}
