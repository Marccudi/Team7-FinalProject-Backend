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

import com.c6.replay.dto.Own;
import com.c6.replay.service.OwnServiceImpl;

@RestController
@RequestMapping("/api")
public class OwnController {

	@Autowired
	OwnServiceImpl ownServiceImpl;
	
	@GetMapping("/owns")
	public List<Own> listOwns(){
		return ownServiceImpl.listOwns();
	}
	
	@PostMapping("/owns")
	public Own saveOwn(@RequestBody Own own) {
		return ownServiceImpl.saveOwn(own);
	}
	
	@GetMapping("/owns/{id}")
	public Own ownXID(@PathVariable(name="id") Long id) {
		Own ownXID = new Own();
		ownXID=ownServiceImpl.ownXID(id);
		
		return ownXID;
	}
	
	@PutMapping("/owns/{id}")
	public Own updateOwn(@PathVariable(name="id") Long id, @RequestBody Own own) {
		
		Own ownSel = new Own();
		Own ownAct = new Own();
		
		ownSel=ownServiceImpl.ownXID(id);
		
		ownSel.setGame(own.getGame());
		ownSel.setUserOldOwner(own.getUserOldOwner());
		ownSel.setUserNewOwner(own.getUserNewOwner());
		ownSel.setExchange_date(own.getExchange_date());
		
		ownAct=ownServiceImpl.updateOwn(ownSel);
		
		return ownAct;
	}
	
	@DeleteMapping("/owns/{id}")
	public String deleteOwn(@PathVariable(name="id") Long id) {
		try {
			ownServiceImpl.deleteOwn(id);
			return "Owning successfully deleted.";
		}catch (Exception e) {
			return "Error: you cannot delete this Owning";
		}
	}
}
