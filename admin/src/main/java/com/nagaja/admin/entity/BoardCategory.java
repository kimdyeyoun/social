package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("BoardCategory")
public class BoardCategory {

    private int boardCategoryId;
    private String boardCategoryTitle;
    private int boardSequence;
    private int boardCategoryShow;
    private int boardCategoryParent;
    private int boardCategoryType;
    private String boardCategoryImageName;
    private String boardCategoryImageOrigin;
    private String boardCategoryCreateDate;
    private String boardCategoryModifyDate;

}
