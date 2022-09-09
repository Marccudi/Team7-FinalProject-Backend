package com.c6.replay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IBorrowDAO;
import com.c6.replay.dto.Borrow;

@Service
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
	
	@Override
	public List<Borrow> listByUserBorrower(int user) {
		List<Borrow> borrows = new ArrayList<>();
		for (Borrow borrow : listBorrows()) {
			if(borrow.getUserBorrower().getId() == user) {
				borrows.add(borrow);
			}
		}
		return borrows;
	}

}
