package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.CourseReviewCourseNameRowMapper;

public class CourseReviewCourseNameService
{
	private DataSource dataSource;
	private String deptName;
	
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() 
	{
		return dataSource;
	}  

	public List<String> extractCourseNames()
	{
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> courseNames = new ArrayList<String>();
		 
		 String query =  "Select courseid,coursename from coursedetails where deptname = ?";
		 courseNames = jdbcTemplate.query(query,new Object[]{deptName} ,new CourseReviewCourseNameRowMapper());  
		 System.out.println("extracted courses size are:"+courseNames.size()+"and the courses are:"+courseNames);
		 return courseNames;
	}
	public String getdeptName() 
	{
		return deptName;
	}
	public void setdeptName(String deptname) 
	{
		this.deptName = deptname;
	}
}