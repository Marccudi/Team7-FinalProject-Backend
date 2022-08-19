package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Game;

public interface IGameService {
	
	public List<Game> listGames();
	
	public Game saveGame(Game game);
	
	public Game gameXID(int id);
	
	public Game updateGame(Game game);
	
	public void deleteGame(int id);

}
