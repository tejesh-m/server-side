package com.reader.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reader.entity.Subscription;

public interface ISubscribeRepo extends JpaRepository<Subscription, Integer> {

	List<Subscription> findByReaderId(Integer readerId);
	
	Subscription findBySubscriptionId(Integer SubscriptionId);

	LocalDateTime getDateBySubscriptionId(Integer subscriptionId);
}
