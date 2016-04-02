package com.nik.college.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nik.college.dao.jdbc.StudentjdbcImpl;
import com.nik.college.domain.Course;
import com.nik.college.domain.Faculty;
import com.nik.college.domain.Student;
import com.nik.college.service.CourseDaoService;
import com.nik.college.service.FacultyDaoService;
import com.nik.college.service.StudentDoaService;


public class MainApp {
	
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");
		StudentDoaService studentService;
		studentService= (StudentDoaService)container.getBean("studentService");
		
		FacultyDaoService facultyService;
		facultyService = (FacultyDaoService)container.getBean("facultyService");
		Faculty f1 = facultyService.findFacultyByFacultyCode("fa007");

		CourseDaoService courseService;
		courseService= (CourseDaoService) container.getBean("courseService");
		
		

	}
}
