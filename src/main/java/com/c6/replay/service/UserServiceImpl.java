package com.c6.replay.service;

import static java.util.Collections.emptyList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IUserDAO;
import com.c6.replay.dto.User;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService{

	@Autowired
	IUserDAO iUserDAO;
	
	public UserServiceImpl(IUserDAO IUserDAO) {
		this.iUserDAO = IUserDAO;
	}
	
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return iUserDAO.findAll();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return iUserDAO.save(user);
	}

	@Override
	public User userXID(Long id) {
		// TODO Auto-generated method stub
		return iUserDAO.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		iUserDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = iUserDAO.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
	}

}
