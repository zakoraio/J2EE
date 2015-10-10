package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.CourseReviewInstructorRowExtractor;

public class CourseReviewInstructorRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		 CourseReviewInstructorRowExtractor instructorExtractor = new CourseReviewInstructorRowExtractor();  
		  return instructorExtractor.extractData(resultSet);  
		 }  
}
