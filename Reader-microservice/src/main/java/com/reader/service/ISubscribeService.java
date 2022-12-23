package com.reader.service;

import java.time.LocalDateTime;
import java.util.List;

import com.reader.entity.Subscription;

public interface ISubscribeService {
	public List<Subscription> subscribeByReaderId(Integer readerId);
	
	public Subscription saveSubscription(Subscription subscription);
	
	public Subscription getSubscriptionBySubscriptionId(Integer subscriptionId);
	
	public LocalDateTime getDateBySubscriptionId(Integer subscriptionId);
}
