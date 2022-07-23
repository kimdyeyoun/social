package com.nagaja.admin.controller;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    //TODO 중고마켓 리스트 페이지
    @GetMapping("/marketBoardList")
    public ModelAndView boardList(ModelAndView mv)
    {
        mv.addObject("newDate", boardService.newSelect());
        mv.addObject("category", boardService.boardDetail());
        mv.setViewName("/board/marketBoardList");
        return mv;
    }

    //TODO 중고마켓 리스트 페이지
    @GetMapping("/detailMarket")
    public ModelAndView detailMarket(ModelAndView mv, @RequestParam(value = "boardId") int boardId)
    {
        mv.addObject("market", boardService.selectDetailMarket(boardId));
        mv.setViewName("/board/detailMarket");
        return mv;
    }

    //TODO 중고마켓 검색
    @GetMapping("/selectMarketBoard")
    @ResponseBody
    public MarketBoardDto selectMarketBoard(@ModelAttribute MarketBoardDto marketBoardDto)
    {
        return boardService.selectMarketBoard(marketBoardDto);
    }

    //TODO 게시판 리스트 조회
    @GetMapping("/selectBoard")
    @ResponseBody
    public BoardDto selectBoard(@ModelAttribute BoardDto boardDto)
    {
        return boardService.selectBoard(boardDto);
    }

    //TODO TODO 게시판 글 공개/비공개 설정
    @PutMapping("/updateBoard")
    @ResponseBody
    public int updateBoard(@ModelAttribute BoardUpdDto boardUpdDto)
    {
        return boardService.updateBoard(boardUpdDto);
    }

    //TODO 중고마켓 공개/비공개 설정
    @PutMapping("/updateBoardMarket")
    @ResponseBody
    public int updateBoardMarket(@ModelAttribute BoardMarketUpdDto boardMarketUpdDto)
    {
        return boardService.updateBoardMarket(boardMarketUpdDto);
    }

    //TODO 새상품 표기일 수정
    @PutMapping("/updNewMarkingDate")
    @ResponseBody
    public int updNewMarkingDate(@RequestParam(value = "newItemMarkingDate") int newItemMarkingDate)
    {
        return boardService.updNewMarkingDate(newItemMarkingDate);
    }

}
