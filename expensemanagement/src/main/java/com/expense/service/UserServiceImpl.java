package com.expense.service;



import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.expense.entity.User;
import com.expense.entity.UserRegistrationDto;
import com.expense.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User newUser = new User(userRegistrationDto.getFirstname(),userRegistrationDto.getLastname(),
				userRegistrationDto.getEmail(),passwordEncoder.encode(userRegistrationDto.getPassword()),timestamp,timestamp);
		return userRepository.save(newUser);
		}
	//used to verify the user
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());		
	}
	//user to get the user id inorder to find the expenses of certain users
	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		if(email == null) {
			throw new UsernameNotFoundException("Invalid username");
		}
		return userRepository.findByEmail(email);
	}

}
