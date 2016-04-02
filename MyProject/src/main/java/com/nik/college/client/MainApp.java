package com.nik.college.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nik.college.dao.jdbc.StudentjdbcImpl;
import com.nik.college.domain.Course;
import com.nik.college.domain.Faculty;
import com.nik.college.domain.Student;
import com.nik.college.service.FacultyDaoService;
import com.nik.college.service.StudentDoaService;


public class MainApp {
	
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");
		StudentDoaService studentService;
		studentService= (StudentDoaService)container.getBean("studentService");
		
		FacultyDaoService facultyService;
		facultyService = (FacultyDaoService)container.getBean("facultyService");
		
		//Faculty faculty =new Faculty("MR V.zenden", "0987654321", "n@n.com");
		//facultyService.insertFaculty(faculty);
		Faculty f1 = facultyService.findFacultyByFacultyCode("fa007");
		//f1.setEmail("nikhil@gmail.com");
		//f1.setFacultyName("nikhil");
		//f1.setPhoneNumber("66566565");
		//System.out.println("the emmea is" +f1.getEmail());
		facultyService.updatefaculty(f1.getFacultyId(),f1);
		
		//facultyService.deleteFaculty(f1);
		//System.out.println(f1.getEmail());
		
		/*	
		Student s =studentService.findStudentById(1);
		Student s2 =studentService.findStudentByName("roail");
		
		if(s2==null)
			System.out.println("No studetn found");
		else
			System.out.println("Student is "+s2.toString());
			*/
		Course course = new Course("cs548", "Java","A", 11);
		
		//System.out.println(course.getCourseCode());
		//Faculty faculty =new Faculty("MR V.zenden", "0987654321", "n@n.com");
	//	System.out.println("this is faculty "+faculty.getFacultyName());
		
		
		//studentService.deleteStudent(s2);
		//Student sd= new Student("nik", "joy", "1234567890");
		//studentService.updateStudent(s2.getId(),sd);
	}
}
