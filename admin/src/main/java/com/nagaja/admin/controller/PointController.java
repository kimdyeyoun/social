package com.nagaja.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/point")
public class PointController {

    //TODO 포인트 리스트 페이지
    @GetMapping("/pointList")
    public ModelAndView pointList(ModelAndView mv)
    {
        mv.setViewName("/point/pointList");

        return mv;
    }
}
