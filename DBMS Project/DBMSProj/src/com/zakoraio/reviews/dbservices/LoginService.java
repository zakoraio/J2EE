package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.LoginRowMapper;

public class LoginService{

	private DataSource dataSource;
	private String userName;
	private String passWord;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public List<String> extractUserNames(String id,String password)
	{
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> count = new ArrayList<String>();
		 
		 String query =  "Select count(*) from useraccessdetails where username=? and password=?";
		 count = jdbcTemplate.query(query, new Object[]{id,password} ,new LoginRowMapper()); 
		
		 System.out.println("Login return, count is:"+count);
		 return count;
	}
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String username) {
		this.userName = username;
	}
	
	public String getpassWord() {
		return passWord;
	}

	public void setpassWord(String password) {
		this.passWord = password;
	}
}