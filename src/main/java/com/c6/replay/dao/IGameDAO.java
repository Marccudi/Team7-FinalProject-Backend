package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.Game;

public interface IGameDAO extends JpaRepository<Game, Integer>{

}
