package com.digitalbooks.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookRepo bookRepo;
	
	@Override
	public Integer createBook(Book book) {
		Book createBook = bookRepo.save(book);
		return createBook.getBookId();
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}


//	@Override
//	public Book editABook(Book book, Integer bookId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Book editBorrowedStatus(Book book, Integer bookId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Book> getAllBooks(String title, String authorName, String publisher, Integer price) {
		List<Book>	allBooks = bookRepo.findAll();
		
		if(publisher!=null && title!=null && authorName!=null && price!=0) {
			allBooks = allBooks.stream()
						.filter(bo -> bo.getTitle().equals(title))
						.filter(bo -> bo.getAuthorName().equals(authorName))
						.filter(bo -> bo.getPublisher().equals(publisher))
						.filter(bo -> bo.getPrice() <= price)
						.collect(Collectors.toList());
		}
		System.out.println("Search Results: "+allBooks);
		return allBooks;
	}

	@Override
	public Optional<Book> getBookById(Integer bookId) {
		
		return bookRepo.findById(bookId);
	}

	@Override
	public List<Book> getAllBooks(boolean active) {
		List<Book> allBooks = bookRepo.findAll();

		System.out.println("Search Results: " + allBooks);
		return allBooks;
	}

	

}
