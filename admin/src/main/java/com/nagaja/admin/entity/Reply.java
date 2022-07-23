package com.nagaja.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Setter
@Getter
@ToString
@Alias("Reply")
public class Reply {

    private int replyId;
    private int memId;
    private int boardId;
    private String replyContent;
    private int replyStatus;
    private String replyCreateDate;
    private String replyModifyDate;

}
