package com.nagaja.admin.controller;

import com.nagaja.admin.dto.ChangePointAmountDto;
import com.nagaja.admin.dto.PointDto;
import com.nagaja.admin.dto.PointInsDto;
import com.nagaja.admin.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    //TODO 포인트 수동 지급 페이지
    @GetMapping("/pointManual")
    public ModelAndView pointManual(ModelAndView mv)
    {
        mv.setViewName("/point/pointManual");
        return mv;
    }

    //TODO 포인트 검색
    @GetMapping("/selectPoint")
    @ResponseBody
    public PointDto selectPoint(@ModelAttribute PointDto dto)
    {
        return pointService.selectPoint(dto);
    }

    //TODO 포인트 엑셀 다운로드
    @PostMapping("/pointExcelDownload")
    @ResponseBody
    public void pointExcelDownload(HttpServletResponse response, @RequestParam(value = "pointId", required = false) List<Integer> pointId, @RequestParam(value = "whole", defaultValue = "0") int whole)
    {
        pointService.pointExcelDownload(response, pointId, whole);
    }

    //TODO 포인트 설정 페이지
    @PostMapping("/insertPoint")
    @ResponseBody
    public int insertPoint(@ModelAttribute PointInsDto pointInsDto)
    {
        return pointService.insertPoint(pointInsDto);
    }

    //TODO 포인트 설정 페이지
    @PutMapping("/changePointAmount")
    @ResponseBody
    public int changePointAmount(@ModelAttribute ChangePointAmountDto changePointAmountDto)
    {
        return pointService.changePointAmount(changePointAmountDto.getPoint());
    }


}
