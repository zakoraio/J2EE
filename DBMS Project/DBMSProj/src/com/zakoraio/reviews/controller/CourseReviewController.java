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
import com.zakoraio.reviews.dao.CourseReviewDAO;
import com.zakoraio.reviews.dbservices.CourseReviewCourseNameService;
import com.zakoraio.reviews.dbservices.CourseReviewInstructorService;
import com.zakoraio.reviews.dbservices.CourseReviewService;
import com.zakoraio.reviews.dbservices.DepartmentNameService;

@Controller
public class CourseReviewController {
	
	@Autowired
	private DepartmentNameService deptNameService;
	@Autowired
	private CourseReviewCourseNameService coursereviewcourseNameService;
	@Autowired
	private CourseReviewInstructorService coursereviewinstructorService;
	@Autowired
	private CourseReviewService coursereviewService;
	@Autowired
	
	@RequestMapping("/coursereviews.htm")
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
		ModelAndView modelAndView =new  ModelAndView("coursereviews", "reviewData", reviewData);
		return modelAndView;
	}
	


	@RequestMapping(value = "/getcourse.htm", method = RequestMethod.GET)
	public @ResponseBody String getCourseDetails(@RequestParam String deptname) 
	{
		coursereviewcourseNameService.setdeptName(deptname);
		List<String> courseList = coursereviewcourseNameService.extractCourseNames();
		return convertToString(courseList);
	}
	
	@RequestMapping(value = "/getinstructoryear.htm", method = RequestMethod.GET)
	public @ResponseBody String getInstructorYearDetails(@RequestParam String courseId) 
	{
		coursereviewinstructorService.setcourseID(courseId);
		List<String> instructoryearofferingidList = coursereviewinstructorService.extractInstructorNames();
		String instructors = "";
		if(instructoryearofferingidList.size()>1)
		{
			instructors = convertToString(instructoryearofferingidList);
		}
		else{
			instructors = instructoryearofferingidList.get(0)+":";
		}
		return instructors;
	}
	
	@RequestMapping(value = "/getcoursereviews.htm", method = RequestMethod.GET)
	public @ResponseBody String getCoursereviews(@RequestParam int offeringId) 
	{
		coursereviewService.setofferingID(offeringId);
		List<CourseReviewDAO> courseReviewData = coursereviewService.extractCourseReviewData();
		String jsonData = convertReviewDAOtoJSON(courseReviewData);
		jsonData+= ":" + getSkillsAverage(courseReviewData);
 		return jsonData;
	}

	private String convertToString(List<String> data)
	{
		String converted="";
		
		for(String s:data)
		{
			s=s.replace(':', ' ');
			converted+=s+":";
		}
		if(converted.length()>0)	
		converted = converted.substring(0,converted.length()-1);
		return converted;
	}
	
	private String convertReviewDAOtoJSON(List<CourseReviewDAO> courseReviewData)
	{
		String converted="";	
		for(CourseReviewDAO ind:courseReviewData)
		{
				converted += ind.getStudentFname()+" "+ind.getStudentLname() + "|" +
							 ind.getreviewComment() + "|" +
							 ind.getnumofExams() + "|" +
							 ind.getnumofQuiz() + "|" +
							 ind.getnumofProj() + "|" +
							 ind.getnumofAssignment() + "|" + ":";
			}
		if(converted.length()>0)
		converted = converted.substring(0,converted.length()-1);
		return converted;
	}

	private String getSkillsAverage(List<CourseReviewDAO> courseReviewData){
		String skillsAvg = "";
		Float numofquizAvg = 0.0f;
		Float numofexamsAvg = 0.0f;
		Float numofprojAvg = 0.0f;
		Float workloadAvg =0.0f;
		Float numofassignmentsAvg =0.0f;
		for(CourseReviewDAO ind:courseReviewData){
			numofexamsAvg += ind.getnumofExams();
			numofquizAvg += ind.getnumofQuiz();
			numofprojAvg += ind.getnumofProj();
			workloadAvg += ind.getworkLoad();
			numofassignmentsAvg += ind.getnumofAssignment();
		}
		if(courseReviewData.size()>0){
			numofquizAvg = numofquizAvg/courseReviewData.size();
			numofexamsAvg = numofexamsAvg/courseReviewData.size();
			numofprojAvg = numofprojAvg/courseReviewData.size();
			workloadAvg = workloadAvg/courseReviewData.size();
			numofassignmentsAvg = numofassignmentsAvg/courseReviewData.size();
		
		skillsAvg +=  
				numofexamsAvg.toString().substring(0,numofexamsAvg.toString().length()>3?4:3)+ "|" +
				numofquizAvg.toString().substring(0,numofquizAvg.toString().length()>3?4:3)+"|" +
				numofprojAvg.toString().substring(0,numofprojAvg.toString().length()>3?4:3)+ "|" + 
				numofassignmentsAvg.toString().substring(0,numofassignmentsAvg.toString().length()>3?4:3)+"|"+
				workloadAvg.toString().substring(0,workloadAvg.toString().length()>3?4:3);
		}
		
		return skillsAvg;
	}


	public DepartmentNameService getDeptNameService() {
		return deptNameService;
	}


	public void setDeptNameService(DepartmentNameService deptNameService) {
		this.deptNameService = deptNameService;
	}


	public CourseReviewCourseNameService getCoursereviewcourseNameService() {
		return coursereviewcourseNameService;
	}


	public void setCoursereviewcourseNameService(
			CourseReviewCourseNameService coursereviewcourseNameService) {
		this.coursereviewcourseNameService = coursereviewcourseNameService;
	}


	public CourseReviewInstructorService getCoursereviewinstructorService() {
		return coursereviewinstructorService;
	}


	public void setCoursereviewinstructorService(
			CourseReviewInstructorService coursereviewinstructorService) {
		this.coursereviewinstructorService = coursereviewinstructorService;
	}


	public CourseReviewService getCoursereviewService() {
		return coursereviewService;
	}


	public void setCoursereviewService(CourseReviewService coursereviewService) {
		this.coursereviewService = coursereviewService;
	}
	

	
}
