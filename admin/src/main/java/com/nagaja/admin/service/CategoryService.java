package com.nagaja.admin.service;

import com.nagaja.admin.dto.BoardCategoryDto;

public interface CategoryService {

    //TODO 카테고리 리스트 설렉트
    BoardCategoryDto selectCategory(BoardCategoryDto dto);
}
