package com.nagaja.admin.controller;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.dto.RegularInfoDto;
import com.nagaja.admin.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public ModelAndView detailCompany(ModelAndView mv, @RequestParam(value = "memId") int memId)
    {
        mv.addObject("company", companyService.detailCompany(memId));
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

    //TODO 단골기업 검색
    @GetMapping("/selectRegulars")
    @ResponseBody
    public CompanyDto selectRegulars(@ModelAttribute RegularInfoDto dto)
    {
        return companyService.selectRegulars(dto);
    }

    //TODO 기업 엑셀 다운로드
    @PostMapping("/companyExcelDownload")
    @ResponseBody
    public void companyExcelDownload(HttpServletResponse response, @RequestParam(value = "memId", required = false) List<Integer> memId, @RequestParam(value = "whole", defaultValue = "0") int whole)
    {
        companyService.companyExcelDownload(response, memId, whole);
    }

    //TODO 공공기업 인증 업데이트
    @PutMapping("/changeCompanyAuth")
    @ResponseBody
    public int changeCompanyAuth(@ModelAttribute CompanyInfoDto dto)
    {
        return companyService.changeCompanyAuth(dto.getCompanyId(), dto.getCompanyPublic());
    }

}
