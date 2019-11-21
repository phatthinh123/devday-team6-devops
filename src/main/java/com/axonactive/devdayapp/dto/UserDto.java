package com.axonactive.devdayapp.dto;

import java.util.Date;
import java.util.List;

import com.axonactive.devdayapp.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

	private Long id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
    private String fullName;
    private String email;
    @JsonIgnore
    private Date createAt;
    @JsonIgnore
    private List<CommentDto> comments;
    
    private List<DeviceDto> devices;
    @JsonIgnore
    private List<RatingDto> ratings;
    @JsonIgnore
    private List<BookDto> bookInWishList;

    public static UserDto fromEntity(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.id = entity.getId();
        dto.username = entity.getUsername();
        dto.password = entity.getPassword();
        dto.fullName = entity.getFullName();
        dto.email = entity.getEmail();
        dto.createAt = entity.getCreateAt();
        return dto;
    }

    
    public static User toEntity(UserDto userDto) {
    	if (userDto == null) return null;
    	User entityUser = new User();
    	entityUser.setId(userDto.getId());
    	entityUser.setUsername(userDto.getUsername());
    	entityUser.setPassword(userDto.getPassword());
    	entityUser.setFullName(userDto.getFullName());
    	entityUser.setEmail(userDto.getEmail());
    	entityUser.setCreateAt(userDto.getCreateAt());
    	return entityUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<DeviceDto> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDto> devices) {
        this.devices = devices;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<BookDto> getBookInWishList() {
        return bookInWishList;
    }

    public void setBookInWishList(List<BookDto> bookInWishList) {
        this.bookInWishList = bookInWishList;
    }
}
