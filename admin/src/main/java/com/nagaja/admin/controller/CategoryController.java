package com.nagaja.admin.controller;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CategoryUpdateDto;
import com.nagaja.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //TODO 카테고리 디테일 페이지
    @GetMapping("/detailCategory")
    public ModelAndView detailCategory(ModelAndView mv, @RequestParam(value = "boardCategoryId") int boardCategoryId)
    {
        mv.addObject("category", categoryService.detailCategory(boardCategoryId));
        mv.setViewName("/category/detailCategory");

        return mv;
    }

    //TODO 카테고리 리스트 설렉트
    @GetMapping("/selectCategory")
    @ResponseBody
    public BoardCategoryDto selectCategory(@ModelAttribute BoardCategoryDto dto)
    {
        return categoryService.selectCategory(dto);
    }

    //TODO 하위카테고리 검색
    @GetMapping("/selectLowerRankCategory")
    @ResponseBody
    public BoardCategoryDto selectLowerRankCategory(@ModelAttribute BoardCategoryDto dto)
    {
        return categoryService.selectLowerRankCategory(dto);
    }

    //TODO 카테고리 업데이트
    @PutMapping("/updateCategory")
    @ResponseBody
    public int updateCategory(@ModelAttribute CategoryUpdateDto dto)
    {
        return categoryService.updateCategory(dto);
    }

}
