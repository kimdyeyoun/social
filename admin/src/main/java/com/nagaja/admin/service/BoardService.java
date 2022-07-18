package com.nagaja.admin.service;

import com.nagaja.admin.dto.BoardMarketUpdDto;
import com.nagaja.admin.dto.MarketBoardDto;
import com.nagaja.admin.dto.MarketBoardInfoDto;
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

    //TODO 중고마켓 글 공개/비공개 설정
    int updateBoardMarket(BoardMarketUpdDto boardMarketUpdDto);

    //TODO NEW 표기일 변경
    int updNewMarkingDate(int newItemMarkingDate);

}