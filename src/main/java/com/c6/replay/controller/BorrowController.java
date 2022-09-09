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

import com.c6.replay.dto.Borrow;
import com.c6.replay.service.BorrowServiceImpl;

@RestController
@RequestMapping("/api")
public class BorrowController {
	
	@Autowired
	BorrowServiceImpl borrowServiceImpl;
	
	@GetMapping("/borrows")
	public List<Borrow> listBorrows(){
		return borrowServiceImpl.listBorrows();
	}
	
	@PostMapping("/borrows")
	public Borrow saveBorrow(@RequestBody Borrow borrow) {
		return borrowServiceImpl.saveBorrow(borrow);
	}
	
	@GetMapping("/borrows/{id}")
	public Borrow borrowXID(@PathVariable(name="id") Long id) {
		Borrow borrowXID = new Borrow();
		borrowXID=borrowServiceImpl.borrowXID(id);
		return borrowXID;
	}
	
	@PutMapping("/borrows/{id}")
	public Borrow updateBorrow(@PathVariable(name="id") Long id, @RequestBody Borrow borrow) {
		
		Borrow borrowSel = new Borrow();
		Borrow borrowAct =  new Borrow();
		
		borrowSel=borrowServiceImpl.borrowXID(id);
		
		borrowSel.setGame(borrow.getGame());
		borrowSel.setUserOwner(borrow.getUserOwner());
		borrowSel.setUserBorrower(borrow.getUserBorrower());
		borrowSel.setLend_date(borrow.getLend_date());
		borrowSel.setReturn_date(borrow.getReturn_date());
		
		borrowAct=borrowServiceImpl.updateBorrow(borrowSel);
		
		return borrowAct;
	}
	
	@DeleteMapping("/borrows/{id}")
	public String deleteBorrow(@PathVariable(name="id") Long id) {
		try {
			borrowServiceImpl.deleteBorrow(id);
			return "Borrowing successfully deleted.";
		}catch (Exception e) {
			return "Error: you cannot delete this borrowing";
		}
	}
	
	@GetMapping("/borrows/user/{id}")
	public List<Borrow> listBorrowsUser(@PathVariable(name="id") Long id){
		return borrowServiceImpl.listBorrowByUser(id);
	}
	
	@GetMapping("/borrows/{id}/{state}")
	public List<Borrow> listBorrowsState(@PathVariable(name="state") boolean state, @PathVariable(name="id") Long id){
		return borrowServiceImpl.listBorrowByState(state, id);
	}

	@GetMapping("/borrows/owner/{id}")
    public List<Borrow> borrowsByBorrower(@PathVariable(name="id") Long id) {
        return borrowServiceImpl.listBorrowByUserOwner(id);
    }
}
