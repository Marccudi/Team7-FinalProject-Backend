package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IGameDAO;
import com.c6.replay.dto.Game;

@Service
public class GameServiceImpl implements IGameService {

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
	public void deleteGame(int id) {
		iGameDAO.deleteById(id);
	}

}
