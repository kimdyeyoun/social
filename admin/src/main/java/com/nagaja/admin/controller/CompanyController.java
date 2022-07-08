package com.nagaja.admin.controller;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    //TODO 기업 회원 리스트 페이지
    @GetMapping("/companyList")
    public ModelAndView companyList(ModelAndView mv)
    {
        mv.addObject("nation", companyService.selectNation());
        mv.setViewName("company/companyList");

        return mv;
    }

    //TODO 기업 회원 상세페이지
    @GetMapping("/detailCompany")
    public ModelAndView detailCompany(ModelAndView mv)
    {
        mv.setViewName("company/detailCompany");

        return mv;
    }

    //TODO 기업 회원 검색
    @GetMapping("/selectCompany")
    @ResponseBody
    public CompanyDto selectCompany(@ModelAttribute CompanyDto companyDto)
    {
        return companyService.selectCompany(companyDto);
    }


}
