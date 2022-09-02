package com.c6.replay.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // AutoIncremental ID
	
	@Column(name="username")
	private String username; // username of the user
	
	@Column(name="email")
	private String email; // e-mail of the user
	
	@Column(name="password")
	private String password; // password of the user
	
	@Column(name="first_name")
	private String first_name; // first name of the user
	
	@Column(name="last_name")
	private String last_name; // last name of the user
	
	@Column(name="role")
	private String role;
	
	@OneToMany
	@JoinColumn(name="id_owner")
	private List<Own> borrowsOwner; // list of the borrows where the user is the owner of the game
	
	@OneToMany
	@JoinColumn(name="id_borrower")
	private List<Own> borrowsBorrower; // list of the borrows where the user is the borrower of the game
	
	@OneToMany
	@JoinColumn(name="id_old_owner")
	private List<Borrow> ownOwner; // list of the owns where the user is the old owner of the game
	
	@OneToMany
	@JoinColumn(name="id_new_owner")
	private List<Borrow> ownBorrower; // list of the owns where the user is the new owner of the game

	/**
	 * @param user_name
	 * @param email
	 * @param password
	 * @param first_name
	 * @param last_name
	 */
	public User(String username, String email, String password, String first_name, String last_name, String role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role=role;
	}

	/**
	 * 
	 */
	public User() {
		super();
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
	 * @return the user_name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the borrowsOwner
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Borrow")
	public List<Own> getBorrowsOwner() {
		return borrowsOwner;
	}

	/**
	 * @param borrowsOwner the borrowsOwner to set
	 */
	public void setBorrowsOwner(List<Own> borrowsOwner) {
		this.borrowsOwner = borrowsOwner;
	}

	/**
	 * @return the borrowsBorrower
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Borrow")
	public List<Own> getBorrowsBorrower() {
		return borrowsBorrower;
	}

	/**
	 * @param borrowsBorrower the borrowsBorrower to set
	 */
	public void setBorrowsBorrower(List<Own> borrowsBorrower) {
		this.borrowsBorrower = borrowsBorrower;
	}

	/**
	 * @return the ownOwner
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Own")
	public List<Borrow> getOwnOwner() {
		return ownOwner;
	}

	/**
	 * @param ownOwner the ownOwner to set
	 */
	public void setOwnOwner(List<Borrow> ownOwner) {
		this.ownOwner = ownOwner;
	}

	/**
	 * @return the ownBorrower
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Own")
	public List<Borrow> getOwnBorrower() {
		return ownBorrower;
	}

	/**
	 * @param ownBorrower the ownBorrower to set
	 */
	public void setOwnBorrower(List<Borrow> ownBorrower) {
		this.ownBorrower = ownBorrower;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", role= "+ role +"]";
	}
}
