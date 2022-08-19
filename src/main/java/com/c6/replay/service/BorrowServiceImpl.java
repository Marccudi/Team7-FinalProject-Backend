package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.c6.replay.dao.IBorrowDAO;
import com.c6.replay.dto.Borrow;

public class BorrowServiceImpl implements IBorrowService{
	
	@Autowired
	IBorrowDAO iBorrowDAO;

	@Override
	public List<Borrow> listBorrows() {
		// TODO Auto-generated method stub
		return iBorrowDAO.findAll();
	}

	@Override
	public Borrow saveBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return iBorrowDAO.save(borrow);
	}

	@Override
	public Borrow borrowXID(Long id) {
		// TODO Auto-generated method stub
		return iBorrowDAO.findById(id).get();
	}

	@Override
	public Borrow updateBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		return iBorrowDAO.save(borrow);
	}

	@Override
	public void deleteBorrow(Long id) {
		// TODO Auto-generated method stub
		iBorrowDAO.deleteById(id);
	}

}
