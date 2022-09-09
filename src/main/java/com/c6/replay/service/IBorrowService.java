package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Borrow;

public interface IBorrowService {
	
	public List<Borrow> listBorrows(); // List all the borrows
	
	public Borrow saveBorrow(Borrow borrow); // Save a borrow
	
	public Borrow borrowXID(Long id); // List one Borrow by id
	
	public Borrow updateBorrow(Borrow borrow); // Update borrow
	
	public void deleteBorrow(Long id); // Delete Borrow by id
	
	public List<Borrow> listBorrowByState(boolean state, Long id);
	
	public List<Borrow> listBorrowByUser(Long id);
	
	public List<Borrow> listBorrowByUserOwner(Long id);

}
