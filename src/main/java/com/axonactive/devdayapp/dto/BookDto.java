package com.axonactive.devdayapp.dto;

import java.util.List;
import java.util.Arrays;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.enums.BookSource;

public class BookDto {

	private Long id;
    private String name;
    private String author;
    private String serialNumber;
    private List<BookDetailDto> details;
    private List<UserDto> subscribers;

    /**
     * This function just pull out basic information of the entity only
     * for others information, please do it yourself
     */
    public static BookDto fromEntity(Book entity) {
        BookDto dto = new BookDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.author = entity.getAuthor();
        dto.serialNumber = entity.getSerialNumber();
        return dto;
    }

    public static SingleBookCreator createSingleBook() {
        return new SingleBookCreator();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<BookDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<BookDetailDto> details) {
        this.details = details;
    }

    public List<UserDto> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<UserDto> subscribers) {
        this.subscribers = subscribers;
    }

    public static class SingleBookCreator {

        private BookDto book = new BookDto();
        private BookDetailDto detail = new BookDetailDto();

        public SingleBookCreator withName(String name) {
            book.name = name;
            return this;
        }

        public SingleBookCreator withAuthor(String author) {
            book.author = author;
            return this;
        }

        public SingleBookCreator withDescription(String description) {
            detail.setDescription(description);
            return this;
        }

        public SingleBookCreator withCoverUrl(String coverUrl) {
            detail.setCoverUrl(coverUrl);
            return this;
        }

        public SingleBookCreator fromSource(BookSource source) {
            detail.setSource(source);
            return this;
        }

        public BookDto create() {
            book.setDetails(Arrays.asList(detail));
            return book;
        }
    }
}

