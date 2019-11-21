package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

@Service
public class DefaultUserService implements UserService {
    private static final Logger log = LogManager.getLogger(DefaultUserService.class);
    
	@Autowired
    private UserRepository userRepository;

	@Override
	public Boolean save(UserDto userDto) {
		long startTime = System.currentTimeMillis();
		Assert.notNull(userDto.getUsername(), "Username cannot be empty!");
		Assert.notNull(userDto.getPassword(), "Password cannot be empty!");
		
		userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        User savedUser = userRepository.save(UserDto.toEntity(userDto));
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "save", 
                System.currentTimeMillis() - startTime,
                String.format("userName=%s, password=%s", userDto.getUsername(), userDto.getPassword()));
        return savedUser != null;
	}

	@Override
	public UserDto findByUsername(String username) {
		long startTime = System.currentTimeMillis();
		Assert.notNull(username, "Username cannot be empty!");
		
		User user = userRepository.findByUsername(username);
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "findByUsername", 
                System.currentTimeMillis() - startTime,
                String.format("userName=%s", username));
		return UserDto.fromEntity(user);
	}
}

