package com.nik.college.dao.jdbc;

import org.springframework.stereotype.Repository;

import com.nik.college.dao.CourseDao;
import com.nik.college.domain.Course;

@Repository("coursejdbc")
public class CoursejdbcImpl implements CourseDao {
	
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
