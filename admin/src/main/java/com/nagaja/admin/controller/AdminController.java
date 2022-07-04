package com.nagaja.admin.controller;//package com.nagaja.admin.controller;

import com.nagaja.admin.dto.AdminListDto;
import com.nagaja.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//관리자 리스트 페이지
	@GetMapping("adminList")
	public ModelAndView adminListPage(ModelAndView mv)
	{
		mv.setViewName("admin/adminList");
		return mv;
	}

	@GetMapping("selectAdminList")
	@ResponseBody
	public AdminListDto selectAdminList(@RequestParam(value = "PageNum", defaultValue = "1") int PageNum, @RequestParam(value = "limit", defaultValue = "10") int limit)
	{
		AdminListDto adminList = service.selectAdminList(PageNum, limit);
		return adminList;
	}
}
