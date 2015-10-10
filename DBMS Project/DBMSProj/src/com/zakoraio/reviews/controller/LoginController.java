package com.zakoraio.reviews.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zakoraio.reviews.controller.view.data.LoginData;
import com.zakoraio.reviews.dbservices.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/checkLogin.htm",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("logindata")LoginData
			 loginData, BindingResult result,HttpServletRequest request) 
	{
		List<String> extractedData = new ArrayList<String>();
		
		extractedData = loginService.extractUserNames(loginData.getUserName(),loginData.getPassWord());
		
		ModelAndView modelAndView = null;
		if(extractedData.size()>=1){
			modelAndView =new  ModelAndView("redirect:profile.htm");
			HttpSession session = request.getSession();
			session.setAttribute("username", loginData.getUserName());
		}
		else {
			modelAndView = new ModelAndView("Login","loginerror","Username or Passwors is incorrect");
		}
		
		return modelAndView;
	}

	
	@RequestMapping(value = "/login.htm")
	public ModelAndView login() 
	{
		return new ModelAndView("Login","command", new LoginData());
	}
	public LoginService getLoginService() 
	{
		return loginService;
	}

	public void setLoginService(LoginService loginservice) 
	{
		this.loginService = loginservice;
	}

}
