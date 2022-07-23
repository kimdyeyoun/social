package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.BoardImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    //TODO 중고마켓 하위 카테고리
    List<BoardCategory> boardDetail();

    //TODO 중고마켓 카운트
    int marketBoardCount(@Param("market") MarketBoardDto marketBoardDto);

    //TODO 게시판 카운트
    int boardCount(@Param("board") BoardDto boardDto);

    //TODO 게시판 리스트
    List<BoardInfoDto> boardList(@Param("board") BoardDto boardDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 중고마켓 검색
    List<MarketBoardInfoDto> marketBoardList(@Param("market") MarketBoardDto marketBoardDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 중고마켓 보드 설렉트
    MarketBoardInfoDto selectDetailMarket(@Param("boardId") int boardId);

    //TODO 중고마켓 이미지 설렉트
    List<BoardImage> selectBoardImages(@Param("boardId") int boardId);

    //TODO NEW 표기일 설렉트
    int newSelect();

    //TODO 게시판 공개/비공개 설정
    int updateBoard(@Param("board") BoardUpdDto boardUpdDto);

    //TODO 중고마켓 공개/비공개 설정
    int updateBoardMarket(@Param("market") BoardMarketUpdDto boardMarketUpdDto);

    //TODO NEW 표기일 변경
    int updNewMarkingDate(@Param("newItemMarkingDate") int newItemMarkingDate);

}
