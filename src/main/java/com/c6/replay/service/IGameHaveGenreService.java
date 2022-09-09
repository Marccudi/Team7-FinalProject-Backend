package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Game;
import com.c6.replay.dto.GameHaveGenre;

public interface IGameHaveGenreService {

	public List<GameHaveGenre> listGameHaveGenres();
	
	public GameHaveGenre saveGameHaveGenre(GameHaveGenre gameHaveGenre);
	
	public GameHaveGenre gameHaveGenreXID(int id);
	
	public GameHaveGenre updateGameHaveGenre(GameHaveGenre gameHaveGenre);
	
	public void deleteGameHaveGenre(int id);

	List<Game> gamesXGenere(int genreId);
	
}
