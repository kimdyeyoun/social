package com.nagaja.admin.mapper;

import com.nagaja.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper
{
    //TODO 어드민 로그인
	Admin loadAdminByUsername(@Param("adminLoginId") String adminLoginId);

    //TODO 어드민 로그인 타임 업데이트
    void updateLoginTime(@Param("adminLoginId") String adminLoginId);
}