package com.nik.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nik.college.dao.CourseDao;
import com.nik.college.dao.FacultyDao;
import com.nik.college.domain.Course;

@Service("courseService")
@Transactional
public class CoursedaoServiceImpl implements CourseDaoService {
	@Autowired
	private CourseDao coursejdbc;
	public Course findCourseByCourseCode(int id) {
		return coursejdbc.findCourseByCourseCode(id);
	}

	public Course findCourseByName(String name) {
		
		return coursejdbc.findCourseByName(name);
	}

	public void insertCourse(Course course) {
		
		coursejdbc.insertCourse(course);
	}

	public void deleteCourse(Course course) {
		coursejdbc.deleteCourse(course);
		
	}

	public int updateCourse(int id, Course course) {
		
		return coursejdbc.updateCourse(id, course);
	}

	public int getCourseCount() {
		return coursejdbc.getCourseCount();
	}

}