package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.UserDto;

public interface UserService {

	Boolean save(UserDto userDto);

	UserDto findByUsername(String username);
}

