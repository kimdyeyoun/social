package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.dto.MemberInfoDto;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.MemberMapper;
import com.nagaja.admin.service.MemberService;
import com.nagaja.admin.util.MyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

        List<MemberInfoDto> memberList = memberMapper.memberList(memberDto, page.getOffset(), page.getLimit());

        return MemberDto.builder().memberInfoList(memberList).pagination(page).build();
    }

    //TODO 유저 상세조회
    @Override
    public MemberInfoDto detailMember(int memId)
    {
        return memberMapper.selectMember(memId);
    }

    //TODO 엑셀 다온로드
    @Override
    public void memberExcelDownload(HttpServletResponse response, List<Integer> memId, int whole)
    {
        if (whole != 0)
        {
            //TODO 전체 엑셀 다온로드
            MyUtils.memberExcelDownLoad(response, memberMapper.selectAllMember());
        }
        //TODO 선택 엑셀 다운로드
        else
        {
            List<MemberInfoDto> memberInfoList = new ArrayList<>();

            for (Integer i : memId)
            {
                memberInfoList.add(memberMapper.selectMember(i));
            }

            MyUtils.memberExcelDownLoad(response, memberInfoList);
        }
    }

    //TODO 블랙리스트 등록 해제
    @Override
    public int memberBlackList(int memId)
    {
        return memberMapper.memberBlackList(memId);
    }

    //TODO 블랙 리스트 탈퇴
    @Override
    public int memberSecession(int memId)
    {
        return memberMapper.memberSecession(memId);
    }
}
