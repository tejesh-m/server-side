package com.reader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reader.entity.Reader;

@Repository
public interface IReaderRepo extends JpaRepository<Reader, Integer> {
	Reader findByReaderEmail(String readerEmail);
}
