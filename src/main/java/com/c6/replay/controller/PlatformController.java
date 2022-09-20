package com.c6.replay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c6.replay.dto.Platform;
import com.c6.replay.service.PlatformServiceImpl;

@RestController
@RequestMapping("/api")
public class PlatformController {
	@Autowired
	PlatformServiceImpl platformServiceImpl;
	
	@GetMapping("/platforms")
	public List<Platform> listPlatforms() {
		return platformServiceImpl.listPlatforms();
	}
	
	@PostMapping("/platforms")
	public Platform savePlatform(@RequestBody Platform platform) {
		return platformServiceImpl.savePlatform(platform);
	}
	
	@GetMapping("/platforms/{id}")
	public Platform platformXID(@PathVariable(name="id") int id) {
		
		Platform platform_xid= new Platform();
		
		//Find platform with id
		platform_xid=platformServiceImpl.platformXID(id);
		
		System.out.println("Platform by ID: "+platform_xid);
		
		return platform_xid;
	}
	
	@PutMapping("/platforms/{id}")
	public Platform updatePlatform(@PathVariable(name="id")int id,@RequestBody Platform platform) {
		
		Platform selectedPlatform= new Platform();
		Platform updatedPlatform= new Platform();
		
		//Find existing platform with id
		selectedPlatform= platformServiceImpl.platformXID(id);
		
		//Set the values to the given parameters
		selectedPlatform.setName(platform.getName());
		
		updatedPlatform = platformServiceImpl.updatePlatform(selectedPlatform);
		
		System.out.println("The updated platform is: "+ updatedPlatform);
		
		return updatedPlatform;
	}
	
	@DeleteMapping("/platforms/{id}")
	public void deletePlatform(@PathVariable(name="id")int id) {
		platformServiceImpl.deletePlatform(id);
	}

}
