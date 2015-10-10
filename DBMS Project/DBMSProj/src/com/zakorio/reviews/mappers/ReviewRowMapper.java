package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.DeptNameRowExtractor;
import com.zakoraio.reviews.extractors.StudentRowExtractor;

public class ReviewRowMapper  implements RowMapper<Integer>{
	 public Integer mapRow(ResultSet resultSet, int line) throws SQLException {  
		  return resultSet.getInt(1);  
		 }  
}
