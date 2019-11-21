package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.LoginUser;
import com.axonactive.devdayapp.dto.RegisterUser;

public interface LoginService {
	
	void register(RegisterUser registerUser);

	LoginUser login(String username, String password);

}
