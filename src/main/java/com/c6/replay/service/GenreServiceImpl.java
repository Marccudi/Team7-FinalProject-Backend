package com.c6.replay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c6.replay.dao.IGenreDAO;
import com.c6.replay.dto.Genre;

@Service
public class GenreServiceImpl implements IGenreService{
	@Autowired
	IGenreDAO genreDAO;
	
	@Override
	public List<Genre> listGenres() {
		// TODO Auto-generated method stub
		return genreDAO.findAll();
	}

	@Override
	public Genre saveGenre(Genre genre) {
		// TODO Auto-generated method stub
		return genreDAO.save(genre);
	}

	@Override
	public Genre genreXID(int id) {
		// TODO Auto-generated method stub
		return genreDAO.findById(id).get();
	}

	@Override
	public Genre updateGenre(Genre genre) {
		// TODO Auto-generated method stub
		return  genreDAO.save(genre);
	}

	@Override
	public void deleteGenre(int id) {
		// TODO Auto-generated method stub
		genreDAO.deleteById(id);
	}
}
