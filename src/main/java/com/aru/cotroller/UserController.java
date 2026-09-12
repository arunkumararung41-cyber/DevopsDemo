package com.aru.cotroller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aru.dto.UserDto;
import com.aru.request.RegisterRequest;
import com.aru.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl uservice;
    @PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
    	UserDto dto=uservice.register(request);
    	return ResponseEntity.ok(dto);
    }
}
