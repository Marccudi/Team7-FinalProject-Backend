package com.c6.replay.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.example.demo.dto.Venta;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "duration")
	private int duration;
	@Column(name = "year_released")
	private int yearReleased;
	@Column(name = "age_calification")
	private String ageCalification;
	@Column(name = "description")
	private String description;
	@Column(name = "date_inserted")
	private Date dateInserted;
	
	@ManyToOne
	@JoinColumn(name = "id_developer")
	Developer developer;
	
	@ManyToOne
	@JoinColumn(name = "id_platform")
	Platform platform;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Own> owns;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Borrowing> borrowings;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<GameHaveGenre> gameHaveGenres;
}
