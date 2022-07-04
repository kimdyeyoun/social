package com.nagaja.admin.mapper;

import com.nagaja.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper
{
	Admin loadUserByUsername(@Param("adminLoginId") String adminLoginId);
}