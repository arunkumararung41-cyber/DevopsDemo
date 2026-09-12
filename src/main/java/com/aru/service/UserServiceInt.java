package com.aru.service;

import com.aru.dto.UserDto;
import com.aru.request.LoginRequest;
import com.aru.request.RegisterRequest;

public interface UserServiceInt {

	UserDto register(RegisterRequest request);
	
	UserDto login(LoginRequest request);
}
