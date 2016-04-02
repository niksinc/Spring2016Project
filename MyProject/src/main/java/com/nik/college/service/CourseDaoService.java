package com.nik.college.service;

import com.nik.college.domain.Course;

public interface CourseDaoService {
	public Course findCourseByCourseCode(int id);
	public Course findCourseByName(String name);
	public void insertCourse(Course course);
	public void deleteCourse(Course course);
	public int updateCourse(int id, Course course);
	public int getCourseCount();

}
