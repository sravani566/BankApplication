package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Login;
import com.bankapp.model.service.UserService;

@Controller
public class LoginController {

	private UserService userService;
	
	@Autowired
	public LoginController(UserService userService)
	{
		this.userService=userService;
	}
	
	
	@GetMapping("login")
	public String LoginGet(ModelAndView mv) {
		mv.addObject("login", new Login());
		return "login";
	}
	
	@PostMapping("login")
	public String LoginPost(HttpServletRequest req,HttpServletResponse res) {
		return null;
	}
	
}
