package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.CategoryMapper;
import com.nagaja.admin.service.CategoryService;
import com.nagaja.admin.util.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    //TODO 카테고리 리스트 설렉트
    @Override
    public BoardCategoryDto selectCategory(BoardCategoryDto dto)
    {
        int count = categoryMapper.categoryCount();

        Pagination pagination = MyUtils.Paging(count, dto.getPageNum(), dto.getLimit());

        List<BoardCategory> boardCategoryList = categoryMapper.categoryList(pagination.getOffset(), pagination.getLimit());

        return BoardCategoryDto.builder().boardCategoryList(boardCategoryList).pagination(pagination).build();
    }
}
