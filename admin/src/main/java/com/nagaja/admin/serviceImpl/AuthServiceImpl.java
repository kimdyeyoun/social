package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.AuthDto;
import com.nagaja.admin.dto.CompanyDto;
import com.nagaja.admin.dto.CompanyInfoDto;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.AuthMapper;
import com.nagaja.admin.service.AuthService;
import com.nagaja.admin.util.MyUtils;
import com.nagaja.admin.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;

    //TODO 인증업체 검색
    @Override
    public CompanyDto selectAuthCompany(CompanyDto companyDto)
    {
        int count = authMapper.authCompanyCount(companyDto);

        Pagination pagination = MyUtils.Paging(count, companyDto.getPageNum(), companyDto.getLimit());

        List<CompanyInfoDto> list = authMapper.authCompanyList(companyDto, pagination.getOffset(), pagination.getLimit());

        return CompanyDto.builder().pagination(pagination).companyInfoList(list).build();
    }

    //TODO 인증업체 company_certification 1
    @Override
    public int updateAuth(AuthDto authDto)
    {
        int result = authMapper.updateAuth(authDto);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 인증업체 company_certification 0
    @Override
    public int deleteAuth(List<Integer> pk)
    {
        int result = authMapper.deleteAuth(pk);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 기간만료 인증업체 업데이트
    @Override
    public int updateAuthCompany(String now)
    {
        int count = authMapper.selectNowAuth(now);

        if (count == 0)
        {
            return Status.ZERO;
        }
        authMapper.updateAuthCompany(now);
        return count;
    }
}
