package com.zakoraio.reviews.dao;

public class InstructorReviewDAO {
	
	private String studentFname;
	private String studentLname;
	private String comment;
	private Integer teachingApt;
	private Integer commandSub;
	private Integer interaction;
	
	public void setStudentFname(String studentFname) {
		this.studentFname = studentFname;
	}
	public String getStudentFname() {
		return studentFname;
	}
	
	public void setStudentLname(String studentLname) {
		this.studentLname = studentLname;
	}
	public String getStudentLname() {
		return studentLname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getTeachingApt() {
		return teachingApt;
	}
	public void setTeachingApt(Integer teachingApt) {
		this.teachingApt = teachingApt;
	}
	public Integer getCommandSub() {
		return commandSub;
	}
	public void setCommandSub(Integer commandSub) {
		this.commandSub = commandSub;
	}
	public Integer getInteraction() {
		return interaction;
	}
	public void setInteraction(Integer interaction) {
		this.interaction = interaction;
	}
	
}
