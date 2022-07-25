package com.nagaja.admin.controller;

import com.nagaja.admin.dto.AnnouncementsDto;
import com.nagaja.admin.dto.AnnouncementsUpdDto;
import com.nagaja.admin.service.BoardService;
import com.nagaja.admin.service.AnnouncementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/announcements")
public class AnnouncementsController {

    private final AnnouncementsService announcementsService;
    private final BoardService boardService;

    //TODO 공지사항 리스트 페이지
    @GetMapping("/announcementsList")
    public ModelAndView announcementsList(ModelAndView mv)
    {
        mv.addObject("child", announcementsService.selectChildBoard());
        mv.setViewName("/announcements/announcementsList");
        return mv;
    }

    //TODO 공지사항 디테일 페이지
    @GetMapping("/detailAnnouncements")
    public ModelAndView detailAnnouncements(ModelAndView mv, @RequestParam(value = "boardId") int boardId)
    {
        mv.addObject("announcements", boardService.selectDetailBoard(boardId));
        mv.addObject("child", announcementsService.selectChildBoard());
        mv.setViewName("/announcements/detailAnnouncements");
        return mv;
    }

    //TODO 공지사항 등록 페이지
    @GetMapping("/insAnnouncements")
    public ModelAndView insAnnouncements(ModelAndView mv)
    {
        mv.addObject("child", announcementsService.selectChildBoard());
        mv.setViewName("/announcements/insAnnouncements");
        return mv;
    }

    //TODO 공지사항 등록
    @PostMapping("/insertAnnouncements")
    @ResponseBody
    public int insertAnnouncements(@ModelAttribute AnnouncementsDto announcementsDto)
    {
        return announcementsService.insertAnnouncements(announcementsDto);
    }

    //TODO 공지사항 업데이트
    @PutMapping("/updateAnnouncements")
    @ResponseBody
    public int updateAnnouncements(@ModelAttribute AnnouncementsUpdDto announcementsUpdDto)
    {
        return announcementsService.updateAnnouncements(announcementsUpdDto);
    }

    //TODO 공지사항 상단 업데이트
    @PutMapping("/changeAnnouncements")
    @ResponseBody
    public int changeAnnouncements(@RequestParam(value = "boardId") int boardId)
    {
        return announcementsService.changeAnnouncements(boardId);
    }

    //TODO 공지사항 삭제
    @DeleteMapping("/deleteAnnouncements")
    @ResponseBody
    public int deleteAnnouncements(@RequestParam(value = "boardId") int boardId)
    {
        return announcementsService.deleteAnnouncements(boardId);
    }
}
