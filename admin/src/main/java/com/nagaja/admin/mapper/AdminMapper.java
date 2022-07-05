package com.nagaja.admin.mapper;//package com.nagaja.admin.mapper;

import com.nagaja.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper
{

    //TODO 어드민 카운트
    int selectAdminCount(@Param("admin") Admin admin);

    //TODO 어드민 리스트 설렉트
    List<Admin> selectAdminList(@Param("admin") Admin admin, @Param("offset") int offset, @Param("limit") int limit);

    //TODO 어드민 상세정보 설렉트
    Admin adminDetail(@Param("adminId") int adminId);

    //TODO 어드민 등록
    int insertAdmin(@Param("admin") Admin admin);

    //TODO 어드민 비밀번호 변경
    void changePassword(@Param("admin") Admin admin);

    //TODO 어드민 델리트
    int deleteAdmin(@Param("adminId") int adminId);

}
