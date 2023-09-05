package com.cybage.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cybage.entity.User;
import com.cybage.web.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
