package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.dao.StudentBasicDAO;
import com.zakoraio.reviews.extractors.StudentRowExtractor;

public class StudentRowMapper  implements RowMapper<StudentBasicDAO>{
	 public StudentBasicDAO mapRow(ResultSet resultSet, int line) throws SQLException {  
		  StudentRowExtractor userExtractor = new StudentRowExtractor();  
		  return userExtractor.extractData(resultSet);  
		 }  
}
