package com.c6.replay.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "duration")
	private int duration;
	@Column(name = "year_released")
	private int yearReleased;
	@Column(name = "age_calification")
	private String ageCalification;
	@Column(name = "description")
	private String description;
	@Column(name = "date_inserted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInserted;
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "borrowed")
	private boolean borrowed;
	
	@ManyToOne
	@JoinColumn(name = "id_developer")
	Developer developer;
	
	@ManyToOne
	@JoinColumn(name = "id_platform")
	Platform platform;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Borrow> owns;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Own> borrows;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<GameHaveGenre> gameHaveGenres;

	public Game() {
		super();
	}

	public Game(int id, String title, int duration, int yearReleased, String ageCalification, String description, Date dateInserted,
			boolean enabled, Developer developer, Platform platform, List<Borrow> owns, List<Own> borrows,
			List<GameHaveGenre> gameHaveGenres) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.yearReleased = yearReleased;
		this.ageCalification = ageCalification;
		this.description = description;
		this.dateInserted = dateInserted;
		this.enabled = enabled;
		this.developer = developer;
		this.platform = platform;
		this.owns = owns;
		this.borrows = borrows;
		this.gameHaveGenres = gameHaveGenres;
		this.borrowed = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getAgeCalification() {
		return ageCalification;
	}

	public void setAgeCalification(String ageCalification) {
		this.ageCalification = ageCalification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateInserted() {
		return dateInserted;
	}

	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	/**
	 * @return the borrowed
	 */
	public boolean isBorrowed() {
		return borrowed;
	}

	/**
	 * @param borrowed the borrowed to set
	 */
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Own")
	public List<Borrow> getOwns() {
		return owns;
	}

	public void setOwns(List<Borrow> owns) {
		this.owns = owns;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Borrow")
	public List<Own> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Own> borrows) {
		this.borrows = borrows;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "GameHaveGenre")
	public List<GameHaveGenre> getGameHaveGenres() {
		return gameHaveGenres;
	}

	public void setGameHaveGenres(List<GameHaveGenre> gameHaveGenres) {
		this.gameHaveGenres = gameHaveGenres;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", duration=" + duration + ", yearReleased=" + yearReleased
				+ ", ageCalification=" + ageCalification + ", description=" + description + ", dateInserted="
				+ dateInserted + ", enabled=" + enabled + ", borrowed=" + borrowed + ", developer=" + developer
				+ ", platform=" + platform + ", owns=" + owns + ", borrows=" + borrows + ", gameHaveGenres="
				+ gameHaveGenres + "]";
	}

}
