package com.reader.service;

import com.reader.entity.Reader;

public interface IReaderService {
	public Reader saveReader(Reader reader);
	
	public Reader getReaderByEmail(String readerEmail);
	
	public Reader getReaderByReaderId(Integer readerId);
}
