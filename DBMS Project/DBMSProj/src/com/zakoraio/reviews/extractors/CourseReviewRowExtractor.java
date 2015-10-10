package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.zakoraio.reviews.dao.CourseReviewDAO;

public class CourseReviewRowExtractor {
	public CourseReviewDAO extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
		CourseReviewDAO courseReviewDao = new CourseReviewDAO();  

		courseReviewDao.setStudentFname(resultSet.getString(1));
		courseReviewDao.setStudentLname(resultSet.getString(2));
		courseReviewDao.setcourseName(resultSet.getString(3));
		courseReviewDao.setinstructorName(resultSet.getString(4));
		courseReviewDao.setyearTaken(resultSet.getString(5));
		courseReviewDao.setreviewComment(resultSet.getString(6));
		courseReviewDao.setnumofQuiz(resultSet.getInt(7));
		courseReviewDao.setnumofExams(resultSet.getInt(8));
		courseReviewDao.setnumofProj(resultSet.getInt(9));
		courseReviewDao.setworkLoad(resultSet.getInt(10));
		courseReviewDao.setnumofAssignment(resultSet.getInt(11));
		
	  return courseReviewDao;  
	 }  
}
