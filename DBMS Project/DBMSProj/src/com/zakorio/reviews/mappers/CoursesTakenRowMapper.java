package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.dao.CourseTakenDAO;
import com.zakoraio.reviews.extractors.CoursesTakenRowExtractor;

public class CoursesTakenRowMapper  implements RowMapper<CourseTakenDAO>{
	 public CourseTakenDAO mapRow(ResultSet resultSet, int line) throws SQLException {  
		 CoursesTakenRowExtractor coursesTakenExtractor = new CoursesTakenRowExtractor();  
		  return coursesTakenExtractor.extractData(resultSet); 
	 }
}
