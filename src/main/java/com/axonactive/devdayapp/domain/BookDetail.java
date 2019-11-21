package com.axonactive.devdayapp.domain;

import com.axonactive.devdayapp.enums.BookSource;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="book_details")
public class BookDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Column
    private BookSource source;

    @Transient
    @Column (length = 500)
    private String description;

    @Column(name="cover_url")
    private String coverUrl;

    @OneToMany(mappedBy="bookDetail")
    private List<Comment> comments;

    @OneToMany(mappedBy="bookDetail")
    private List<Rating> ratings;

    @OneToMany(mappedBy="bookDetail")
    private List<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
