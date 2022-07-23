package com.nagaja.admin.service;

import com.nagaja.admin.dto.AuthDto;
import com.nagaja.admin.dto.CompanyDto;

import java.util.List;

public interface AuthService {

    //TODO 인증업체 검색
    CompanyDto selectAuthCompany(CompanyDto companyDto);

    //TODO 인증업체 업데이트
    int updateAuth(AuthDto authDto);

    //TODO 기간만료 인증업체 company_certification 1
    int updateAuthCompany(String now);

    //TODO 기간만료 company_certification 0
    int deleteAuth(List<Integer> pk);
}
