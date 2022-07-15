package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.entity.BoardCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //TODO 카테고리 카운트
    int categoryCount();

    //TODO 카테고리 리스트
    List<BoardCategory> categoryList(@Param("offset") int offset, @Param("limit") int limit);
}
