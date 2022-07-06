package com.nagaja.admin.controller;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    //TODO 유저리스트 페이지
    @GetMapping("/memberList")
    public ModelAndView UserList(ModelAndView mv)
    {
        mv.setViewName("member/memberList");

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
    public void memberExcelDownload(HttpServletResponse response, @RequestParam(value = "memId") List<Integer> memId)
    {
        service.memberExcelDownload(response, memId);
    }

}
