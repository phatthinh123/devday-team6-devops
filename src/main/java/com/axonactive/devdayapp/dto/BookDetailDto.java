package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.Tag;
import com.axonactive.devdayapp.enums.BookSource;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class BookDetailDto {
	private Long id;
    private BookDto book;
    private BookSource source;
    private String description;
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<TagDto> tags;
    private String coverUrl;

    /**
     * This function just pull out basic information of the entity only
     * for others information, please do it yourself
     */
    public static BookDetailDto fromEntity(BookDetail entity) {
        BookDetailDto dto = new BookDetailDto();
        dto.id = entity.getId();
        dto.source = entity.getSource();
        dto.description = entity.getDescription();
        dto.coverUrl = entity.getCoverUrl();
        dto.tags = new ArrayList<>();
        if (entity.getTags() != null) {
            for (Tag tag: entity.getTags()) {
                dto.tags.add(TagDto.fromEntity(tag));
            }
        }
        dto.ratings = new ArrayList<>();
        if (entity.getRatings() != null) {
            for (Rating rating: entity.getRatings()) {
                dto.ratings.add(RatingDto.fromEntity(rating));
            }
        }
        dto.comments = new ArrayList<>();
        if (entity.getComments() != null) {
            for (Comment comment: entity.getComments()) {
                dto.comments.add(CommentDto.fromEntity(comment));
            }
        }
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public BookSource getSource() {
        return source;
    }

    public void setSource(BookSource source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
}
