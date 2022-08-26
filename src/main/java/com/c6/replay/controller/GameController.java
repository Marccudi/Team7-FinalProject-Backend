package com.c6.replay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.c6.replay.dto.Game;
import com.c6.replay.service.GameServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> listGames() {
		List<Game> allGames = gameServiceImpl.listGames();
		List<Game> enabledGames = new ArrayList<Game>();
		for (Game game : allGames) {
			if ( game.isEnabled() ) {
				enabledGames.add(game);
			}
		}
		return enabledGames;
	}
	
	@PostMapping("/games")
	public Game saveGame(@RequestBody Game game) {
		return gameServiceImpl.saveGame(game);
	}
	
	@GetMapping("/games/{id}")
	public Game gameXID(@PathVariable(name="id") int id) {
		
		Game game_xid= new Game();
		
		//Find game with id
		game_xid=gameServiceImpl.gameXID(id);
		
		System.out.println("Game by ID: "+game_xid);
		
		if(game_xid.isEnabled()) {
			return game_xid;
		} else {
			System.out.println("Game not enabled");
			return null;
		}
		
	}
	
	@PutMapping("/games/{id}")
	public Game updateGame(@PathVariable(name="id")int id,@RequestBody Game game) {
		
		Game selectedGame= new Game();
		Game updatedGame= new Game();
		
		//Find existing game with id
		selectedGame= gameServiceImpl.gameXID(id);
		
		//Set the values to the given parameters
		selectedGame.setTitle(game.getTitle());
		selectedGame.setDuration(game.getDuration());
		selectedGame.setYearReleased(game.getYearReleased());
		selectedGame.setAgeCalification(game.getAgeCalification());
		selectedGame.setDescription(game.getDescription());
		selectedGame.setDateInserted(game.getDateInserted());
		selectedGame.setDeveloper(game.getDeveloper());
		selectedGame.setPlatform(game.getPlatform());
		selectedGame.setEnabled(game.isEnabled());
		
		updatedGame = gameServiceImpl.updateGame(selectedGame);
		
		System.out.println("The updated game is: "+ updatedGame);
		
		return updatedGame;
	}
	
	@DeleteMapping("/games/{id}")
	public void deleteGame(@PathVariable(name="id")int id) {
		Game deletedGame = gameServiceImpl.gameXID(id);
		deletedGame.setEnabled(false);
	}

}
