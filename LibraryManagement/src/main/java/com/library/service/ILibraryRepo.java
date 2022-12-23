package com.library.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public interface ILibraryRepo extends JpaRepository<Book, Integer> {

}
