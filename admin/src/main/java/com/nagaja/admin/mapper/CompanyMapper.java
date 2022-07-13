package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {

    //TODO 기업회원 카운트
    int companyCount(@Param("company") CompanyDto companyDto);

    //TODO 단골 기업 카운트
    int regularsCount(@Param("regular") RegularInfoDto regular);

    //TODO 단골 리스트 컴퍼니 pk 설렉트
    List<RegularInfoDto> selectCompanyId(@Param("regular") RegularInfoDto regular, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 기업 설렉트
    CompanyInfoDto selectCompanyInfo(@Param("companyId") int companyId);

    //TODO 기업회원 리스트
    List<CompanyInfoDto> companyList(@Param("company") CompanyDto companyDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 기업회원 ALL 설렉트
    List<CompanyInfoDto> selectCompanyAll();

    //TODO 기업회원 설렉트
    CompanyInfoDto selectCompany(@Param("memId") Integer memId);

    //TODO 기업회원 파일 설렉트
    List<CompanyImage> selectCompanyImages(@Param("companyId") int companyId);

    //TODO 기업회원 설렉트
    List<CompanyProduct> selectCompanyProduct(@Param("companyId") int companyId);

    //TODO 기업 리뷰 리스트 설렉트
    List<CompanyReviewInfoDto> selectReviewList(@Param("companyId") int companyId, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 기업어드민 카운트
    int selectCompanyAdminCount(@Param("companyId") int companyId);

    //TODO 기업리스트 설렉트
    List<CompanyAdminInfoDto> selectCompanyAdminList(@Param("companyId") int companyId, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 기업 리뷰 카운트
    int selectReviewsCount(@Param("companyId") int companyId);

    //TODO 기업상품 파일 설렉트
    List<CompanyProductImage> selectCompanyProductImages(@Param("companyId") int companyId);

    //TODO 기업리뷰 파일 설렉트
    List<CompanyReviewImage> selectReviewImages(@Param("companyReviewId") int companyReviewId);

    //TODO 전체 국가 설렉트
    List<NationInfo> selectNation();

    //TODO 공공기업 업데이트
    int changeCompanyAuth(@Param("companyId") int companyId, @Param("companyPublic") int companyPublic);

    //TODO 리뷰 업데이트
    int changeReviewStatus(@Param("companyReviewId") int companyReviewId, @Param("companyReviewStatus") int companyReviewStatus);

}
