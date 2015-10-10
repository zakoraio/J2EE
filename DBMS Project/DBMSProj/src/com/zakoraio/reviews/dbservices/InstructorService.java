package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.InstructorNameRowMapper;

public class InstructorService{

	private DataSource dataSource;
	private String deptName;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public List<String> extractInstructorNames(){

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> deptNames = new ArrayList<String>();
		 
		 String query =  "select instructorid, instructorname from instructor where deptname = ?";
		 deptNames = jdbcTemplate.query(query, new Object[]{deptName} ,new InstructorNameRowMapper());  
		
		return deptNames;
	}
	
	
	public String getInstructorNameByOfferingId(String id){
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> instructorName = new ArrayList<String>();
		 
		 String query =  "select instructorname from instructor i where instructorid = (" +
		 		"select instructorid from courseofferingdetails where offeringid=?)";
		 instructorName = jdbcTemplate.query(query, new Object[]{id} ,new InstructorNameRowMapper());
		 return instructorName.get(0);
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}