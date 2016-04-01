package com.nik.college.service;

import com.nik.college.domain.Student;

public interface StudentDoaService {

	public int getStudentCount();
	public Student findStudentById(int id);
	public Student findStudentByName(String name);
	public void addStudent(Student stud);
	public int updateStudent(long id, Student student);
	public void deleteStudent(Student stud);
}
