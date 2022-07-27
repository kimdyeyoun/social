package com.nagaja.admin.controller;

import com.nagaja.admin.service.AnnouncementsService;
import com.nagaja.admin.service.FreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/free")
public class FreeController {

    private final FreeService freeService;
    private final AnnouncementsService announcementsService;


    //TODO 자유게시판 리스트
    @GetMapping("/freeList")
    public ModelAndView freeList(ModelAndView mv, @RequestParam(value = "boardId") int boardId)
    {
        mv.addObject("child", announcementsService.selectChildBoard(boardId));
        return mv;
    }
}
