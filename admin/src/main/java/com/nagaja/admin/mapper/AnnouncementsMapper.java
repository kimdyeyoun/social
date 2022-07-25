package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.AnnouncementsDto;
import com.nagaja.admin.dto.AnnouncementsUpdDto;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.BoardImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnnouncementsMapper {

    //TODO 하위카테고리 설렉트
    List<BoardCategory> selectChildBoard();

    //TODO 공지사항 이미지 설렉트
    BoardImage selectFile(@Param("boardImageId") Integer boardImageId);

    //TODO 상단 공지사항 유무
    int noticeAnnouncementsCount(@Param("boardId") int boardId);

    //TODO 공지사항 등록
    int insertAnnouncements(@Param("announcements") AnnouncementsDto announcementsDto);

    //TODO 공지사항 이미지 등록
    void insertAnnouncementsImage(@Param("announcements") BoardImage boardImage);

    //TODO 공지사항 업데이트
    int updateAnnouncements(@Param("announcements") AnnouncementsUpdDto announcementsUpdDto);

    //TODO 공지사항 상단 업데이트
    int changeAnnouncements(@Param("boardId") int boardId);

    //TODO 공지사항 이미지 델리트
    void deleteFile(@Param("boardImageId") Integer boardImageId);

    //TODO 공지사항 이미지 설렉트 리스트
    List<BoardImage> selectFileList(@Param("boardId") int boardId);

    //TODO 공지사항 삭제
    int deleteAnnouncements(@Param("boardId") int boardId);

}
