package com.aru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import com.aru.dto.UserDto;
import com.aru.entity.User;
import com.aru.repo.UserRepo;
import com.aru.request.LoginRequest;
import com.aru.request.RegisterRequest;
@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserRepo urepo;
	@Override
	public UserDto register(RegisterRequest request) {
		
		User alreadyexist=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyexist!=null) {
			throw new RuntimeException("email already exists");
		}
		
		User user=new User();
		user.setName(request.getName());
		user.setPhone(request.getPhone());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user=urepo.save(user);
		
		UserDto dto=new UserDto();
		dto.setUserId(user.getUserId());
		dto.setName(user.getName());
		dto.setPhone(user.getPhone());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setCreatedAt(user.getCreatedAt());
		return dto;
	}
	@Override
	public UserDto login(LoginRequest request) {
		User alreadyexist=urepo.findByEmail(request.getEmail()).orElseThrow(new RuntimeException(""));
		
		if(!alreadyexist.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("user not found");
		}
		return null;
	}

}
