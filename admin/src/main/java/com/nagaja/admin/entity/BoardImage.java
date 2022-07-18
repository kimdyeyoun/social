package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("BoardImage")
public class BoardImage {

    private int boardImageId;
    private int boardId;
    private String boardImageOrigin;
    private String boardImageName;

}
