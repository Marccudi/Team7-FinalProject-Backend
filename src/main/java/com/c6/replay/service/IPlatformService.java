package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Platform;

public interface IPlatformService {
public List<Platform> listPlatforms(); // List all the platforms
	
	public Platform savePlatform(Platform platform); // Save a platform
	
	public Platform platformXID(int id); // List one Platform by id
	
	public Platform updatePlatform(Platform platform); // Update platform
	
	public void deletePlatform(int id); // Delete Platform
}
