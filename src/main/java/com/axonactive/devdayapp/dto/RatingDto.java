package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.domain.Rating;

public class RatingDto {
	private Long id;
    private BookDetailDto bookDetail;
    private UserDto user;
    private Integer value;

    public static RatingDto fromEntity(Rating entity) {
        if (entity == null) return null;
        RatingDto dto = new RatingDto();
        dto.id = entity.getId();
        dto.value = entity.getValue();
        dto.user = UserDto.fromEntity(entity.getUser());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDetailDto getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetailDto bookDetail) {
        this.bookDetail = bookDetail;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

