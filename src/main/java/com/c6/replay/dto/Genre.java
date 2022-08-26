package com.c6.replay.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genres")
public class Genre {
	@Id
	private int id;
	@Column
	private String name;

	@OneToMany
	@JoinColumn(name = "id")
	private List<GameHaveGenre> gameHaveGenre;

	public Genre() {
	}

	public Genre(int id, String name, List<GameHaveGenre> gameHaveGenre) {
		this.id = id;
		this.name = name;
		this.gameHaveGenre = gameHaveGenre;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gameHaveGenre")
	public List<GameHaveGenre> getGameHaveGenre() {
		return gameHaveGenre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGameHaveGenre(List<GameHaveGenre> gameHaveGenre) {
		this.gameHaveGenre = gameHaveGenre;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}

}
