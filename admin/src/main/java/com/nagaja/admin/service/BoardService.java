package com.nagaja.admin.service;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.BoardCategory;

import java.util.List;

public interface BoardService {

    //TODO 중고마켓 하위 카테고리 설렉트
    List<BoardCategory> boardDetail();

    //TODO 중고마켓 검색
    MarketBoardDto selectMarketBoard(MarketBoardDto marketBoardDto);

    //TODO 중고마켓 디테일 설렉트
    MarketBoardInfoDto selectDetailMarket(int boardId);

    //TODO NEW 표기일 설렉트
    int newSelect();

    //TODO 게시판 검색
    BoardDto selectBoard(BoardDto boardDto);

    //TODO TODO 게시판 글 공개/비공개 설정
    int updateBoard(BoardUpdDto boardUpdDto);

    //TODO 중고마켓 글 공개/비공개 설정
    int updateBoardMarket(BoardMarketUpdDto boardMarketUpdDto);

    //TODO NEW 표기일 변경
    int updNewMarkingDate(int newItemMarkingDate);

}
