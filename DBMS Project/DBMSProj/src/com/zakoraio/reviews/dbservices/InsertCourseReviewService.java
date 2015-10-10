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

public class InsertCourseReviewService {
	
	private DataSource dataSource;
	private String offeringId;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public void insertCourseReviewData(String username, String comment, int exams, int quizes, int projects, int assign,int offeringid){

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
		 Object [] paramsReview ={reviewId.get(0)+1,username,'C',sqlDate};
		 String queryReview =  "insert into review (reviewid,username,type,reviewdate)  values(?,?,?,?)";
		 jdbcTemplate.update(queryReview ,paramsReview,typesReview);
		 Object [] paramsCourseReview ={reviewId.get(0)+1,offeringid,comment,quizes,exams,projects,(quizes+exams+projects+assign)/4,assign};
		 int [] typesCourseReview = {Types.INTEGER,Types.INTEGER,Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER};
		 String queryCourseReview =  "insert into reviewcourse (reviewid,offeringid,reviewcomment,numberofquiz,numberofexams" +
		 		",numberofproj,workload,numberofassignment)  values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(queryCourseReview ,paramsCourseReview,typesCourseReview);  
		
	}

	public String getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}



}
