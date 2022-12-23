package com.reader.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private Integer bookId;
	private String logo;
	private String title;
	private String category;
	private Integer price;
	private String authorName;
	private String publisher;
	private Integer publishedDate;
	private Integer chapters;
	private boolean active;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Integer publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Integer getChapters() {
		return chapters;
	}
	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Book(Integer bookId, String logo, String title, String category, Integer price, String authorName,
			String publisher, Integer publishedDate, Integer chapters, boolean active) {
		super();
		this.bookId = bookId;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.chapters = chapters;
		this.active = active;
	}
	public Book() {
		super();
	}
	
	
}
