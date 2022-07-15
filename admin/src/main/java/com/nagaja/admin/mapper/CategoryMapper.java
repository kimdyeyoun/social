package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.CategoryUpdateDto;
import com.nagaja.admin.entity.BoardCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //TODO 카테고리 카운트
    int categoryCount();

    //TODO 하위 카테고리 카운트
    int lowerRankCategoryCount(@Param("boardCategoryId") int boardCategoryId);

    //TODO 카테고리 리스트
    List<BoardCategory> categoryList(@Param("offset") int offset, @Param("limit") int limit);

    //TODO 하위 카테고리 리스트
    List<BoardCategory> lowerRankCategoryList(@Param("boardCategoryId") int boardCategoryId, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 카테고리 디테일
    BoardCategory detailCategory(@Param("boardCategoryId") int boardCategoryId);

    //TODO 카테고리 업데이트
    int updateCategory(@Param("category") CategoryUpdateDto dto);
}
