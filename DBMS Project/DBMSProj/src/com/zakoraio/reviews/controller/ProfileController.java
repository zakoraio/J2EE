package com.zakoraio.reviews.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zakoraio.reviews.dao.ProfileDAO;
import com.zakoraio.reviews.dbservices.ProfileService;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping("/profile.htm")
	public ModelAndView helloWorld(HttpServletRequest request) {
		
		String userName = (String) request.getSession().getAttribute("username");
		ProfileDAO profileDao = profileService.extractStudentDetails(userName);
		
		
		ModelAndView modelAndView =new  ModelAndView("profile", "coursestaken", profileDao.getCourseDAO());
		modelAndView.addObject("studentdetails", profileDao.getStudentBasicDAO());
		return modelAndView;
		
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

}
