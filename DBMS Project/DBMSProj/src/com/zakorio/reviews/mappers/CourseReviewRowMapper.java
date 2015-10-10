package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.dao.CourseReviewDAO;
import com.zakoraio.reviews.extractors.CourseReviewRowExtractor;

public class CourseReviewRowMapper  implements RowMapper<CourseReviewDAO>{
	 public CourseReviewDAO mapRow(ResultSet resultSet, int line) throws SQLException {  
		 CourseReviewRowExtractor coursereviewExtractor = new CourseReviewRowExtractor();  
		  return coursereviewExtractor.extractData(resultSet);  
		 }  
}
