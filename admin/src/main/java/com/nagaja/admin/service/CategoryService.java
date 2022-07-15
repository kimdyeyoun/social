package com.nagaja.admin.service;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CategoryUpdateDto;
import com.nagaja.admin.entity.BoardCategory;

public interface CategoryService {

    //TODO 카테고리 리스트 설렉트
    BoardCategoryDto selectCategory(BoardCategoryDto dto);

    //TODO 하위 카테고리 리스트 설렉트
    BoardCategoryDto selectLowerRankCategory(BoardCategoryDto dto);

    //TODO 카테고리 디테일
    BoardCategory detailCategory(int boardCategoryId);

    //TODO 카테고리 업데이트
    int updateCategory(CategoryUpdateDto dto);
}
