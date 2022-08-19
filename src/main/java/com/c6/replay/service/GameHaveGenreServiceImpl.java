package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IGameHaveGenreDAO;
import com.c6.replay.dto.GameHaveGenre;

@Service
public class GameHaveGenreServiceImpl implements IGameHaveGenreService {

	@Autowired
	IGameHaveGenreDAO iGameHaveGenreDAO;
	
	@Override
	public List<GameHaveGenre> listGameHaveGenres() {
		return iGameHaveGenreDAO.findAll();
	}

	@Override
	public GameHaveGenre saveGameHaveGenre(GameHaveGenre gameHaveGenre) {
		return iGameHaveGenreDAO.save(gameHaveGenre);
	}

	@Override
	public GameHaveGenre gameHaveGenreXID(int id) {
		return iGameHaveGenreDAO.findById(id).get();
	}

	@Override
	public GameHaveGenre updateGameHaveGenre(GameHaveGenre gameHaveGenre) {
		return iGameHaveGenreDAO.save(gameHaveGenre);
	}

	@Override
	public void deleteGameHaveGenre(int id) {
		iGameHaveGenreDAO.deleteById(id);
	}

}
