package com.nagaja.admin.service;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.dto.MemberInfoDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MemberService {

    //TODO 유저 검색
    MemberDto selectMember(MemberDto memberDto);

    //TODO 유저 상세조회
    MemberInfoDto detailMember(int memId);

    //TODO 엑셀 다온로드
    void memberExcelDownload(HttpServletResponse response, List<Integer> memId, int whole);

    //TODO 블랙리스트 등록 해제
    int memberBlackList(int memId);

    //TODO 블랙 리스트 탈퇴
    int memberSecession(int memId);
}
