package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private float bookPrice;
	private String bookGenre;
	private boolean borrowedStatus;

	

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public boolean isBorrowedStatus() {
		return borrowedStatus;
	}

	public void setBorrowedStatus(boolean borrowedStatus) {
		this.borrowedStatus = borrowedStatus;
	}

	public Book(Integer bookId, String bookName, String bookAuthor, float bookPrice, String bookGenre,
			boolean borrowedStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookGenre = bookGenre;
		this.borrowedStatus = borrowedStatus;
	}

	public Book() {
		super();
	}

}
