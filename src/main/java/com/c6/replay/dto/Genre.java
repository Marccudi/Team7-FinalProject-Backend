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
	private List<Game> game;


	
}
