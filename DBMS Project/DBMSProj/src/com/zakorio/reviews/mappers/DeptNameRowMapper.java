package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.DeptNameRowExtractor;
import com.zakoraio.reviews.extractors.StudentRowExtractor;

public class DeptNameRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		  DeptNameRowExtractor deptNameExtractor = new DeptNameRowExtractor();  
		  return deptNameExtractor.extractData(resultSet);  
		 }  
}
