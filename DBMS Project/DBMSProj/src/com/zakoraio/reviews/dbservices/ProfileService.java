package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakoraio.reviews.dao.CourseTakenDAO;
import com.zakoraio.reviews.dao.ProfileDAO;
import com.zakoraio.reviews.dao.StudentBasicDAO;
import com.zakorio.reviews.mappers.CoursesTakenRowMapper;
import com.zakorio.reviews.mappers.StudentRowMapper;

public class ProfileService {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  
	
	public ProfileDAO extractStudentDetails(String userName){
		 ProfileDAO profileDao;
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<StudentBasicDAO> studentDAOList = new ArrayList<StudentBasicDAO>();
		 List<CourseTakenDAO> coursesTakenDAOList = new ArrayList<CourseTakenDAO>();
		 
		 String query =  "Select * from Student where username = ?";
		 studentDAOList = jdbcTemplate.query(  
				    query, new Object[]{userName}, new StudentRowMapper());  
				  
		 
		query = "select cd.coursename , cd.deptname from coursedetails cd ," +
				" coursestaken ct where ct.courseid=cd.courseid and " +
				"ct.username = ?";
		
		coursesTakenDAOList = jdbcTemplate.query(query, new Object[]{userName}, new CoursesTakenRowMapper());
		
		profileDao = new ProfileDAO();
		profileDao.setStudentBasicDAO(studentDAOList.get(0));
		profileDao.setCourseDAO(coursesTakenDAOList);
		
		return profileDao;
	}
	
	
}
