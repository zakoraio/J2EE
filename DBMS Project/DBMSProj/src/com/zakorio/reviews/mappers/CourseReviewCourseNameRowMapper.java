package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.CourseReviewCourseNameRowExtractor;

public class CourseReviewCourseNameRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		 CourseReviewCourseNameRowExtractor courseNameExtractor = new CourseReviewCourseNameRowExtractor();  
		  return courseNameExtractor.extractData(resultSet);  
		 }  
}
