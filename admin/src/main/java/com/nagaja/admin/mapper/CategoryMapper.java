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

    //TODO 카테고리 인서트
    int insertCategory(@Param("category") BoardCategory category);

    //TODO 카테고리 업데이트
    int updateCategory(@Param("category") CategoryUpdateDto dto);

    //TODO 서브 카테고리 삭제
    int deleteCategory(@Param("category") BoardCategory dto);

    //TODO 서브카테고리 우선순위 업데이트
    void updateFirstOfAllCategory(@Param("category")BoardCategory dto, @Param("parentPk") int parentPk);
}
