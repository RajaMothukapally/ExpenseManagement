package com.expense.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expense.entity.User;
import com.expense.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	//used to display the user login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
