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
		
		Student student = new Student("Nikhil", "Surti", "9558885756","n@n..com");
		studentService.addStudent(student);
		
		
		FacultyDaoService facultyService;
		facultyService = (FacultyDaoService)container.getBean("facultyService");
		Faculty faculty = new Faculty("My ken Chung", "7896655412", "ken@chung.com","Fac009");
		
		facultyService.insertFaculty(faculty);

		CourseDaoService courseService;
		courseService= (CourseDaoService) container.getBean("courseService");
		Course course =new Course("CS548", "Adv. Java", "A", 1);
		courseService.insertCourse(course);
		
		//Course course = courseService.findCourseByName("Java");

	}
}
