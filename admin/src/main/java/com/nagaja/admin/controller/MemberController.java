package com.nagaja.admin.controller;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    //TODO 유저리스트 페이지
    @GetMapping("/memberList")
    public ModelAndView memberList(ModelAndView mv)
    {
        mv.setViewName("member/memberList");
        return mv;
    }

    //TODO 유저 상세 페이지
    @GetMapping("/detailMember")
    public ModelAndView detailMember(ModelAndView mv, @RequestParam(value = "memId") int memId)
    {
        mv.addObject("member", service.detailMember(memId));
        mv.setViewName("member/detailMember");
        return mv;
    }

    //TODO 유저 검색
    @GetMapping("/selectMember")
    @ResponseBody
    public MemberDto selectMember(@ModelAttribute MemberDto memberDto)
    {
        System.out.println(memberDto);
        return service.selectMember(memberDto);
    }

    //TODO 엑셀 다운로드
    @PostMapping("/memberExcelDownload")
    @ResponseBody
    public void memberExcelDownload(HttpServletResponse response, @RequestParam(value = "memId", required = false) List<Integer> memId, @RequestParam(value = "whole", defaultValue = "0") int whole)
    {
        service.memberExcelDownload(response, memId, whole);
    }

    //TODO 블랙 리스트 등록/해제
    @PutMapping("/memberBlackList")
    @ResponseBody
    public int memberBlackList(@RequestParam(value = "memId") int memId)
    {
        return service.memberBlackList(memId);
    }

    //TODO 블랙 리스트 탈퇴
    @DeleteMapping("/memberSecession")
    @ResponseBody
    public int memberSecession(@RequestParam(value = "memId") int memId)
    {
        return service.memberSecession(memId);
    }

}
