package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.exception.ResourceNotFoundException;

@Service
public class LibraryServiceImpl implements ILibraryService {

	@Autowired
	ILibraryRepo libraryRepo;
	
	@Override
	public Integer createBook(Book book) {
		Book createBook = libraryRepo.save(book);
		return createBook.getBookId();
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return libraryRepo.findAll();
	}

	@Override
	public Optional<Book> getABook(Integer bookId) {
		// TODO Auto-generated method stub
		return libraryRepo.findById(bookId);
	}

	@Override
	public void deleteABook(Integer bookId) {
		// TODO Auto-generated method stub
		libraryRepo.deleteById(bookId);
	}

	@Override
	public Book editABook(Book book, Integer bookId) {
		Book existingBook = libraryRepo.findById(bookId).orElseThrow(
				() -> new ResourceNotFoundException("Book", "id", bookId));
		existingBook.setBookName(book.getBookName());
		existingBook.setBookAuthor(book.getBookAuthor());
		existingBook.setBookGenre(book.getBookGenre());
		existingBook.setBookPrice(book.getBookPrice());
		existingBook.setBorrowedStatus(book.isBorrowedStatus());
		
		libraryRepo.save(existingBook);
		return existingBook;
	}

	@Override
	public Book editBorrowedStatus(Book book, Integer bookId) {
		Book existingBook = libraryRepo.findById(bookId).orElseThrow(
				() -> new ResourceNotFoundException("Book", "id", bookId));
		existingBook.setBookName(book.getBookName());
		existingBook.setBookAuthor(book.getBookAuthor());
		existingBook.setBookGenre(book.getBookGenre());
		existingBook.setBookPrice(book.getBookPrice());
		existingBook.setBorrowedStatus(book.isBorrowedStatus());
		
		libraryRepo.save(existingBook);
		return existingBook;
	}

}
