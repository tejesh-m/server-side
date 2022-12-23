package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Book;

public interface ILibraryService {

	Integer createBook(Book book);
	
	public List<Book> getAllBooks();
	
	Optional<Book> getABook(Integer bookId);
	
	public void deleteABook(Integer bookId);
	
	Book editABook(Book book ,Integer bookId);
	
	Book editBorrowedStatus(Book book ,Integer bookId);
}
