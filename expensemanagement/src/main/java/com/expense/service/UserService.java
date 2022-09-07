package com.expense.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.expense.entity.User;
import com.expense.entity.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userRegistrationDto);//create user
	User getLoggedInUser();
}
