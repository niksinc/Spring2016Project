package com.nik.college.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nik.college.domain.Course;

@Service("courseService")
@Transactional
public class CoursedaoServiceImpl implements CourseDaoService {

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
