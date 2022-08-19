package com.c6.replay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c6.replay.dto.Genre;

public interface IGenreDAO extends JpaRepository<Genre, Integer>{

}
