package com.nagaja.admin.controller;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.CompanyReturn;
import com.nagaja.admin.entity.CompanyReview;
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

    //TODO 기업신청 회원 리스트 페이지
    @GetMapping("/insCompanyList")
    public ModelAndView detailCompany(ModelAndView mv)
    {
        mv.addObject("nation", companyService.selectNation());
        mv.setViewName("company/insCompanyList");
        return mv;
    }

    //TODO 기업신청 회원 상세페이지
    @GetMapping("/detailInsCompany")
    public ModelAndView detailInsCompany(ModelAndView mv, @RequestParam(value = "memId") int memId)
    {
        mv.addObject("company", companyService.detailCompany(memId));
        mv.setViewName("company/detailInsCompany");
        return mv;
    }

    //TODO 기업 회원 페이지
    @GetMapping("/selectInsCompany")
    @ResponseBody
    public CompanyDto selectInsCompany(@ModelAttribute CompanyDto companyDto, @RequestParam(value = "companyStatus",defaultValue = "0") int companyStatus)
    {
        return companyService.selectInsCompany(companyDto, companyStatus);
    }

    //TODO 기업신청 회원 검색
    @GetMapping("/selectCompany")
    @ResponseBody
    public CompanyDto selectCompany(@ModelAttribute CompanyDto companyDto)
    {
        return companyService.selectCompany(companyDto);
    }

    //TODO 유저 전체검색
    @GetMapping("/selectCompanyAll")
    @ResponseBody
    public CompanyAllDto selectCompanyAll(@ModelAttribute CompanyAllDto companyAllDto)
    {
        return companyService.selectCompanyAll(companyAllDto);
    }

    //TODO 기업 리뷰 검색
    @GetMapping("/selectReviews")
    @ResponseBody
    public CompanyReviewDto selectReviews(@ModelAttribute CompanyReviewDto companyReviewDto)
    {
        return companyService.selectReviews(companyReviewDto);
    }

    //TODO 단골기업 검색
    @GetMapping("/selectRegulars")
    @ResponseBody
    public CompanyDto selectRegulars(@ModelAttribute RegularInfoDto dto)
    {
        return companyService.selectRegulars(dto);
    }

    //TODO 기업 관리자 검색
    @GetMapping("/selectCompanyAdmin")
    @ResponseBody
    public CompanyAdminDto selectCompanyAdmin(@ModelAttribute CompanyAdminDto dto)
    {
        return companyService.selectCompanyAdmin(dto);
    }

    //TODO 기업 엑셀 다운로드
    @PostMapping("/companyExcelDownload")
    @ResponseBody
    public void companyExcelDownload(HttpServletResponse response, @RequestParam(value = "memId", required = false) List<Integer> memId, @RequestParam(value = "whole", defaultValue = "0") int whole)
    {
        companyService.companyExcelDownload(response, memId, whole);
    }

    //TODO 공공기업 인증 업데이트/및 기업 승인인
   @PutMapping("/changeCompanyAuth")
    @ResponseBody
    public int changeCompanyAuth(@ModelAttribute CompanyInfoDto dto,@RequestParam(value = "status", defaultValue = "0") int status)
    {
        return companyService.changeCompanyAuth(dto.getCompanyId(), dto.getCompanyPublic(), status);
    }

    //TODO 리뷰 업데이트
    @PutMapping("/changeReviewStatus")
    @ResponseBody
    public int changeReviewStatus(@ModelAttribute CompanyReview review)
    {
        return companyService.changeReviewStatus(review.getCompanyReviewId(), review.getCompanyReviewStatus());
    }

    //TODO 기업회원 신청 업데이트
    @PutMapping("/changeInsCompanyStatus")
    @ResponseBody
    public int changeInsCompanyStatus(@ModelAttribute ChangeCompanyStatusDto dto)
    {
        return companyService.changeInsCompanyStatus(dto.getMemId());
    }

    //TODO 기업회원 반려 업데이트
    @PutMapping("/returnCompany")
    @ResponseBody
    public int returnCompany(@ModelAttribute CompanyReturn dto)
    {
        return companyService.returnCompany(dto);
    }
}
