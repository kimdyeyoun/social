package com.nagaja.admin.controller;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CompanyAdminDto;
import com.nagaja.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    //TODO 카테고리 리스트 페이지
    @GetMapping("/categoryList")
    public ModelAndView categoryList(ModelAndView mv)
    {
        mv.setViewName("/category/categoryList");

        return mv;
    }

    //TODO 기업 관리자 검색
    @GetMapping("/selectCategory")
    @ResponseBody
    public BoardCategoryDto selectCategory(@ModelAttribute BoardCategoryDto dto)
    {
        return categoryService.selectCategory(dto);
    }


}
