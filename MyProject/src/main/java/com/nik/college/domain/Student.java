package com.nik.college.domain;

public class Student {

	private long id;
	private String name;
	private String lastName;
	private String phoneNumber;
	
	public Student(String name,String lastName,String phoneNumber){
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
