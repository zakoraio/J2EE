package com.zakoraio.reviews.dbservices;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakoraio.reviews.dao.CourseReviewDAO;
import com.zakorio.reviews.mappers.CourseReviewRowMapper;

public class CourseReviewService 
{
	private DataSource dataSource;
	private int offeringID;
	
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() 
	{
		return dataSource;
	}  

	public List<CourseReviewDAO> extractCourseReviewData()
	{
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<CourseReviewDAO> courseReviewData ;
		 
		 System.out.println("Passed offering id is:"+offeringID);
		 //System.out.println("Passed instructor id is:"+instructorid);
		 //System.out.println("Passed yeartaken is:"+yeartaken);
		 String query =  "select s.fname,s.lname,cd.coursename,i.instructorname,cod.yeartaken,"
		 		+ "rc.reviewcomment,rc.numberofquiz,rc.numberofexams,rc.numberofproj,rc.workload,rc.numberofassignment "
		 		+ "from coursedetails cd,student s,instructor i, courseofferingdetails cod, review r,reviewcourse rc "
		 		+ "where r.reviewid=rc.reviewid and r.username=s.username and rc.offeringid = ? and "
		 		+ "rc.offeringid = cod.offeringid and cod.courseid=cd.courseid and cod.instructorid=i.instructorid;";
		 courseReviewData = jdbcTemplate.query(query,new Object [] {offeringID} ,new CourseReviewRowMapper());  
		 
		 System.out.println("size of courseReviewData is:"+courseReviewData.size());
		 System.out.println("!!!!!!!!!!!!!!!!!Retrieved coursereview!!!!!!!!!!!!!!!!!!!!!!!!!");
		 //select cd.coursename,i.instructorname,cod.yeartaken,s.fname,s.lname,rc.reviewcomment from 
		 //coursedetails cd,instructor i,courseofferingdetails cod,review r,reviewcourse rc,
		 //student s where cod.courseid=cd.courseid and cod.instructorid=i.instructorid and 
		 //cod.offeringid=rc.offeringid and r.username=s.username and r.reviewid=rc.reviewid;
		return courseReviewData;
	}
	
	public int getofferingID() 
	{
		return offeringID;
	}

	public void setofferingID(int offeringId) 
	{
		this.offeringID = offeringId;
	}
}
