package com.lighting.oa.login.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lighting.platform.base.entity.User;
import com.lighting.platform.base.entity.User.UserStatu;
import com.lighting.platform.base.web.OnLine;
import com.lighting.platform.base.web.controller.BaseController;
import com.lighting.service.service.IUserService;

@Controller
public class SecurityController extends BaseController
{
	/*** 登录成功跳转地址**/
	@Autowired
	private String loginSuccessUrl;
	
	
	/*** 登录页面 **/
	@Autowired
	private String loginPageUrl;
	
	
	/*** 用户service **/
	@Autowired
	private IUserService userService;
	
	/***
	 * 登录页面
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/login.go")
	public void login(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		response.sendRedirect(request.getContextPath() + loginPageUrl);
	}
	
	
	/***
	 * 验证表单
	 * @param userId
	 * @param password
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verifyToken.go")
	public synchronized void verifyToken(String loginName , String password , HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		User user = userService.getByLoginNameAndPwd(loginName, password);
		
		String errorCode = null;
		
		StringBuilder redirectUrl = new StringBuilder(loginPageUrl);
		
		if(user != null)
		{
			if(UserStatu.ENABLE.equals(user.getUserStatu()))
				errorCode = "1";//帐号被停用
			else
			{
				OnLine.login(user);
				
				redirectUrl = new StringBuilder(loginSuccessUrl);
			}
		}
		else
		{
			errorCode = "0";//用户名密码错误
		}
		
		if(errorCode != null)
			redirectUrl.append("?errorCode"+errorCode);
		
		
		response.sendRedirect(request.getContextPath() + redirectUrl.toString());
	}
	
	
	@RequestMapping("/menus.go")
	public List menus()
	{
		
		return null;
	}
	
	@RequestMapping("/index.go")
	public String index()
	{
		return "/index";
	}
	
}

