package com.axonactive.devdayapp.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.axonactive.devdayapp.dto.LoginUser;
import com.axonactive.devdayapp.dto.RegisterUser;
import com.axonactive.devdayapp.service.LoginService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class LoginResource {
	
	private static final Logger log = LogManager.getLogger(LoginResource.class);
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/register")
	public void registration(@RequestBody RegisterUser registerUser) {
		log.info("POST request to register user. Username: {}", registerUser.getUsername());
		
		try {
			loginService.register(registerUser);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot register user. Exception: " + e.getMessage());
		}
	}

	@GetMapping("/login")
	public LoginUser login(@RequestParam String username, @RequestParam String password) {
		log.info("GET request to login. Username: {}", username);
		
		try {
			return loginService.login(username, password);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User failed to login. Exception: " + e.getMessage());
		}
	}
}
