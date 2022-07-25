package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@ToString
@Alias("AnnouncementsUpdDto")
public class AnnouncementsUpdDto {

    private int boardId;
    private int boardCategoryId;
    private String boardTitle;
    private String boardContent;
    private int boardStatus;

    private List<MultipartFile> files;
    private List<Integer> boardImageId;
}
