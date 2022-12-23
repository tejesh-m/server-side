package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.ILibraryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class LibraryController {
	
	@Autowired
	ILibraryService libraryService;
	
	@PostMapping("/add/book")
	Integer createBook(@RequestBody Book book) {
		Integer id = libraryService.createBook(book);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/allbooks")
	public List<Book> getAllBooks(){
		return libraryService.getAllBooks();
	}

	@GetMapping("/read/{id}")
	public Optional<Book> getABook(@PathVariable Integer id){
		Optional<Book> book = libraryService.getABook(id);
		return book;
	}
	
	@DeleteMapping("/remove/{bookId}")
	public ResponseEntity<Book> deleteABook(@PathVariable Integer bookId){
		System.out.println(bookId);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			libraryService.deleteABook(bookId);
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> editABook(@PathVariable("id") Integer id, @RequestBody Book book){
		return new ResponseEntity<Book>(libraryService.editABook(book, id),HttpStatus.OK);
	}
	
	@PutMapping("/borrow/{id}")
	public ResponseEntity<Book> editBorrowedStatus(@PathVariable("id") Integer id, @RequestBody Book book){
		return new ResponseEntity<Book>(libraryService.editABook(book, id),HttpStatus.OK);
	}
}
