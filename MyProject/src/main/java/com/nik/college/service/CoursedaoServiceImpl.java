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
	public Course findCourseByCourseCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertCourse(Course course) {
		// TODO Auto-generated method stub
		coursejdbc.insertCourse(course);
	}

	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	public int updateCourse(long id, Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCourseCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
