package com.zakoraio.reviews.dbservices;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakoraio.reviews.dao.InstructorReviewDAO;
import com.zakorio.reviews.mappers.InstructorReviewRowMapper;

public class InstructorReviewService {
	
	private DataSource dataSource;
	private String offeringId;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public List<InstructorReviewDAO> extractInstructorReviewData(){

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<InstructorReviewDAO> instructorReviewData ;
		 
		 String query =  "select s.fname , s.lname , ir.reviewcomment , ir.teachingaptitude " +
		 ", ir.subjectcommand ,  ir.interaction from student s , review r, reviewinstructor ir " +
		 "where ir.offeringid = ? and ir.reviewid = r.reviewid and r.username = s.username;";
		 instructorReviewData = jdbcTemplate.query(query,new Object [] {offeringId} ,new InstructorReviewRowMapper());  
		
		return instructorReviewData;
	}

	public String getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}



}
