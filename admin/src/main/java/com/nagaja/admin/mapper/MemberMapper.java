package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.CompanyAllDto;
import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.dto.MemberInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    //TODO 멤버 카운트
    int memberCount(@Param("member") MemberDto memberDto);

    //TODO 멤버 리스트
    List<MemberInfoDto> memberList(@Param("member") MemberDto memberDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 멤버 설렉트
    MemberInfoDto selectMember(@Param("memId") int memId);

    //TODO 멤버 전체 설렉트
    List<MemberInfoDto> selectAllMember();

    //TODO 멤버 블랙리스트 등록 해제
    int memberBlackList(@Param("memId") int memId);

    //TODO 멤버 탈퇴
    int memberSecession(@Param("memId") int memId);

}
