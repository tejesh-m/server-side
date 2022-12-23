package com.reader.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Subscription;
import com.reader.repo.ISubscribeRepo;

@Service
public class SubscribeService implements ISubscribeService {

	@Autowired
	ISubscribeRepo subscribeRepo;
	
	@Override
	public List<Subscription> subscribeByReaderId(Integer readerId) {
		List<Subscription> listSubscription =subscribeRepo.findByReaderId(readerId);
		return listSubscription;
	}

	@Override
	public Subscription saveSubscription(Subscription subscription) {
		Subscription saveSubscription = subscribeRepo.save(subscription);
		return saveSubscription;
	}
 
	@Override
	public Subscription getSubscriptionBySubscriptionId(Integer subscriptionId) {
		Subscription subscriptionById = subscribeRepo.findBySubscriptionId(subscriptionId);
		return subscriptionById;
	}

	@Override
	public LocalDateTime getDateBySubscriptionId(Integer subscriptionId) {
		// TODO Auto-generated method stub
		return subscribeRepo.getDateBySubscriptionId(subscriptionId);
	}

}
