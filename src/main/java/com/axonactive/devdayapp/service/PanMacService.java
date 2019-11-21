package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PanMacService extends ExternalService {
    private static final String BASE_URL = "http://extracts.panmacmillan.com/getextracts?titlecontains=";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(String rawResponse) {
        JSONObject response = new JSONObject(rawResponse);
        List<BookDto> output = new LinkedList<>();
        JSONArray books = response.getJSONArray("Extracts");
        int len = books.length();
        for (int i = 0; i < len; ++i) {
            JSONObject book = books.getJSONObject(i);
            String name = book.getString("title");
            String author = book.getString("author");
            String cover = book.getString("jacketUrl");
            String preface = book.getString("extractHtml");

            BookDto bookDto = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author)
                .withDescription(preface)
                .withCoverUrl(cover)
                .fromSource(BookSource.PANMAC)
                .create();

            output.add(bookDto);
        }
        return output;
    }

    @Override
    protected String getServiceName() {
        return "PanMac";
    }

}

