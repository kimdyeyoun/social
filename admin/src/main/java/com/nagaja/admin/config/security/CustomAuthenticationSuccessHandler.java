package com.nagaja.admin.config.security;

import com.nagaja.admin.service.AdminService;
import com.nagaja.admin.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{

	private final LoginService service;

	private String defaultUrl = "/index";
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		service.updateLoginTime(authentication.getName());

		HttpSession session = request.getSession();
		
		session.setAttribute("login", true);
		session.setAttribute("adminLoginId", authentication.getName());
		session.setMaxInactiveInterval(3600 * 24);
		
		response.setStatus(200);
//		response.getWriter().print(defaultUrl);
//		response.getWriter().flush();
		
		response.sendRedirect(request.getContextPath() + defaultUrl);		
	}

	public void setDefaultUrl(String defaultUrl)
	{
		this.defaultUrl = defaultUrl;
	}
}