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
@Alias("CategoryInsDto")
public class CategoryInsDto {

    private int boardCategoryId;
    private String boardCategoryTitle;
    private int boardSequence;
    private int boardCategoryShow;
    private int boardCategoryParent;
    private int boardCategoryType;
    private int boardCategoryStatus;
    private String boardCategoryImageName;
    private String boardCategoryImageOrigin;
    private String boardCategoryCreateDate;
    private String boardCategoryModifyDate;

    private MultipartFile file;
    private List<String> subCategoryTitle;
}
