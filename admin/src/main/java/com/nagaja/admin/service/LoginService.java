package com.nagaja.admin.service;

import com.nagaja.admin.entity.Admin;

public interface LoginService
{
	//TODO 어드민 로그인 갱신
	void updateLoginTime(String adminLoginId);

	//TODO 어드민 로그인
	Admin loadAdminByUsername(String adminLoginId);
}