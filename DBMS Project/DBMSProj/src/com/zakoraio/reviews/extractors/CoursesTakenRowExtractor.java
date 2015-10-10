package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.zakoraio.reviews.dao.CourseTakenDAO;

public class CoursesTakenRowExtractor {
	public CourseTakenDAO extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
		CourseTakenDAO coursesTakenDao = new CourseTakenDAO();  
	    
		coursesTakenDao.setCourseName(resultSet.getString(1));  
		coursesTakenDao.setDeptName(resultSet.getString(2));  
		
	    
	  return coursesTakenDao;  
	 }  

}
