package com.nik.college.domain;

public class Faculty {
	
	private int facultyId;
	private String facultyName;
	private String phoneNumber;
	private String email;
	private String facultyCode;
	
	
	public Faculty(String facultyName,String phoneNumber,String email,String facultyCode){
		
		this.facultyName=facultyName;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.facultyCode=facultyCode;
	}
	
	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}