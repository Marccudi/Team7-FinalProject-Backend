package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Developer;

public interface IDeveloperService {
public List<Developer> listDevelopers(); // List all the developers
	
	public Developer saveDeveloper(Developer developer); // Save a developer
	
	public Developer developerXID(int id); // List one Developer by id
	
	public Developer updateDeveloper(Developer developer); // Update developer
	
	public void deleteDeveloper(int id); // Delete Developer
}
