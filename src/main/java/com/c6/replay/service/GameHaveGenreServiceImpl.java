package com.c6.replay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IGameHaveGenreDAO;
import com.c6.replay.dto.Game;
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
	
	@Override
	public List<Game> gamesXGenere(int genreId){
		List<GameHaveGenre> finale = listGameHaveGenres();
		List<Game> a = new ArrayList<>();
		for (int i = 0; i < finale.size(); i++) {
			if (genreId == finale.get(i).getGenre().getId()) {
				a.add(finale.get(i).getGame());
			}
		}
		return a;
	}
	
	

}
