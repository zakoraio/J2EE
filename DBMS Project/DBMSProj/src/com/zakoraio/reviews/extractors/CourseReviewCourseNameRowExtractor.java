package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class CourseReviewCourseNameRowExtractor 
{
	public String extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException 
	{  
	  return resultSet.getString(1)+"_"+resultSet.getString(2)+" Section"+
	  resultSet.getString(1).substring(resultSet.getString(1).length()-2);  
	 }  
}
