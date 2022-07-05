package com.nagaja.admin.controller;//package com.nagaja.admin.controller;

import com.nagaja.admin.dto.AdminListDto;
import com.nagaja.admin.dto.PasswordDto;
import com.nagaja.admin.entity.Admin;
import com.nagaja.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//TODO 관리자 리스트 페이지
	@GetMapping("/adminList")
	public ModelAndView adminListPage(ModelAndView mv)
	{
		mv.setViewName("admin/adminList");
		return mv;
	}

	//TODO 관리자 수정 페이지
	@GetMapping("/adminUpd")
	public ModelAndView adminUpdPage(ModelAndView mv, Authentication auth, @RequestParam("adminId") int adminId)
	{
		Admin admin = (Admin) auth.getPrincipal();

		//TODO 권한 마스터 OR 자기 정보
		if (admin.getAdminType().equals("master") || admin.getAdminId() == adminId)
		{
			mv.addObject("admin", service.adminDetail(adminId));
			mv.setViewName("admin/adminUpd");
			return mv;
		}

		mv.setViewName("admin/adminList");
		return mv;
	}

	//TODO 관리자 리스트 페이지
	@GetMapping("/adminIns")
	public ModelAndView InsertAdmin(ModelAndView mv)
	{
		mv.setViewName("admin/adminIns");
		return mv;
	}

	//TODO 관리자 검색
	@GetMapping("/selectAdminList")
	@ResponseBody
	public AdminListDto selectAdminList(@ModelAttribute Admin admin, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int limit)
	{
		AdminListDto adminList = service.selectAdminList(admin, pageNum, limit);
		return adminList;
	}

	//TODO 관리자 등록
	@PostMapping("/insertAdmin")
	@ResponseBody
	public int insertAdmin(@ModelAttribute Admin admin)
	{
		return service.insertAdmin(admin);
	}

	//TODO 관리자 패스워드 변경
	@PutMapping("/changePassWord")
	@ResponseBody
	public int changePassWord(PasswordDto password, Authentication auth)
	{
		return service.changePassWord(password, auth);
	}

	//TODO 관리자 패스워드 변경
	@DeleteMapping("/deleteAdmin")
	@ResponseBody
	public int deleteAdmin(@RequestParam(value = "adminId") int adminId)
	{
		return service.deleteAdmin(adminId);
	}


}
