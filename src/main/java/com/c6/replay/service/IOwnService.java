package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Own;

public interface IOwnService {
	
	public List<Own> listOwns(); // List all the owns
	
	public List<Own> listOwnsByState(boolean state, Long id);
	
	public Own saveOwn(Own own); // Save a own
	
	public Own ownXID(Long id); // List one own by id
	
	public Own updateOwn(Own own); // Update own
	
	public void deleteOwn(Long id); // Delete own by id
	
	public Own lastOwnGame(int idGame);

}
