package com.nagaja.admin.controller;

import com.nagaja.admin.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    //TODO 현지 뉴스 리스트 페이지
    @GetMapping("/newsList")
    public ModelAndView newsList(ModelAndView mv)
    {
        mv.setViewName("/news/newsList");
        return mv;
    }


}
