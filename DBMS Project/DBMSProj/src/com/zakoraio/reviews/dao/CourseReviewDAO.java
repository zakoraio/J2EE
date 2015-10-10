package com.zakoraio.reviews.dao;

public class CourseReviewDAO 
{
	private String studentFname;
	private String studentLname;
	private String courseName;
	private String instructorName;
	private String yearTaken;
	
	private String reviewComment;
	private Integer numofQuiz;
	private Integer numofExams;
	private Integer numofProj;
	private Integer workLoad;
	private Integer numofAssignment;
	
	public void setStudentFname(String studentFname) 
	{
		this.studentFname = studentFname;
	}
	
	public String getStudentFname() 
	{
		return studentFname;
	}
	
	public void setStudentLname(String studentLname) 
	{
		this.studentLname = studentLname;
	}
	
	public String getStudentLname() 
	{
		return studentLname;
	}
	
	public void setcourseName(String coursename) 
	{
		this.courseName = coursename;
	}
		
	public String getcourseName() 
	{
		return courseName;
	}
	
	public void setinstructorName(String instructorname) 
	{
		this.instructorName = instructorname;
	}
	
	public String getinstructorName() 
	{
		return instructorName;
	}
	
	public void setyearTaken(String yeartaken) 
	{
		this.yearTaken = yeartaken;
	}
	
	public String getyearTaken() 
	{
		return yearTaken;
	}
	
	public void setreviewComment(String reviewcomment) 
	{
		this.reviewComment = reviewcomment;
	}
	
	public String getreviewComment() 
	{
		return reviewComment;
	}
	
	public void setnumofQuiz(Integer quizenum) 
	{
		this.numofQuiz = quizenum;
	}
	
	public Integer getnumofQuiz() 
	{
		return numofQuiz;
	}
	
	public void setnumofExams(Integer examsnum) 
	{
		this.numofExams = examsnum;
	}

	public Integer getnumofExams() 
	{
		return numofExams;
	}
	
	public void setnumofProj(Integer projnum) 
	{
		this.numofProj = projnum;
	}

	public Integer getnumofProj() 
	{
		return numofProj;
	}
	
	public void setworkLoad(Integer workload) 
	{
		this.workLoad = workload;
	}
	
	public Integer getworkLoad() 
	{
		return workLoad;
	}

	public void setnumofAssignment(Integer assignmenntnum) 
	{
		this.numofAssignment = assignmenntnum;
	}
	
	public Integer getnumofAssignment() 
	{
		return numofAssignment;
	}	
}
