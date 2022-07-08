package com.nagaja.admin.service;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.entity.NationInfo;

public interface CompanyService {

    //TODO 기업 회원 검색
    CompanyDto selectCompany(CompanyDto companyDto);

    //TODO 국가 정보 설렉트
    NationInfo selectNation();
}
