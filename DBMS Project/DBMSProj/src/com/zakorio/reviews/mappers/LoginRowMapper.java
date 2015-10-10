package com.zakorio.reviews.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zakoraio.reviews.extractors.LoginRowExtractor;

public class LoginRowMapper  implements RowMapper<String>{
	 public String mapRow(ResultSet resultSet, int line) throws SQLException {  
		  LoginRowExtractor deptNameExtractor = new LoginRowExtractor();  
		  return deptNameExtractor.extractData(resultSet);  
		 }  
}
