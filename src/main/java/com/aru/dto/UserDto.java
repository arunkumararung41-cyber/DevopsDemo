package com.aru.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class UserDto {
	
    private Integer userId;
    
    private String name;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private LocalDate createdAt;
	
}
