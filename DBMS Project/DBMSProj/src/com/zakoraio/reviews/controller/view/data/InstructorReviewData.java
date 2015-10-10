package com.zakoraio.reviews.controller.view.data;

import java.util.List;
import java.util.Map;

import com.zakoraio.reviews.dao.InstructorReviewDAO;

public class InstructorReviewData {
	
	private Map<String,String> deptNames;
	private List<InstructorReviewDAO> instructorReviewData;
	private String instructorName;
	
	public Map<String, String> getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(Map<String, String> deptNames) {
		this.deptNames = deptNames;
	}

	public List<InstructorReviewDAO> getInstructorReviewData() {
		return instructorReviewData;
	}

	public void setInstructorReviewData(
			List<InstructorReviewDAO> instructorReviewData) {
		this.instructorReviewData = instructorReviewData;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorName() {
		return instructorName;
	}
	
}
