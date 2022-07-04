package com.nagaja.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
	@GetMapping("/login")
	public ModelAndView loginForm(ModelAndView mv)
	{
		mv.setViewName("login/login");
		
		return mv;
	}
}