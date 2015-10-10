package com.zakoraio.reviews.dbservices;

import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zakorio.reviews.mappers.ReviewRowMapper;

public class InsertInstructorReviewService {
	
	private DataSource dataSource;
	private String offeringId;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public void insertInstructorReviewData(String username, String comment, int teaching, int knowledge, int interaction, int offeringid){

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<Integer> reviewId ;
		 
		 
		 int [] typesReview = {Types.INTEGER,Types.VARCHAR,Types.CHAR,Types.DATE};
		 reviewId = jdbcTemplate.query("select max(reviewid) from review" ,new ReviewRowMapper());
		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date myDate= null;
		try {
			myDate = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		 Object [] paramsReview ={reviewId.get(0)+1,username,'I',sqlDate};
		 String queryReview =  "insert into review (reviewid,username,type,reviewdate)  values(?,?,?,?)";
		 jdbcTemplate.update(queryReview ,paramsReview,typesReview);
		 Object [] paramsInstructorReview ={reviewId.get(0)+1,offeringid,comment,teaching,knowledge,interaction};
		 int [] typesInstructorReview = {Types.INTEGER,Types.INTEGER,Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		 String queryInstructorReview =  "insert into reviewinstructor (reviewid,offeringid,reviewcomment,teachingaptitude,subjectcommand" +
		 		",interaction)  values(?,?,?,?,?,?)";
		jdbcTemplate.update(queryInstructorReview ,paramsInstructorReview,typesInstructorReview);  
		
	}

	public String getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}



}
