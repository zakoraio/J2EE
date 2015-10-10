package com.zakoraio.reviews.controller.view.data;

import java.util.List;
import java.util.Map;

import com.zakoraio.reviews.dao.CourseReviewDAO;

public class CourseReviewData 
{
	private String deptNames;
	private Map<String,String> courseNames;
	private Map<String,String> instructorNames;
	private List<CourseReviewDAO> courseReviewData;
	
	public String getDeptNames() 
	{
		return deptNames;
	}

	public void setDeptNames(String deptNames) 
	{
		this.deptNames = deptNames;
	}

	public Map<String, String> getcourseNames() 
	{
		return courseNames;
	}

	public void setcourseNames(Map<String, String> coursenames) 
	{
		this.courseNames = coursenames;
	}
	
	public Map<String, String> getinstructorNames() 
	{
		return instructorNames;
	}

	public void setinstructorName(Map<String, String> instructornames) 
	{
		this.instructorNames = instructornames;
	}
	public List<CourseReviewDAO> getCourseReviewData() {
		return courseReviewData;
	}

	public void setCourseReviewData(
			List<CourseReviewDAO> courseReviewData) {
		this.courseReviewData = courseReviewData;
	}	
}
