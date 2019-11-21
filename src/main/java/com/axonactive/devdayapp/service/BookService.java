package com.axonactive.devdayapp.service;

import java.util.List;

import com.axonactive.devdayapp.dto.BookDto;

public interface BookService {

    List<BookDto> findBooksWithNameContain(String keyword);
    public BookDto findById(long bookId);
    public List<BookDto> getAll();
}

