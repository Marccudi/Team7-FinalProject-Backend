package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IUserDAO;
import com.c6.replay.dto.User;

@Service
public class UserServiceImpl implements IUserService{

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

}
