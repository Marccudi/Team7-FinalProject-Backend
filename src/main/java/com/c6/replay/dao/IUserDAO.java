package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
