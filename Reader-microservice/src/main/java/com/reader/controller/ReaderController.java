package com.reader.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reader.entity.Book;
import com.reader.entity.Reader;
import com.reader.entity.Subscription;
import com.reader.service.IReaderService;
import com.reader.service.ISubscribeService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
@CrossOrigin("http://localhost:4200/")
public class ReaderController {
	@Autowired
	IReaderService readerService;
	
	@Autowired
	ISubscribeService subscribeService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/reader/signup")
	public Integer registerReader(@RequestBody Reader reader) {
		Reader registeredReader = readerService.saveReader(reader);
		return registeredReader.getReaderId();
	}
	
	@GetMapping("/reader/signin")
	public Boolean signinReader(@RequestParam("readerEmail") String readerEmail, @RequestParam("password") String password) {
		Reader sessionReader = readerService.getReaderByEmail(readerEmail);
		if(sessionReader.getPassword().equals(password))
			return true;
		return false;
	}
	
	@PostMapping("/{readerId}/{bookId}/subscribe")
	public Subscription subscribeBook(@PathVariable Integer readerId, @PathVariable Integer bookId) {
		Book getBook = restTemplate.getForObject("http://localhost:8080/api/v1/digitalbooks/book/"+bookId, Book.class);
		Subscription newSub = new Subscription();
		newSub.setReaderId(readerId);
		newSub.setBookId(bookId);
		java.time.LocalDateTime date =java.time.LocalDateTime.now();
		newSub.setSubscribedDate(date);
		Subscription savedSub = subscribeService.saveSubscription(newSub);
		return savedSub;
	}
	
	@GetMapping("/readers/{readerEmail}/books")
	public List<Book> getSubscribedBook(@PathVariable String readerEmail) {
		Reader reader = readerService.getReaderByEmail(readerEmail);
		Integer readerId = reader.getReaderId();
		List<Subscription> subscriptionList = subscribeService.subscribeByReaderId(readerId);
		List<Book> book = new ArrayList<Book>();
		subscriptionList.stream().forEach( 
				(sub) -> {book.add(
				restTemplate.getForObject("http://localhost:8080/api/v1/digitalbooks/book/"+sub.getBookId(), Book.class)
						);}
				);
		return book;
				
	}
	
	@GetMapping("/readers/{readerEmail}/books/{subscriptionId}")
	public Book getBookBySubid(@PathVariable String readerEmail, @PathVariable Integer subscriptionId) {
		Subscription sub = subscribeService.getSubscriptionBySubscriptionId(subscriptionId);
		Integer readerId = sub.getReaderId();
		Integer bookId = sub.getBookId();
		Reader reader = readerService.getReaderByReaderId(readerId);
		if(reader.getReaderEmail().equals(readerEmail)) {
			Book book = restTemplate.getForObject("http://localhost:8080/api/v1/digitalbooks/book/"+bookId, Book.class);
			return book;
		}
		return null;
	}
	
//	@PostMapping("/readers/{readerEmail}/books/{subscriptionId}/cancelSubscription")
//	public String checkIfUnsubscribeIsValid(@PathVariable String readerEmail, @PathVariable Integer subscriptionId) {
//		LocalDateTime date = subscribeService.getDateBySubscriptionId(subscriptionId);
//		String subscribedDate = (String)date;
//		return subscribedDate;
//	}

}
