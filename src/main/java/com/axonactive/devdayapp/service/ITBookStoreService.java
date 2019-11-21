package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;

public class ITBookStoreService extends ExternalService {
    private static final String BASE_URL = "https://api.itbook.store/1.0/search/";
    private static final String GET_BOOK_URL = "https://api.itbook.store/1.0/books/";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(String rawResponse) {
        JSONObject response = new JSONObject(rawResponse);
        List<BookDto> output = new LinkedList<>();
        JSONArray books = response.getJSONArray("books");
        int len = books.length();
        for (int i = 0; i < len; ++i) {
            JSONObject bookMin = books.getJSONObject(i);
            String bookId = bookMin.getString("isbn13");
            String bookUrl = GET_BOOK_URL + bookId;
            RestTemplate restTemplate = new RestTemplate();
            String bookInJSON = restTemplate.getForObject(bookUrl, String.class);
            JSONObject book = new JSONObject(bookInJSON);
            
            String name = book.getString("title");
            String author = book.getString("authors");
            String preface = book.getString("desc");
            String coverUrl = book.getString("image");
            
            BookDto bookDto = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author)
                .withDescription(preface)
                .withCoverUrl(coverUrl)
                .fromSource(BookSource.IT_BOOK_STORE)
                .create();
            output.add(bookDto);
        }
        return output;
    }

    @Override
    protected String getServiceName() {
        return "IT Book Store";
    }
}

