package com.c6.replay.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="borrowings")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // AutoIncremental ID
	
	@ManyToOne
	@JoinColumn(name="id_game")
	private Game game; // Borrowed game
	
	@ManyToOne
	@JoinColumn(name="id_owner")
	private User userOwner; // Owner of the borrowed game
	
	@ManyToOne
	@JoinColumn(name="id_borrower")
	private User userBorrower; // Borrower of the borrowed game
	
	@Column(name="lend_date")
	private Date lend_date; // Loan date
	
	@Column(name="return_date")
	private Date return_date; // End date of loan

	/**
	 * 
	 */
	public Borrow() {
	}

	/**
	 * @param id
	 * @param game
	 * @param userOwner
	 * @param userBorrower
	 * @param lend_date
	 * @param return_date
	 */
	public Borrow(Long id, Game game, User userOwner, User userBorrower, Date lend_date, Date return_date) {
		this.id = id;
		this.game = game;
		this.userOwner = userOwner;
		this.userBorrower = userBorrower;
		this.lend_date = lend_date;
		this.return_date = return_date;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the userOwner
	 */
	public User getUserOwner() {
		return userOwner;
	}

	/**
	 * @param userOwner the userOwner to set
	 */
	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	/**
	 * @return the userBorrower
	 */
	public User getUserBorrower() {
		return userBorrower;
	}

	/**
	 * @param userBorrower the userBorrower to set
	 */
	public void setUserBorrower(User userBorrower) {
		this.userBorrower = userBorrower;
	}

	/**
	 * @return the lend_date
	 */
	public Date getLend_date() {
		return lend_date;
	}

	/**
	 * @param lend_date the lend_date to set
	 */
	public void setLend_date(Date lend_date) {
		this.lend_date = lend_date;
	}

	/**
	 * @return the return_date
	 */
	public Date getReturn_date() {
		return return_date;
	}

	/**
	 * @param return_date the return_date to set
	 */
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "Own [id=" + id + ", game=" + game + ", userOwner=" + userOwner + ", userBorrower=" + userBorrower
				+ ", lend_date=" + lend_date + ", return_date=" + return_date + "]";
	}
}
