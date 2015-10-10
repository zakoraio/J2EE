package com.zakoraio.reviews.dbservices;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zakorio.reviews.mappers.DeptNameRowMapper;

public class DepartmentNameService{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}  

	public List<String> extractDeptNames(){

		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 List<String> deptNames = new ArrayList<String>();
		 
		 String query =  "Select distinct(deptname) from instructor";
		 deptNames = jdbcTemplate.query(query,new DeptNameRowMapper());  
		
		return deptNames;
	}

}