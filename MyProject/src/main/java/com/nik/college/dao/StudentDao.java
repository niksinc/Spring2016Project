package com.nik.college.dao;

import com.nik.college.domain.Course;
import com.nik.college.domain.Student;

public interface StudentDao {
	
	public Student findStudentById(long id);
	public Student findStudentByName(String name);
	public void insertStudent(Student stud);
	public void deleteStudent(Student stud);
	public int updateStudent(long id, Student student);
	public int getStudentCount();
	
	public void insertStudentCourse(Course course);

}