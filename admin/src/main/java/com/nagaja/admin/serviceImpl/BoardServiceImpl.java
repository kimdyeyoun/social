package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.BoardImage;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.BoardMapper;
import com.nagaja.admin.service.BoardService;
import com.nagaja.admin.util.MyUtils;
import com.nagaja.admin.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    //TODO 중고마켓 하위 카테고리 설렉트
    @Override
    public List<BoardCategory> boardDetail()
    {
        return boardMapper.boardDetail();
    }

    //TODO 중고마켓 검색
    @Override
    public MarketBoardDto selectMarketBoard(MarketBoardDto marketBoardDto)
    {
        int count = boardMapper.marketBoardCount(marketBoardDto);


        Pagination pagination = MyUtils.Paging(count, marketBoardDto.getPageNum(), marketBoardDto.getLimit());

        List<MarketBoardInfoDto> list = boardMapper.marketBoardList(marketBoardDto, pagination.getOffset(), pagination.getLimit());

        return MarketBoardDto.builder().pagination(pagination).boardInfoList(list).build();
    }

    //TODO 중고마켓 디테일 설렉트
    @Override
    public MarketBoardInfoDto selectDetailMarket(int boardId)
    {
        MarketBoardInfoDto info = boardMapper.selectDetailMarket(boardId);
        info.setImages(boardMapper.selectBoardImages(boardId));
        return info;
    }

    //TODO 게시판 상세정보
    @Override
    public BoardInfoDto selectDetailBoard(int boardId)
    {
        BoardInfoDto boardInfoDto = boardMapper.selectDetailBoard(boardId);

        List<BoardImage> images = boardMapper.selectBoardImages(boardId);

        if (images != null && !images.isEmpty())
        {
            boardInfoDto.setImages(images);
        }
        return boardInfoDto;
    }

    //TODO 게시판 검색
    @Override
    public BoardDto selectBoard(BoardDto boardDto)
    {
        int count = boardMapper.boardCount(boardDto);

        Pagination pagination = MyUtils.Paging(count, boardDto.getPageNum(), boardDto.getLimit());

        List<BoardInfoDto> list = boardMapper.boardList(boardDto, pagination.getOffset(), pagination.getLimit());

        return BoardDto.builder().pagination(pagination).boardInfoList(list).build();
    }

    //TODO NEW 표기일 설렉트
    @Override
    public int newSelect()
    {
        return boardMapper.newSelect();
    }

    //TODO 게시판 글 공개/비공개 설정
    @Override
    public int updateBoard(BoardUpdDto boardUpdDto)
    {
        int result = boardMapper.updateBoard(boardUpdDto);

        if (result == 0)
        {
            return Status.ZERO;
        }

        return Status.FIRST;
    }

    //TODO 중고마켓 글 공개/비공개 설정
    @Override
    public int updateBoardMarket(BoardMarketUpdDto boardMarketUpdDto)
    {
        int result = boardMapper.updateBoardMarket(boardMarketUpdDto);

        if (result == 0)
        {
            return Status.ZERO;
        }

        return Status.FIRST;
    }

    //TODO NEW 표기일 변경
    @Override
    public int updNewMarkingDate(int newItemMarkingDate)
    {
        return boardMapper.updNewMarkingDate(newItemMarkingDate);
    }
}
