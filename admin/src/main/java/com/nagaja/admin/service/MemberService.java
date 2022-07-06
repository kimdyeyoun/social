package com.nagaja.admin.service;

import com.nagaja.admin.dto.MemberDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MemberService {

    //TODO 유저 검색
    MemberDto selectMember(MemberDto memberDto);

    //TODO 엑셀 다온로드
    void memberExcelDownload(HttpServletResponse response, List<Integer> memId);
}
