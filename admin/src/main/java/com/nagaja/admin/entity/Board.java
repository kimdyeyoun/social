package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("Board")
public class Board {

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
}
