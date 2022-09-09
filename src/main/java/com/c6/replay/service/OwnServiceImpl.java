package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IOwnDAO;
import com.c6.replay.dto.Own;

@Service
public class OwnServiceImpl implements IOwnService{
	
	@Autowired
	IOwnDAO iOwnDAO;

	@Override
	public List<Own> listOwns() {
		// TODO Auto-generated method stub
		return iOwnDAO.findAll();
	}

	@Override
	public Own saveOwn(Own own) {
		// TODO Auto-generated method stub
		return iOwnDAO.save(own);
	}

	@Override
	public Own ownXID(Long id) {
		// TODO Auto-generated method stub
		return iOwnDAO.findById(id).get();
	}

	@Override
	public Own updateOwn(Own own) {
		// TODO Auto-generated method stub
		return iOwnDAO.save(own);
	}

	@Override
	public void deleteOwn(Long id) {
		// TODO Auto-generated method stub
		iOwnDAO.deleteById(id);
	}

	@Override
	public Own lastOwnGame(Long idGame) {
		Own lastOwn = new Own();
		 for (Own own : listOwns()) {             
			 if(own.getGame().getId() == idGame) {                 
				 lastOwn = own;             
				 }         
			 }           
		return lastOwn;
	}

	
}
