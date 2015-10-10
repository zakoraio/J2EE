package com.zakoraio.reviews.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zakoraio.reviews.controller.view.data.InstructorReviewData;
import com.zakoraio.reviews.controller.view.data.UserInstructorReview;
import com.zakoraio.reviews.dbservices.DepartmentNameService;
import com.zakoraio.reviews.dbservices.InsertInstructorReviewService;

@Controller
@SessionAttributes
public class InsertInstructorReviewController {
	
	@Autowired
	private DepartmentNameService deptNameService;
	
	@Autowired
	private InsertInstructorReviewService insertInstructorReviewService;
	
	
	@RequestMapping(value = "/giveinstructorreviews.htm",method=RequestMethod.POST)
	public String getDeptNames(@ModelAttribute("reviewData")UserInstructorReview
			 userInstructorReview, BindingResult result,HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("username");
		insertInstructorReviewService.insertInstructorReviewData(userName, userInstructorReview.getComment(), 
				Integer.parseInt(userInstructorReview.getTeaching()), Integer.parseInt(userInstructorReview.getKnowledge()),
				Integer.parseInt(userInstructorReview.getInteraction()), 
				Integer.parseInt(userInstructorReview.getOfferingId()));
		return "redirect:profile.htm";
	}
	
	@RequestMapping("/reviewsinstructor.htm")
	public ModelAndView getDeptNames() {

		List<String> deptNames = deptNameService.extractDeptNames();
		Map<String,String> deptNamesMap = new HashMap<String,String>();
		InstructorReviewData reviewData = new InstructorReviewData();
		Integer no = 0;
		for(String s:deptNames){
			deptNamesMap.put("dept"+no, s);
			no++;
		}
		
		reviewData.setDeptNames(deptNamesMap);
		ModelAndView modelAndView =new  ModelAndView("giveinstructorreviews", "reviewData", reviewData);
		modelAndView.addObject("command", new UserInstructorReview());
		return modelAndView;
	}
		
	
	public DepartmentNameService getDeptNameService() {
		return deptNameService;
	}


	public void setDeptNameService(DepartmentNameService deptNameService) {
		this.deptNameService = deptNameService;
	}

	public void setInsertInstructorReviewService(
			InsertInstructorReviewService insertInstructorReviewService) {
		this.insertInstructorReviewService = insertInstructorReviewService;
	}

	public InsertInstructorReviewService getInsertInstructorReviewService() {
		return insertInstructorReviewService;
	}


}
