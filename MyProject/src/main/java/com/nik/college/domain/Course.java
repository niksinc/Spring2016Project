package com.nik.college.domain;

public class Course {
	
	private int courseId;
	private String courseCode;
	private String courseName;
	private String courseSection;
	private int facultyId;
	
	public Course(String courseCode,String courseName,String courseSection,int facultyId){
		this.courseCode=courseCode;
		this.courseName=courseName;
		this.courseSection=courseSection;
		this.facultyId=facultyId;
	}
	
	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseSection() {
		return courseSection;
	}


	public void setCourseSection(String courseSection) {
		this.courseSection = courseSection;
	}


	public int getFacultyId() {
		return facultyId;
	}


	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
	

}
