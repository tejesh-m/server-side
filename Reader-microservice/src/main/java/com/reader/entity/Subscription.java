package com.reader.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subscriptionId;
	private Integer readerId;
	private Integer bookId;
	private LocalDateTime subscribedDate;

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public LocalDateTime getSubscribedDate() {
		return subscribedDate;
	}

	public void setSubscribedDate(LocalDateTime subscribedDate) {
		this.subscribedDate = subscribedDate;
	}

	public Subscription(Integer subscriptionId, Integer readerId, Integer bookId, LocalDateTime subscribedDate) {
		super();
		this.subscriptionId = subscriptionId;
		this.readerId = readerId;
		this.bookId = bookId;
		this.subscribedDate = subscribedDate;
	}

	public Subscription() {
		super();
	}

}
