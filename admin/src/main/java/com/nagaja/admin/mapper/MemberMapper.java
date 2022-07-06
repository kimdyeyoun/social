package com.nagaja.admin.mapper;

import com.nagaja.admin.dto.MemberDto;
import com.nagaja.admin.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    //TODO 멤버 카운트
    int memberCount(@Param("member") MemberDto memberDto);

    //TODO 멤버 리스트
    List<Member> memberList(@Param("member") MemberDto memberDto, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 멤버 설렉트
    Member selectMember(@Param("memId") int memId);
}
