package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.CourseOfferingDetailsRowExtractor;

public class CourseOfferingDetailsRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		  CourseOfferingDetailsRowExtractor courseOfferingDetailsExtractor = new CourseOfferingDetailsRowExtractor();  
		  return courseOfferingDetailsExtractor.extractData(resultSet);  
		 }  
}
