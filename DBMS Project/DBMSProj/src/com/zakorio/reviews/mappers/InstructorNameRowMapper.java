package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.InstructorNameRowExtractor;

public class InstructorNameRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		  InstructorNameRowExtractor instructorNameExtractor = new InstructorNameRowExtractor();  
		  return instructorNameExtractor.extractData(resultSet);  
		 }  
}
