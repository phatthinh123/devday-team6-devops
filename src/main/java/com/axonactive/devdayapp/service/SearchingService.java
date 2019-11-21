package com.axonactive.devdayapp.service;

import java.util.List;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;

public interface SearchingService {
    public List<BookDto> search(SearchingCriteria criteria);
}

