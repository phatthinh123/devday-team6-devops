package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookMoochService extends ExternalService {
    private static final String BASE_URL = "http://api.bookmooch.com/api/search?db=bm&o=json&txt=";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(String rawResponse) {
        JSONArray response = new JSONArray(rawResponse);
        List<BookDto> output = new LinkedList<>();

        int len = response.length();
        for (int i = 0; i < len; ++i) {
            JSONObject book = response.getJSONObject(i);
            String author = "";
            try {
                author = book.getString("Author");
            } catch(JSONException ignored) {}
            String preface = "";
            try {
                preface = book.getString("EditorialReview_Content");
            } catch(JSONException ignored){}
            String coverUrl = "";
            try {
                coverUrl = book.getString("SmallImage_URL");
                coverUrl = book.getString("MediumImage_URL");
                coverUrl = book.getString("LargeImage_URL");
            } catch(JSONException ignored){}
            coverUrl = coverUrl.replaceAll("\\\\\\/", "/");
            String name = book.getString("Title");

            BookDto bookDto = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author)
                .withDescription(preface)
                .withCoverUrl(coverUrl)
                .fromSource(BookSource.BOOK_MOOCH)
                .create();
            output.add(bookDto);
        }
        return output;
    }

    @Override
    protected String getServiceName() {
        return "BookMooch";
    }
}

