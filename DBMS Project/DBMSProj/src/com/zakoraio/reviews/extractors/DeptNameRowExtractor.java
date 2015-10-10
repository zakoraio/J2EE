package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.zakoraio.reviews.dao.CourseTakenDAO;

public class DeptNameRowExtractor {
	public String extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	  return resultSet.getString(1);  
	 }  

}
