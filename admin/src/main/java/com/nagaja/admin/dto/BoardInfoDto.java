package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

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

    private int replyId;
    private String replyContent;
    private int replyStatus;
    private String replyCreateDate;
    private String replyModifyDate;

    //TODO 댓글 갯수
    private int replyCount;
    //TODO 게시판 조회수
    private int boardCount;

}
