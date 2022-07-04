package com.nagaja.admin.service;

import com.nagaja.admin.entity.Admin;

public interface LoginService
{
	Admin loadUserByUsername(String adminLoginId);
}