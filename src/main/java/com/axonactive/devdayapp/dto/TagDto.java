package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.domain.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TagDto {
	private Long id;
    private BookDetailDto bookDetail;
    private String name;

    public static TagDto fromEntity(Tag entity) {
        if (entity == null) return null;
        TagDto dto = new TagDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public BookDetailDto getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetailDto bookDetail) {
        this.bookDetail = bookDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

