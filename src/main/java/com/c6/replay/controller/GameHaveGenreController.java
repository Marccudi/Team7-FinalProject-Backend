package com.c6.replay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c6.replay.dto.GameHaveGenre;
import com.c6.replay.service.GameHaveGenreServiceImpl;

@RestController
@RequestMapping("/api")
public class GameHaveGenreController {

	@Autowired
	GameHaveGenreServiceImpl gameHaveGenreServiceImpl;
	
	@GetMapping("/gameHaveGenres")
	public List<GameHaveGenre> listGameHaveGenres() {
		return gameHaveGenreServiceImpl.listGameHaveGenres();
	}
	
	@PostMapping("/gameHaveGenres")
	public GameHaveGenre saveGameHaveGenre(@RequestBody GameHaveGenre gameHaveGenre) {
		return gameHaveGenreServiceImpl.saveGameHaveGenre(gameHaveGenre);
	}
	
	@GetMapping("/gameHaveGenres/{id}")
	public GameHaveGenre gameHaveGenreXID(@PathVariable(name="id") int id) {
		
		GameHaveGenre gameHaveGenre_xid= new GameHaveGenre();
		
		//Find gameHaveGenre with id
		gameHaveGenre_xid=gameHaveGenreServiceImpl.gameHaveGenreXID(id);
		
		System.out.println("GameHaveGenre by ID: "+gameHaveGenre_xid);
		
		return gameHaveGenre_xid;
	}
	
	@PutMapping("/gameHaveGenres/{id}")
	public GameHaveGenre updateGameHaveGenre(@PathVariable(name="id")int id,@RequestBody GameHaveGenre gameHaveGenre) {
		
		GameHaveGenre selectedGameHaveGenre= new GameHaveGenre();
		GameHaveGenre updatedGameHaveGenre= new GameHaveGenre();
		
		//Find existing gameHaveGenre with id
		selectedGameHaveGenre= gameHaveGenreServiceImpl.gameHaveGenreXID(id);
		
		//Set the values to the given parameters
		selectedGameHaveGenre.setGame(gameHaveGenre.getGame());
		selectedGameHaveGenre.setGenre(gameHaveGenre.getGenre());
		
		updatedGameHaveGenre = gameHaveGenreServiceImpl.updateGameHaveGenre(selectedGameHaveGenre);
		
		System.out.println("The updated gameHaveGenre is: "+ updatedGameHaveGenre);
		
		return updatedGameHaveGenre;
	}
	
	@DeleteMapping("/gameHaveGenres/{id}")
	public void deleteGameHaveGenre(@PathVariable(name="id")int id) {
		gameHaveGenreServiceImpl.deleteGameHaveGenre(id);
	}
	
}
