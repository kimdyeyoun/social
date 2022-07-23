package com.nagaja.admin.controller;

import com.nagaja.admin.dto.AuthDto;
import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.service.AuthService;
import com.nagaja.admin.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final CompanyService companyService;

    private final AuthService authService;

    //TODO 나가자 인증 업체 목록
    @GetMapping("/authList")
    public ModelAndView authList(ModelAndView mv)
    {
        mv.addObject("nation", companyService.selectNation());
        mv.setViewName("/auth/authList");
        return mv;
    }

    //TODO 나가자 인증 등록 목록
    @GetMapping("/insAuth")
    public ModelAndView insAuth(ModelAndView mv)
    {
        mv.setViewName("/auth/insAuth");
        return mv;
    }

    //TODO 나가자 인증 업체 검색
    @GetMapping("/selectAuthCompany")
    @ResponseBody
    public CompanyDto selectAuthCompany(@ModelAttribute CompanyDto companyDto)
    {
        return authService.selectAuthCompany(companyDto);
    }

    //TODO 나가자 인증 업체 company_certification 1
    @PutMapping("/updateAuth")
    @ResponseBody
    public int updateAuth(@ModelAttribute AuthDto AuthDto)
    {
        return authService.updateAuth(AuthDto);
    }

    //TODO 나가자 인증 업체 company_certification 0
    @DeleteMapping("/deleteAuth")
    @ResponseBody
    public int deleteAuth(@ModelAttribute AuthDto AuthDto)
    {
        return authService.deleteAuth(AuthDto.getPk());
    }
}
