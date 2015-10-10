package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.CourseOfferingDetailsRowMapper;

public class CourseOfferingDetailsService{

	private DataSource dataSource;
	private String instructorId;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public List<String> extractDeptNames(){

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> deptNames = new ArrayList<String>();
		 
		 String query =  "select coursename , cod.yeartaken, cod.offeringid from courseofferingdetails cod " +
		 		", coursedetails cd where cod.instructorid= ?  and cod.courseid = cd.courseid";
		 deptNames = jdbcTemplate.query(query,new Object [] {instructorId} ,new CourseOfferingDetailsRowMapper());  
		
		return deptNames;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorId() {
		return instructorId;
	}

}