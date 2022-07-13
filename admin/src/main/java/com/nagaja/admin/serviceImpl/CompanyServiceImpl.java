package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.*;
import com.nagaja.admin.entity.Company;
import com.nagaja.admin.entity.NationInfo;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.CompanyMapper;
import com.nagaja.admin.service.CompanyService;
import com.nagaja.admin.util.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    //TODO 기업 회원 검색
    @Override
    public CompanyDto selectCompany(CompanyDto companyDto)
    {
        int count = companyMapper.companyCount(companyDto);

        Pagination pagination = MyUtils.Paging(count, companyDto.getPageNum(), companyDto.getLimit());

        List<CompanyInfoDto> companyInfoList = companyMapper.companyList(companyDto, pagination.getOffset(), pagination.getLimit());

        return CompanyDto.builder().companyInfoList(companyInfoList).pagination(pagination).build();
    }

    //TODO 기업 리뷰 검색
    @Override
    public CompanyReviewDto selectReviews(CompanyReviewDto companyReviewDto)
    {
        int count = companyMapper.selectReviewsCount(companyReviewDto.getCompanyId());

        Pagination pagination = MyUtils.Paging(count, companyReviewDto.getPageNum(), companyReviewDto.getLimit());

        List<CompanyReviewInfoDto> list = companyMapper.selectReviewList(companyReviewDto.getCompanyId(), pagination.getOffset(), pagination.getLimit());

        if (list != null)
        {
            for (CompanyReviewInfoDto data : list)
            {
                data.setImages(companyMapper.selectReviewImages(data.getCompanyReviewId()));
            }
        }

        return CompanyReviewDto.builder().reviews(list).pagination(pagination).build();
    }

    //TODO 어드민 검색
    @Override
    public CompanyAdminDto selectCompanyAdmin(CompanyAdminDto companyAdminDto)
    {
        int count = companyMapper.selectCompanyAdminCount(companyAdminDto.getCompanyId());

        Pagination pagination = MyUtils.Paging(count, companyAdminDto.getPageNum(), companyAdminDto.getLimit());

        List<CompanyAdminInfoDto> list = companyMapper.selectCompanyAdminList(companyAdminDto.getCompanyId(), pagination.getOffset(), pagination.getLimit());

        return CompanyAdminDto.builder().adminList(list).pagination(pagination).build();
    }

    //TODO 단골 기업 설렉트
    @Override
    public CompanyDto selectRegulars(RegularInfoDto dto)
    {

        int count = companyMapper.regularsCount(dto);

        List<CompanyInfoDto> lists = new ArrayList<>();

        Pagination pagination = MyUtils.Paging(count, dto.getPageNum(), dto.getLimit());

        List<RegularInfoDto> list = companyMapper.selectCompanyId(dto, pagination.getOffset(), pagination.getLimit());

        if (list != null && list.get(0) != null)
        {
            for (RegularInfoDto data : list)
            {
                lists.add(companyMapper.selectCompanyInfo(data.getCompanyId()));
            }
        }


        return CompanyDto.builder().companyInfoList(lists).pagination(pagination).build();
    }

    //TODO 국가 정보 설렉트
    @Override
    public List<NationInfo> selectNation()
    {
        return companyMapper.selectNation();
    }

    //TODO 기업 상세 설렉트
    @Override
    public CompanyInfoDto detailCompany(int memId)
    {
        CompanyInfoDto company = companyMapper.selectCompany(memId);
        company.setCompanyImages(companyMapper.selectCompanyImages(company.getCompanyId()));
        company.setProducts(companyMapper.selectCompanyProduct(company.getCompanyId()));
        company.setCompanyProductImages(companyMapper.selectCompanyProductImages(company.getCompanyId()));


        return company;
    }

    //TODO 기업 엑셀 다운로드
    @Override
    public void companyExcelDownload(HttpServletResponse response, List<Integer> memId, int whole)
    {

        if (whole != 0)
        {
            //TODO 전체 엑셀 다온로드
            MyUtils.companyExcelDownLoad(response, companyMapper.selectCompanyAll());
        }
        //TODO 선택 엑셀 다운로드
        else
        {
            List<CompanyInfoDto> companyInfoList = new ArrayList<>();

            for (Integer i : memId)
            {
                companyInfoList.add(companyMapper.selectCompany(i));
            }

            MyUtils.companyExcelDownLoad(response, companyInfoList);
        }
    }

    //TODO 공공기업 업데이트
    @Override
    public int changeCompanyAuth(int companyId, int companyPublic)
    {
        return companyMapper.changeCompanyAuth(companyId, companyPublic);
    }

    //TODO 리뷰 업데이트
    @Override
    public int changeReviewStatus(int companyReviewId, int companyReviewStatus)
    {
        if (companyReviewStatus == 1)
        {
            return companyMapper.changeReviewStatus(companyReviewId, 0);
        }
        else
        {
            return companyMapper.changeReviewStatus(companyReviewId, 1);
        }
    }
}
