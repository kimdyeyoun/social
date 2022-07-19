package com.nagaja.admin.service;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CategoryInsDto;
import com.nagaja.admin.dto.CategorySequenceDto;
import com.nagaja.admin.dto.CategoryUpdateDto;
import com.nagaja.admin.entity.BoardCategory;

public interface CategoryService {

    //TODO 카테고리 리스트 설렉트
    BoardCategoryDto selectCategory(BoardCategoryDto dto);

    //TODO 하위 카테고리 리스트 설렉트
    BoardCategoryDto selectLowerRankCategory(BoardCategoryDto dto);

    //TODO 카테고리 디테일
    BoardCategory detailCategory(int boardCategoryId);

    //TODO 카테고리 인서트
    int insertCategory(CategoryInsDto category);

    //TODO 서브 카테고리 인서트
    int insertSubCategory(BoardCategory boardCategoryId);

    //TODO 카테고리 업데이트
    int updateCategory(CategoryUpdateDto dto);

    //TODO 우선순위 변경
    int changeCategory(CategorySequenceDto categorySequenceDto);

    //TODO 서브카테고리 삭제
    int deleteCategory(BoardCategory dto, int parentPk);

}
