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
@Table(name="owns")
public class Own {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // AutoIncremental ID
	
	@ManyToOne
	@JoinColumn(name="id_game_old_owner")
	private Game gameOldOwner; // Changed game
	
	@ManyToOne
	@JoinColumn(name="id_game_new_owner")
	private Game gameNewOwner; // Changed game
	
	@ManyToOne
	@JoinColumn(name="id_old_owner")
	private User userOldOwner; // Old owner of the game
	
	@ManyToOne
	@JoinColumn(name="id_new_owner")
	private User userNewOwner; // New owner of the game
	
	@Column(name="exchange_date")
	private Date exchange_date; // Exchange date
	
	@Column(name="pending")
	private boolean pending;

	/**
	 * 
	 */
	public Own() {
		super();
	}

	/**
	 * @param id
	 * @param game
	 * @param userOldOwner
	 * @param userNewOwner
	 * @param lend_date
	 */
	public Own(Long id, Game gameOldOwner, Game gameNewOwner, User userOldOwner, User userNewOwner, Date lend_date) {
		super();
		this.id = id;
		this.gameOldOwner = gameOldOwner;
		this.gameNewOwner = gameNewOwner;
		this.userOldOwner = userOldOwner;
		this.userNewOwner = userNewOwner;
		this.exchange_date = lend_date;
		this.pending=true;
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
	 * @return the gameOldOwner
	 */
	public Game getGameOldOwner() {
		return gameOldOwner;
	}

	/**
	 * @param gameOldOwner the gameOldOwner to set
	 */
	public void setGameOldOwner(Game gameOldOwner) {
		this.gameOldOwner = gameOldOwner;
	}

	/**
	 * @return the gameNewOwner
	 */
	public Game getGameNewOwner() {
		return gameNewOwner;
	}

	/**
	 * @param gameNewOwner the gameNewOwner to set
	 */
	public void setGameNewOwner(Game gameNewOwner) {
		this.gameNewOwner = gameNewOwner;
	}

	/**
	 * @return the userOldOwner
	 */
	public User getUserOldOwner() {
		return userOldOwner;
	}

	/**
	 * @param userOldOwner the userOldOwner to set
	 */
	public void setUserOldOwner(User userOldOwner) {
		this.userOldOwner = userOldOwner;
	}

	/**
	 * @return the userNewOwner
	 */
	public User getUserNewOwner() {
		return userNewOwner;
	}

	/**
	 * @param userNewOwner the userNewOwner to set
	 */
	public void setUserNewOwner(User userNewOwner) {
		this.userNewOwner = userNewOwner;
	}

	/**
	 * @return the lend_date
	 */
	public Date getExchange_date() {
		return exchange_date;
	}

	/**
	 * @param lend_date the lend_date to set
	 */
	public void setExchange_date(Date lend_date) {
		this.exchange_date = lend_date;
	}
	
	/**
	 * @return the pending
	 */
	public boolean isPending() {
		return pending;
	}

	/**
	 * @param pending the pending to set
	 */
	public void setPending(boolean pending) {
		this.pending = pending;
	}

	@Override
	public String toString() {
		return "Own [id=" + id + ", gameOldOwner=" + gameOldOwner + ", gameNewOwner=" + gameNewOwner + ", userOldOwner="
				+ userOldOwner + ", userNewOwner=" + userNewOwner + ", exchange_date=" + exchange_date + ", pending="
				+ pending + "]";
	}
}
