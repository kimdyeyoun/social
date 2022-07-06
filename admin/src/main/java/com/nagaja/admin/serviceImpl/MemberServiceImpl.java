package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.entity.Member;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.MemberMapper;
import com.nagaja.admin.service.MemberService;
import com.nagaja.admin.util.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    //TODO 유저 검색
    @Override
    public MemberDto selectMember(MemberDto memberDto)
    {
        int count = memberMapper.memberCount(memberDto);

        Pagination page = MyUtils.Paging(count, memberDto.getPageNum(), memberDto.getLimit());

        List<Member> memberList = memberMapper.memberList(memberDto, page.getOffset(), page.getLimit());

        return MemberDto.builder().pagination(page).memberList(memberList).build();
    }

    //TODO 엑셀 다온로드
    @Override
    public void memberExcelDownload(HttpServletResponse response, List<Integer> memId)
    {
        List<Member> memberList = new ArrayList<>();
        for (Integer i : memId)
        {
            memberList.add(memberMapper.selectMember(i));
        }

        MyUtils.letExcelDownLoad(response, memberList);
    }
}
