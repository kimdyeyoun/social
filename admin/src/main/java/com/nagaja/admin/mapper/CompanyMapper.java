package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {

    //TODO 기업회원 카운트
    int companyCount(@Param("company") CompanyDto companyDto);

    //TODO 기업회원 리스트
    List<CompanyInfoDto> companyList(@Param("company") CompanyDto companyDto, @Param("offset") int offset, @Param("limit") int limit);
}
