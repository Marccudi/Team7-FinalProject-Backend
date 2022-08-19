package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Game;
import com.c6.replay.dto.GameHaveGenre;

public interface IGameHaveGenreService {

	public List<Game> listGameHaveGenres();
	
	public Game saveGameHaveGenre(GameHaveGenre gameHaveGenre);
	
	public Game gameHaveGenreXID(int id);
	
	public Game updateGameHaveGenre(GameHaveGenre gameHaveGenre);
	
	public void deleteGameHaveGenre(int id);
	
}
