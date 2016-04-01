package com.nik.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nik.college.dao.StudentDao;
import com.nik.college.domain.Student;
@Service("studentService")
@Transactional
public class StudentDaoServiceImpl implements StudentDoaService {
	@Autowired
	private StudentDao studentjdbc;
	
	
	public int getStudentCount() {
		int n=0;
		return studentjdbc.getStudentCount();
	}


	public Student findStudentById(int id) {
		
		return studentjdbc.findStudentById(id);
	}


	public Student findStudentByName(String name) {
		
		
		return studentjdbc.findStudentByName(name);
	}


	public void addStudent(Student stud) {
		studentjdbc.insertStudent(stud);
		
	}
	
	public void deleteStudent(Student stud) {
		studentjdbc.deleteStudent(stud);
		
	}


	public int updateStudent(long id, Student student) {
		
		return studentjdbc.updateStudent(id, student);
		
	}
	
	

}
