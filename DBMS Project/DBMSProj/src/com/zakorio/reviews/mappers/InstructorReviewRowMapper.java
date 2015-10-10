package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.dao.InstructorReviewDAO;
import com.zakoraio.reviews.extractors.InstructorNameRowExtractor;
import com.zakoraio.reviews.extractors.InstructorReviewRowExtractor;

public class InstructorReviewRowMapper  implements RowMapper<InstructorReviewDAO>{
	 public InstructorReviewDAO mapRow(ResultSet resultSet, int line) throws SQLException {  
		 InstructorReviewRowExtractor instructorReviewExtractor = new InstructorReviewRowExtractor();  
		  return instructorReviewExtractor.extractData(resultSet);  
		 }  
}
