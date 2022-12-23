package com.reader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Reader;
import com.reader.repo.IReaderRepo;

@Service
public class ReaderServiceImpl implements IReaderService {

	@Autowired
	IReaderRepo readerRepo;
	
	@Override
	public Reader saveReader(Reader reader) {
		Reader savedReader = readerRepo.save(reader);
		return savedReader;
	}

	@Override
	public Reader getReaderByEmail(String readerEmail) {
		Reader getReader = readerRepo.findByReaderEmail(readerEmail);
		return getReader;
	}

	@Override
	public Reader getReaderByReaderId(Integer readerId) {
		Reader getReaderById = readerRepo.findById(readerId).orElse(null);
		return getReaderById;
	}
	
	
	
	
}
