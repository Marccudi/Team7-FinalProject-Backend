package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.Borrow;

public interface IBorrowDAO extends JpaRepository<Borrow, Long>{

}
