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
	@Autowired
	private String loginSuccessUrl;
	
	
	@Autowired
	private String loginUrl;
	
	
	@RequestMapping("/verifyToken")
	public void verifyToken(String userId , String password , HttpServletRequest request,HttpServletResponse response)
	{
		
	}
}
