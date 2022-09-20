package com.c6.replay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c6.replay.dto.Genre;
import com.c6.replay.service.GenreServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api")
public class GenreController {
	@Autowired
	GenreServiceImpl genreServiceImpl;
	
	@GetMapping("/genres")
	public List<Genre> listGenres() {
		return genreServiceImpl.listGenres();
	}
	
	@PostMapping("/genres")
	public Genre saveGenre(@RequestBody Genre genre) {
		return genreServiceImpl.saveGenre(genre);
	}
	
	@GetMapping("/genres/{id}")
	public Genre genreXID(@PathVariable(name="id") int id) {
		
		Genre genre_xid= new Genre();
		
		//Find genre with id
		genre_xid=genreServiceImpl.genreXID(id);
		
		System.out.println("Genre by ID: "+genre_xid);
		
		return genre_xid;
	}
	
	@PutMapping("/genres/{id}")
	public Genre updateGenre(@PathVariable(name="id")int id,@RequestBody Genre genre) {
		
		Genre selectedGenre= new Genre();
		Genre updatedGenre= new Genre();
		
		//Find existing genre with id
		selectedGenre= genreServiceImpl.genreXID(id);
		
		//Set the values to the given parameters
		selectedGenre.setName(genre.getName());
		
		updatedGenre = genreServiceImpl.updateGenre(selectedGenre);
		
		System.out.println("The updated genre is: "+ updatedGenre);
		
		return updatedGenre;
	}
	
	@DeleteMapping("/genres/{id}")
	public void deleteGenre(@PathVariable(name="id")int id) {
		genreServiceImpl.deleteGenre(id);
	}

}
