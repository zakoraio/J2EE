package com.zakoraio.reviews.dao;

import java.util.List;

public class ProfileDAO {

	private StudentBasicDAO studentBasicDAO;
	private List<CourseTakenDAO> coursesTakenDAO;
	public StudentBasicDAO getStudentBasicDAO() {
		return studentBasicDAO;
	}
	public void setStudentBasicDAO(StudentBasicDAO studentBasicDAO) {
		this.studentBasicDAO = studentBasicDAO;
	}
	public void setCourseDAO(List<CourseTakenDAO> courseDAO) {
		this.coursesTakenDAO = courseDAO;
	}
	public List<CourseTakenDAO> getCourseDAO() {
		return coursesTakenDAO;
	}
	
}
