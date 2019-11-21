package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSearchingService implements SearchingService {
    private static final Logger log = LogManager.getLogger(DefaultSearchingService.class);

    private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            new OpenLibraryService(),
            new BookMoochService(),
            new ITBookStoreService()
    );
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        long startTime = System.currentTimeMillis();
        String keyword = criteria.getKeyword();
        log.info("Search for books contain keyword: " + keyword);
        long startPot = System.currentTimeMillis();
        List<BookDto> internalBooks = bookService.findBooksWithNameContain(keyword);
        logTheTime(startPot, "internal");
        log.info("Found {} books in our DB", internalBooks.size());
        List<BookDto> output = new LinkedList<>();
        output.addAll(internalBooks);
        for (ExternalService exService: EXTERNAL_SERVICE) {
            String exServiceName = exService.getClass().getCanonicalName();
            startPot = System.currentTimeMillis();
            List<BookDto> exBooks = exService.search(keyword);
            logTheTime(startPot, exServiceName);
            log.info("Found {} books in {} service", exBooks.size(), exServiceName);
            output.addAll(exBooks);
        }
        log.info("Total found {} books in our DB and external services", output.size());
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "search", 
                System.currentTimeMillis() - startTime,
                String.format("keyword=%s", keyword));
        return output;
    }

    private void logTheTime(long startPot, String name) {
        log.info("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        log.info(">>> source: "+name+" take: "+(System.currentTimeMillis() - startPot)+" ms");
        log.info("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
    }
}

