package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.User;

public interface IUserService {
	
	public List<User> listUsers(); // List all the users
	
	public User findByUsername(String username);
	
	public User saveUser(User user); // Save a user
	
	public User userXID(Long id); // List one user by id
	
	public User updateUser(User user); // Update user
	
	public void deleteUser(Long id); // Delete user by id
}
