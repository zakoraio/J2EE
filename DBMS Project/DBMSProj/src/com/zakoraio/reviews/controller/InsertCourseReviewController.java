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
import org.springframework.web.servlet.ModelAndView;

import com.zakoraio.reviews.controller.view.data.InstructorReviewData;
import com.zakoraio.reviews.controller.view.data.UserCourseReview;
import com.zakoraio.reviews.dbservices.DepartmentNameService;
import com.zakoraio.reviews.dbservices.InsertCourseReviewService;

@Controller
public class InsertCourseReviewController {
	
	@Autowired
	private DepartmentNameService deptNameService;
	
	@Autowired
	private InsertCourseReviewService insertCourseReviewService;
	
	
	@RequestMapping(value = "/givecoursereviews.htm",method=RequestMethod.POST)
	public String getDeptNames(@ModelAttribute("reviewDataCourse")UserCourseReview
			 userCourseReview, BindingResult result,HttpServletRequest request) {

		String userName = (String) request.getSession().getAttribute("username");
		insertCourseReviewService.insertCourseReviewData(userName, userCourseReview.getComment(), 
				Integer.parseInt(userCourseReview.getNoOfQuizes()), Integer.parseInt(userCourseReview.getNoOfExams()),
				Integer.parseInt(userCourseReview.getNoOfProjects()), 
				Integer.parseInt(userCourseReview.getNoOfAssignements()),
				Integer.parseInt(userCourseReview.getOfferingid()));
		return "redirect:profile.htm";
	}
	
	@RequestMapping("/reviewscourse.htm")
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
		ModelAndView modelAndView =new  ModelAndView("givecoursereviews", "reviewData", reviewData);
		modelAndView.addObject("command", new UserCourseReview());
		return modelAndView;
	}
		
	
	public DepartmentNameService getDeptNameService() {
		return deptNameService;
	}


	public void setDeptNameService(DepartmentNameService deptNameService) {
		this.deptNameService = deptNameService;
	}

	public void setInsertCourseReviewService(InsertCourseReviewService insertCourseReviewService) {
		this.insertCourseReviewService = insertCourseReviewService;
	}

	public InsertCourseReviewService getInsertCourseReviewService() {
		return insertCourseReviewService;
	}


}
