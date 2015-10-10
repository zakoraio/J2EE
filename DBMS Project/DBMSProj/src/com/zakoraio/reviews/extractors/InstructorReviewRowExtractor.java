package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.zakoraio.reviews.dao.InstructorReviewDAO;
import com.zakoraio.reviews.dao.StudentBasicDAO;

public class InstructorReviewRowExtractor {
	public InstructorReviewDAO extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
		InstructorReviewDAO instructorReviewDao = new InstructorReviewDAO();  
	    
		instructorReviewDao.setStudentFname(resultSet.getString(1));
		instructorReviewDao.setStudentLname(resultSet.getString(2));
		instructorReviewDao.setComment(resultSet.getString(3));
		instructorReviewDao.setTeachingApt(resultSet.getInt(4));
		instructorReviewDao.setCommandSub(resultSet.getInt(5));
		instructorReviewDao.setInteraction(resultSet.getInt(6));
		
	    
	  return instructorReviewDao;  
	 }  

}
