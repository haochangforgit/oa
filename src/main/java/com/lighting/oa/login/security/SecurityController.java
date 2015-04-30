package com.lighting.oa.login.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lighting.platform.base.web.controller.BaseController;

@Controller
public class SecurityController extends BaseController
{
	//@Autowired
	private String loginSuccessUrl;
	
	
	//@Autowired
	private String loginUrl;
	
	/***
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login.go")
	public String login()
	{
		return "/login";
	}
	
	
	/***
	 * 验证表单
	 * @param userId
	 * @param password
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verifyToken.go")
	public void verifyToken(String userId , String password , HttpServletRequest request,HttpServletResponse response)
	{
		
	}
}
