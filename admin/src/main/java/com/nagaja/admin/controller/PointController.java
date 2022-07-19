package com.nagaja.admin.controller;

import com.nagaja.admin.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/point")
public class PointController {

    private final PointService pointService;

    //TODO 포인트 리스트 페이지
    @GetMapping("/pointList")
    public ModelAndView pointList(ModelAndView mv)
    {
        mv.setViewName("/point/pointList");
        return mv;
    }

    //TODO 포인트 설정 페이지
    @GetMapping("/pointOptions")
    public ModelAndView pointOptions(ModelAndView mv)
    {
        mv.addObject("point", pointService.pointTypeList());
        mv.setViewName("/point/pointOptions");
        return mv;
    }


}
