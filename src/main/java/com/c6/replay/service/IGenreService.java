package com.c6.replay.service;

import java.util.List;

import com.c6.replay.dto.Genre;

public interface IGenreService {
public List<Genre> listGenres(); // List all the genres
	
	public Genre saveGenre(Genre genre); // Save a genre
	
	public Genre genreXID(int id); // List one Genre by id
	
	public Genre updateGenre(Genre genre); // Update genre
	
	public void deleteGenre(int id); // Delete Genre
}
