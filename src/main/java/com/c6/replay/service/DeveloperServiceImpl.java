package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.c6.replay.dao.IDeveloperDAO;
import com.c6.replay.dto.Developer;

public class DeveloperServiceImpl  implements IDeveloperService{
	@Autowired
	IDeveloperDAO developerDAO;
	
	@Override
	public List<Developer> listDevelopers() {
		// TODO Auto-generated method stub
		return developerDAO.findAll();
	}

	@Override
	public Developer saveDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return developerDAO.save(developer);
	}

	@Override
	public Developer developerXID(int id) {
		// TODO Auto-generated method stub
		return developerDAO.findById(id).get();
	}

	@Override
	public Developer updateDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return  developerDAO.save(developer);
	}

	@Override
	public void deleteDeveloper(int id) {
		// TODO Auto-generated method stub
		developerDAO.deleteById(id);
	}

}
