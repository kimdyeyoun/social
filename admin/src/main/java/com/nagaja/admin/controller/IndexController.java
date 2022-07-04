package com.nagaja.admin.controller;

import com.nagaja.admin.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class IndexController
{
	private final IndexService indexService;
	@RequestMapping("/")
	public ModelAndView login(ModelAndView mv)
	{
		mv.setViewName("login/login");
		return mv;
	}

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv)
	{
		mv.setViewName("index/index");
		return mv;
	}
}