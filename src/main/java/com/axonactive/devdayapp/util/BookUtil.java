package com.axonactive.devdayapp.util;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.BookDto;

public class BookUtil {
	public static BookDto toSimpleBookDto(Book book) {
		if(null == book) {
			return null;
		}else {
			BookDto dto = new BookDto();
			dto.setAuthor(book.getName());
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setSerialNumber(book.getSerialNumber());
			return dto;
		}
			
	}
	public static BookDto toFullBookDto(Book book) {
		if(null == book) {
			return null;
		}else {
			BookDto dto = new BookDto();
			dto.setAuthor(book.getName());
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setSerialNumber(book.getSerialNumber());
			dto.setDetails(StreamSupport.stream(book.getDetails().spliterator(),false)
										.map(bookDetail -> BookDetailUtil.toBookDetailDto(bookDetail))
							            .collect(Collectors.toList()));
			return dto;
		}
			
	}
}
