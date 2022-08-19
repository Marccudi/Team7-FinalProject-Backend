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
@Table(name = "platform")
public class Platform {
	@Id
	private int id;
	@Column
	private String name;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Game> game;

	public Platform(int id, String name, List<Game> game) {
		this.id = id;
		this.name = name;
		this.game = game;
	}

	public Platform() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
	public List<Game> getGame() {
		return game;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGame(List<Game> game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Platform [id=" + id + ", name=" + name + "]";
	}

}
