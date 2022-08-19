package com.c6.replay.dto;

import javax.persistence.*;

public class GameHaveGenre {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_game")
	Game game;
	
	@ManyToOne
	@JoinColumn(name = "id_genre")
	Genre genre;

	public GameHaveGenre() {
		super();
	}

	public GameHaveGenre(int id, Game game, Genre genre) {
		super();
		this.id = id;
		this.game = game;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "GameHaveGenre [id=" + id + ", game=" + game + ", genre=" + genre + "]";
	}
	
	

}
