package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.GameHaveGenre;

public interface IGameHaveGenreDAO extends JpaRepository<GameHaveGenre, Integer>{

}
