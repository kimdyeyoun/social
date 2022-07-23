package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.AuthDto;
import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {

    //TODO 인증업체 카운트
    int authCompanyCount(@Param("company") CompanyDto companyDto);

    //TODO 인증업체 리스트
    List<CompanyInfoDto> authCompanyList(@Param("company") CompanyDto companyDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 인증업체 company_certification 1
    int updateAuth(@Param("auth") AuthDto authDto);

    //TODO 인증업체 company_certification 0
    int deleteAuth(@Param("companyId") List<Integer> companyId);

    //TODO 기간 만료 카운트
    int selectNowAuth(@Param("now") String now);

    //TODO 기간 만료 company auth 업데이트
    void updateAuthCompany(@Param("now") String now);

}
