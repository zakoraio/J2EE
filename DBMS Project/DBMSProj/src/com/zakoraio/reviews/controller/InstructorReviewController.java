package com.zakoraio.reviews.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zakoraio.reviews.controller.view.data.InstructorReviewData;
import com.zakoraio.reviews.dao.InstructorReviewDAO;
import com.zakoraio.reviews.dbservices.CourseOfferingDetailsService;
import com.zakoraio.reviews.dbservices.DepartmentNameService;
import com.zakoraio.reviews.dbservices.InstructorReviewService;
import com.zakoraio.reviews.dbservices.InstructorService;

@Controller
public class InstructorReviewController {
	
	@Autowired
	private DepartmentNameService deptNameService;
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseOfferingDetailsService codService;
	@Autowired
	private InstructorReviewService instructorReviewService;
	@Autowired
	
	@RequestMapping("/reviews.htm")
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
		ModelAndView modelAndView =new  ModelAndView("viewreviews", "reviewData", reviewData);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/getinstructor.htm", method = RequestMethod.GET)
	public @ResponseBody String getInstructor(@RequestParam String deptname) {
		instructorService.setDeptName(deptname);
		List<String> instructorList = instructorService.extractInstructorNames();
		return convertToString(instructorList);
	}

	
	@RequestMapping(value = "/getofferingdetails.htm", method = RequestMethod.GET)
	public @ResponseBody String getCourseOfferingDetails(@RequestParam String instructorId) {
		codService.setInstructorId(instructorId);
		List<String> instructorList = codService.extractDeptNames();
		return convertToString(instructorList);
	}
	
	@RequestMapping(value = "/getinstructorreviews.htm", method = RequestMethod.GET)
	public @ResponseBody String getInstructorreviews(@RequestParam String offeringId) {
		instructorReviewService.setOfferingId(offeringId);
		List<InstructorReviewDAO> instructorReviewData = instructorReviewService.extractInstructorReviewData();
		String jsonData = convertReviewDAOtoJSON(instructorReviewData);
		jsonData+= ":" + getSkillsAverage(instructorReviewData);
 		return jsonData;
	}

	
	private String convertToString(List<String> data){
		String converted="";
		
		for(String s:data){
			converted+=s+":";
		}
	if(converted.length()>0)	
	converted = converted.substring(0,converted.length()-1);
	return converted;
	}
	

	private String convertReviewDAOtoJSON(List<InstructorReviewDAO> instructorReviewData){
		String converted="";	
		for(InstructorReviewDAO ind:instructorReviewData){
				converted += ind.getStudentFname()+" "+ind.getStudentLname() + "|" +
							 ind.getComment() + "|" +
							 ind.getTeachingApt() + "|"  +
							 ind.getCommandSub() + "|" +
							 ind.getInteraction() + "|" + ":";
			}
		if(converted.length()>0)
		converted = converted.substring(0,converted.length()-1);
		return converted;
	}

	private String getSkillsAverage(List<InstructorReviewDAO> instructorReviewData){
		String skillsAvg = "";
		Float teachingAvg = 0.0f;
		Float knowlwdgeAvg = 0.0f;
		Float interactionAvg = 0.0f;
		Float cumulativeAvg =0.0f;
		for(InstructorReviewDAO ind:instructorReviewData){
			teachingAvg += ind.getTeachingApt();
			knowlwdgeAvg += ind.getCommandSub();
			interactionAvg += ind.getInteraction();
		}
		if(instructorReviewData.size()>0){
			teachingAvg = teachingAvg/instructorReviewData.size();
			knowlwdgeAvg = knowlwdgeAvg/instructorReviewData.size();
			interactionAvg = interactionAvg/instructorReviewData.size();
		
		skillsAvg += teachingAvg.toString().substring(0,3)+"|" + 
					 knowlwdgeAvg.toString().substring(0,3)+ "|" + 
					 interactionAvg.toString().substring(0,3);
		
		cumulativeAvg = (teachingAvg+knowlwdgeAvg+interactionAvg)/3.0f;
		skillsAvg += "|" + cumulativeAvg.toString().substring(0,3);
		}
		
		return skillsAvg;
	}
	

	public void setCodService(CourseOfferingDetailsService codService) {
		this.codService = codService;
	}


	public CourseOfferingDetailsService getCodService() {
		return codService;
	}


	public void setInstructorReviewService(InstructorReviewService instructorReviewService) {
		this.instructorReviewService = instructorReviewService;
	}


	public InstructorReviewService getInstructorReviewService() {
		return instructorReviewService;
	}


	public DepartmentNameService getDeptNameService() {
		return deptNameService;
	}


	public void setDeptNameService(DepartmentNameService deptNameService) {
		this.deptNameService = deptNameService;
	}


	public InstructorService getInstructorService() {
		return instructorService;
	}


	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}


}
