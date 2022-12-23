package com.digitalbooks.entity;

import java.io.Serializable;

import javax.persistence.Entity;


public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// JSON Parsing needs default constructor
	public JwtRequest() {

	}

	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + "]";
	}

}
