package com.axonactive.devdayapp.dto;

public class LoginUser {

	private Long userId;
	private String username;
    private String fullName;
    private String email;

    public static LoginUser toLoginUser(UserDto userDto) {
        if (userDto == null) return null;
        LoginUser loginUser = new LoginUser();
		loginUser.setUserId(userDto.getId());
		loginUser.setUsername(userDto.getUsername());
		loginUser.setFullName(userDto.getFullName());
		loginUser.setEmail(userDto.getEmail());
        return loginUser;
    }
    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
