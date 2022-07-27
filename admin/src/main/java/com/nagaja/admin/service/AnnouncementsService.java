package com.nagaja.admin.service;

import com.nagaja.admin.dto.AnnouncementsDto;
import com.nagaja.admin.dto.AnnouncementsUpdDto;
import com.nagaja.admin.entity.BoardCategory;

import java.util.List;

public interface AnnouncementsService {

    //TODO 자식 카테고리 설렉트
    List<BoardCategory> selectChildBoard(int boardId);

    //TODO 공지사항 등록
    int insertAnnouncements(AnnouncementsDto announcementsDto);

    //TODO 공지사항 업데이트
    int updateAnnouncements(AnnouncementsUpdDto announcementsUpdDto);

    //TODO 공지사항 상단 업데이트
    int changeAnnouncements(int boardId);

    //TODO 공지사항 삭제
    int deleteAnnouncements(int boardId);

}
