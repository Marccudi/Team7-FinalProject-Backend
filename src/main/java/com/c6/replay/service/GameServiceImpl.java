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

@Service
public class GameServiceImpl implements IGameService {
	@Autowired
	OwnServiceImpl ownServiceImpl;

	
	@Autowired
	IGameDAO iGameDAO;
	
	@Override
	public List<Game> listGames() {
		return iGameDAO.findAll();
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
		Own a = ownServiceImpl.lastOwnGame(gameId);
		if (a.getUserNewOwner().getId() == userId) {
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
