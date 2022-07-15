package com.nagaja.admin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Alias("CategoryUpdateDto")
public class CategoryUpdateDto {

    private int boardCategoryId;
    private String boardCategoryTitle;
    private String boardCategoryImageName;
    private String boardCategoryImageOrigin;
    private int boardCategoryShow;
    private MultipartFile file;
}
