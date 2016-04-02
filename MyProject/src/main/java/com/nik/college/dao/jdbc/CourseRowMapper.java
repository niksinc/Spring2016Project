package com.nik.college.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nik.college.domain.Course;
import com.nik.college.domain.Faculty;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class CourseRowMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet resultSet, int row) throws SQLException {
		
		int courseId;
		String courseCode;
		String courseName;
		String courseSection;
		int facultyId;
		Course course;
		//courseId, courseCode, courseName, courseSection, facultyId
		courseCode = resultSet.getString("courseCode");
		courseName = resultSet.getString("courseName");
		courseSection = resultSet.getString("courseSection");
		facultyId= resultSet.getInt("facultyId");
		
		course = new Course(courseCode, courseName, courseSection, facultyId);
		
		course.setCourseId(resultSet.getInt("courseId"));
		
		course.setCourseCode(courseCode);
		course.setCourseName(courseName);
		
		course.setCourseSection(courseSection);
		course.setFacultyId(facultyId);
		return course;
		
	}
	

}
