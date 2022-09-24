package com.c6.replay.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IGameDAO;
import com.c6.replay.dto.Game;
import com.c6.replay.dto.GameHaveGenre;
import com.c6.replay.dto.Genre;
import com.c6.replay.dto.Own;
import com.c6.replay.dto.User;

@Service
public class GameServiceImpl implements IGameService {
	@Autowired
	OwnServiceImpl ownServiceImpl;

	
	@Autowired
	IGameDAO iGameDAO;
	
	@Override
	public List<Game> listGames() {
		List<Game> allGames = iGameDAO.findAll();
		List<Game> enabledGames = new ArrayList<Game>();
		for (Game game : allGames) {
			if ( game.isEnabled() ) {
				enabledGames.add(game);
			}
		}
		return enabledGames;
	}

	@Override
	public Game saveGame(Game game) {
		return iGameDAO.save(game);
	}

	@Override
	public Game gameXID(int id) {
		return iGameDAO.findById(id).get();
	}

	@Override
	public Game updateGame(Game game) {
		return iGameDAO.save(game);
	}

	@Override
	public Game deleteGame(int gameId, int userId) {
		User owner = gameXID(gameId).getOwner();;
		if (owner.getId() == userId) {
			return gameXID(gameId);
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<Game> GameXDeveloper(int Developerid){
		List<Game> a = listGames();
		List<Game> finale = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (Developerid == a.get(i).getDeveloper().getId()) {
				finale.add(a.get(i));
			}
		}
		return finale;
	}
	
	@Override
	public List<Game> GameXPlatform(int Platformid){
		List<Game> a = listGames();
		List<Game> finale = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (Platformid == a.get(i).getPlatform().getId()) {
				finale.add(a.get(i));
			}
		}
		return finale;
	}
	
	@Override
	public List<Game> listGameIfBorrowed(boolean borrowed){
		List<Game> a = listGames();
		List<Game> finale = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (borrowed == a.get(i).isBorrowed()) {
				finale.add(a.get(i));
			}
		}
		return finale;
	}

	@Override
	public List<Game> listGamesofUser(int idUser) {
		List<Game> a = listGames();
		List<Game> finale = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (idUser == a.get(i).getOwner().getId()) {
				finale.add(a.get(i));
			}
		}
		return finale;
	}

	

	
}
