package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
@Alias("AnnouncementsDto")
public class AnnouncementsDto {

    private int boardId;
    private int boardCategoryId;
    private String boardTitle;
    private String boardContent;
    private int boardViewCount;
    private int boardStatus;
    private String boardCreateDate;
    private String boardModifyDate;

    private List<MultipartFile> files;
}
