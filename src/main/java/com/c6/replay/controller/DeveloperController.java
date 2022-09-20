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

import com.c6.replay.dto.Developer;
import com.c6.replay.service.DeveloperServiceImpl;

@RestController
@RequestMapping("/api")
public class DeveloperController {
	@Autowired
	DeveloperServiceImpl developerServiceImpl;
	
	@GetMapping("/developers")
	public List<Developer> listDevelopers() {
		return developerServiceImpl.listDevelopers();
	}
	
	@PostMapping("/developers")
	public Developer saveDeveloper(@RequestBody Developer developer) {
		return developerServiceImpl.saveDeveloper(developer);
	}
	
	@GetMapping("/developers/{id}")
	public Developer developerXID(@PathVariable(name="id") int id) {
		
		Developer developer_xid= new Developer();
		
		//Find developer with id
		developer_xid=developerServiceImpl.developerXID(id);
		
		System.out.println("Developer by ID: "+developer_xid);
		
		return developer_xid;
	}
	
	@PutMapping("/developers/{id}")
	public Developer updateDeveloper(@PathVariable(name="id")int id,@RequestBody Developer developer) {
		
		Developer selectedDeveloper= new Developer();
		Developer updatedDeveloper= new Developer();
		
		//Find existing developer with id
		selectedDeveloper= developerServiceImpl.developerXID(id);
		
		//Set the values to the given parameters
		selectedDeveloper.setName(developer.getName());
		
		updatedDeveloper = developerServiceImpl.updateDeveloper(selectedDeveloper);
		
		System.out.println("The updated developer is: "+ updatedDeveloper);
		
		return updatedDeveloper;
	}
	
	@DeleteMapping("/developers/{id}")
	public void deleteDeveloper(@PathVariable(name="id")int id) {
		developerServiceImpl.deleteDeveloper(id);
	}

}
