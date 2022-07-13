package com.nagaja.admin.service;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.NationInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CompanyService {

    //TODO 기업 회원 검색
    CompanyDto selectCompany(CompanyDto companyDto);

    //TODO 기업 리뷰 검색
    CompanyReviewDto selectReviews(CompanyReviewDto companyReviewDto);

    //TODO 어드민 검색
    CompanyAdminDto selectCompanyAdmin(CompanyAdminDto dto);

    //TODO 국가 정보 설렉트
    List<NationInfo> selectNation();

    //TODO 기업 상세 설렉트
    CompanyInfoDto detailCompany(int memId);

    //TODO 단골 기업 설렉트
    CompanyDto selectRegulars(RegularInfoDto dto);

    //TODO 기업 엑셀 다운로드
    void companyExcelDownload(HttpServletResponse response, List<Integer> memId, int whole);

    //TODO 공공기업 업데이트
    int changeCompanyAuth(int companyId, int companyPublic);

    //TODO 리뷰 업데이트
    int changeReviewStatus(int companyReviewId, int companyReviewStatus);

}
