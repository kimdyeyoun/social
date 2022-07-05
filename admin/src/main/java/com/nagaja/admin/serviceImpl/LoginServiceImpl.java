package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.entity.Admin;
import com.nagaja.admin.mapper.LoginMapper;
import com.nagaja.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Admin loadAdminByUsername(String adminLoginId)
	{
		return loginMapper.loadAdminByUsername(adminLoginId);
	}

	@Override
	public void updateLoginTime(String adminLoginId)
	{
		loginMapper.updateLoginTime(adminLoginId);
	}
}