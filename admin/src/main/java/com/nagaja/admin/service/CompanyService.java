package com.nagaja.admin.service;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.entity.NationInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CompanyService {

    //TODO 기업 회원 검색
    CompanyDto selectCompany(CompanyDto companyDto);

    //TODO 국가 정보 설렉트
    List<NationInfo> selectNation();

    //TODO 기업 상세 설렉트
    CompanyInfoDto detailCompany(int memId);

    //TODO 기업 엑셀 다운로드
    void companyExcelDownload(HttpServletResponse response, List<Integer> memId, int whole);

    //TODO 공공기업 업데이트
    int changeCompanyAuth(int companyId, int companyPublic);
}
