package com.lighting.oa.login.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	
	@Autowired
	private IUserService userService;
	
	/***
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login.go")
	public String login()
	{
		return loginPageUrl;
	}
	
	
	/***
	 * 验证表单
	 * @param userId
	 * @param password
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verifyToken.go")
	public synchronized String verifyToken(String loginName , String password , ModelMap modelMap)
	{
		User user = userService.getByLoginNameAndPwd(loginName, password);
		
		String errorCode = null;
		
		String redirectUrl = "";
		
		if(user != null)
		{
			if(UserStatu.ENABLE.equals(user.getUserStatu()))
				errorCode = "2";//帐号被停用
			else
			{
				OnLine.login(user);
				
				redirectUrl = loginSuccessUrl;
			}
		}
		else
		{
			errorCode = "1";//用户名密码错误
			
			redirectUrl = login();
		}
		
		if(errorCode != null)
		{
			modelMap.put("errorCode", errorCode);
			
			modelMap.put("loginName", loginName);
			modelMap.put("password", password);
			
		}
		
		return redirectUrl;
	}
	
	
	@RequestMapping("/menus.go")
	public List menus()
	{
		
		return null;
	}
}

