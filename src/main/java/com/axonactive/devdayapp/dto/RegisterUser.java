package com.axonactive.devdayapp.dto;

public class RegisterUser {

	private String username;
	private String password;
    private String fullName;
    private String email;

    public static UserDto toUserDTO(RegisterUser loginUser) {
        if (loginUser == null) return null;
        UserDto userDto = new UserDto();
        userDto.setUsername(loginUser.getUsername());
        userDto.setPassword(loginUser.getPassword());
        userDto.setFullName(loginUser.getFullName());
        userDto.setEmail(loginUser.getEmail());
        return userDto;
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
}
