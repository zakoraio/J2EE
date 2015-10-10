package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class CourseReviewInstructorRowExtractor 
{
	public String extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	  return resultSet.getString(1).replace(';', ' ')+";"+resultSet.getString(2).replace(';', ' ')+","+resultSet.getString(3).replace(';', ' ');  
	 }  

}
