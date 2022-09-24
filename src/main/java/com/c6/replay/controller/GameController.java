package com.c6.replay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.c6.replay.dto.Game;
import com.c6.replay.service.GameServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	private Gson gson = new Gson();
	
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
		game_xid=gameServiceImpl.gameXID(id);
		
		
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
		selectedGame.setImage(game.getImage());
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
	
	@DeleteMapping(value = "/games/{gameId}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteGame(@PathVariable(name="gameId")int gameId,@PathVariable(name="userId")int userId) {
		Game deletedGame = gameServiceImpl.deleteGame(gameId, userId);
		JsonObject json = new JsonObject();
		if (deletedGame == null) {
	        json.addProperty("msg", "El juego no es de tu propiedad");
	        return this.gson.toJson(json);
		} else {
			deletedGame.setEnabled(false);
			gameServiceImpl.updateGame(deletedGame);
			json.addProperty("msg", "El juego no es de tu propiedad");
			return this.gson.toJson(json);
		}
		
	}

	@GetMapping("/games/developer/{id}")
	public List<Game> GameXDeveloper(@PathVariable(name="id")int developerid){
		return gameServiceImpl.GameXDeveloper(developerid);
	}
	@GetMapping("/games/platform/{id}")
	public List<Game> GameXPlatform(@PathVariable(name="id") int platformid){
		return gameServiceImpl.GameXPlatform(platformid);
	}
	
	@GetMapping("/games/borrowed/{borrowed}")
	List<Game> listGameIfBorrowed(@PathVariable(name="borrowed")boolean borrowed){
		return gameServiceImpl.listGameIfBorrowed(borrowed);
	}
	
	@GetMapping("/games/user/{id}")
	List<Game> listGamesofUser(@PathVariable(name="id")int id_user){
		return gameServiceImpl.listGamesofUser(id_user);
	}


}
