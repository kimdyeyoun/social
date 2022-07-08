package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.CompanyMapper;
import com.nagaja.admin.service.CompanyService;
import com.nagaja.admin.util.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        System.out.println(count);
        Pagination pagination = MyUtils.Paging(count, companyDto.getPageNum(), companyDto.getLimit());

        List<CompanyInfoDto> companyInfoList = companyMapper.companyList(companyDto, pagination.getOffset(), pagination.getLimit());

        return CompanyDto.builder().companyInfoList(companyInfoList).pagination(pagination).build();
    }
}
