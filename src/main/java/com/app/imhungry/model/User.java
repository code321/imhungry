package com.app.imhungry.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="User")
public class User {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String login;
	private String password;
	private String email;

	@OneToMany
	private List<Authority> authorities;

	protected User() {
	}

	public User(int id, String login, String password, String email,
			List<Authority> authorities) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
