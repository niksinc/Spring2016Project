package com.nik.college.dao.jdbc;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nik.college.dao.CourseDao;
import com.nik.college.domain.Course;

@Repository("coursejdbc")
public class CoursejdbcImpl implements CourseDao {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private CourseRowMapper courseRowMapper;
	
	@PostConstruct
	public void setup() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		courseRowMapper = new CourseRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("course")
		                 .usingGeneratedKeyColumns("courseId")
		                 .usingColumns("courseCode", "courseName", "courseSection", "facultyId");
		
	}
	
	
	
	public Course findCourseByCourseCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertCourse(Course course) {
	System.out.println("course name is "+course.getCourseName());
		SqlParameterSource params = new BeanPropertySqlParameterSource(course);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		course.setFacultyId(newId.intValue());
		
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
