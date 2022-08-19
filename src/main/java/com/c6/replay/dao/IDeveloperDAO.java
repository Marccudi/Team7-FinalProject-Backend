package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.Developer;


public interface IDeveloperDAO extends JpaRepository<Developer, Integer>{

}
