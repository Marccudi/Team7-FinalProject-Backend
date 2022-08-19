package com.c6.replay.dto;

import javax.persistence.*;

public class GameHaveGenre {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_game")
	Game developer;
	
	@ManyToOne
	@JoinColumn(name = "id_genre")
	Genre genre;

	public GameHaveGenre() {
		super();
	}

	public GameHaveGenre(int id, Game developer, Genre genre) {
		super();
		this.id = id;
		this.developer = developer;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getDeveloper() {
		return developer;
	}

	public void setDeveloper(Game developer) {
		this.developer = developer;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "GameHaveGenre [id=" + id + ", developer=" + developer + ", genre=" + genre + "]";
	}
	
	

}
