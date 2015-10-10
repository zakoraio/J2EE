package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.CourseReviewInstructorRowMapper;

public class CourseReviewInstructorService
{
	private DataSource dataSource;
	private String courseID;

	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() 
	{
		return dataSource;
	}  

	public List<String> extractInstructorNames()
	{
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> instructorNames = new ArrayList<String>();
		 
		 System.out.println("Passed courseID is:"+courseID);
		 String query =  "select  i.instructorname, cod.yeartaken , cod.offeringid "
		 		+ " from instructor i,courseofferingdetails cod where cod.instructorid=i.instructorid and "
		 		+ "cod.courseid = ?";
		 instructorNames = jdbcTemplate.query(query, new Object[]{courseID} ,new CourseReviewInstructorRowMapper());  
		 System.out.println("Retrieved instructor name is:"+instructorNames);
		return instructorNames;
	}
	public String getcourseId() 
	{
		return courseID;
	}
	public void setcourseID(String courseId) 
	{
		this.courseID = courseId;
	}
}
