package com.axonactive.devdayapp.dto;

public class DeviceDto {
	private Long id;
    private UserDto user;
    private String status;
    private String token;

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

