package com.zakoraio.reviews.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.zakoraio.reviews.dao.StudentBasicDAO;

public class StudentRowExtractor {
	public StudentBasicDAO extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
		StudentBasicDAO studentDao = new StudentBasicDAO();  
	    
		studentDao.setUsername(resultSet.getString(1));  
		studentDao.setFirstName(resultSet.getString(2));  
		studentDao.setLastName(resultSet.getString(3));  
		studentDao.setCity(resultSet.getString(4));  
		studentDao.setState(resultSet.getString(5));
		studentDao.setZip(resultSet.getString(6));  
		studentDao.setApt(resultSet.getString(7));  
		studentDao.setYear(resultSet.getInt(8));  
		studentDao.setReviews(resultSet.getInt(9));  
		studentDao.setStreet(resultSet.getString(10));
	    
	  return studentDao;  
	 }  

}
