package com.nagaja.admin.dto;

import com.nagaja.admin.entity.BoardImage;
import com.nagaja.admin.entity.Reply;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("BoardInfoDto")
public class BoardInfoDto {

    private int boardId;
    private int memId;
    private int boardCategoryId;
    private int boardCategoryParent;
    private String boardTitle;
    private String boardContent;
    private int boardViewCount;
    private int boardStatus;
    private String boardCreateDate;
    private String boardModifyDate;

    private List<BoardImage> images;
    //댓글글
    List<Reply> replyList;

    //TODO 댓글 갯수
    private int replyCount;
    //TODO 게시판 조회수
    private int boardCount;
    //TODO 상단 고정 체크
    private int noticeCount;

}
