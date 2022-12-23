package com.reader.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer readerId;
	private String readerEmail;
	private String password;
	private String readerName;

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public String getReaderEmail() {
		return readerEmail;
	}

	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Reader(Integer readerId, String readerEmail, String password, String readerName) {
		super();
		this.readerId = readerId;
		this.readerEmail = readerEmail;
		this.password = password;
		this.readerName = readerName;
	}

	public Reader(String readerEmail, String password) {
		super();
		this.readerEmail = readerEmail;
		this.password = password;
	}

	public Reader() {
		super();
	}

}
