package com.nik.college.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nik.college.dao.CourseDao;
import com.nik.college.domain.Course;
import com.nik.college.domain.Faculty;

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
	
	
	
	public Course findCourseByCourseCode(int courseId) {
		String sql  ="select * FROM course WHERE courseId =:courseId";
		MapSqlParameterSource params = new MapSqlParameterSource("courseId",courseId);
		List<Course> matchingFaculty = dbTemplate.query(sql, params, courseRowMapper);
		if (matchingFaculty.size() == 0) {
			return null;
		}
		return matchingFaculty.get(0);
	}

	public Course findCourseByName(String courseName) {
		String sql  ="select * FROM course WHERE courseName =:courseName";
		MapSqlParameterSource params = new MapSqlParameterSource("courseName",courseName);
		List<Course> matchingFaculty = dbTemplate.query(sql, params, courseRowMapper);
		if (matchingFaculty.size() == 0) {
			return null;
		}
		return matchingFaculty.get(0);
	}

	public void insertCourse(Course course) {
	System.out.println("course name is "+course.getCourseName());
		SqlParameterSource params = new BeanPropertySqlParameterSource(course);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		course.setFacultyId(newId.intValue());
		
	}

	public void deleteCourse(Course course) {
		String sql  ="delete from course where courseId=?";
		jdbcTemplate.update(sql,Long.valueOf(course.getCourseId()));
		
	}

	public int updateCourse(int id, Course course) {
		//courseId, courseCode, courseName, CourseSection, facultyId
		String sql = "update course  set courseName=:courseName,courseCode=:courseCode,courseSection=:courseSection,facultyCode=:facultyCode ,facultyId=:facultyId where courseId=:courseId";
		String  courseCode, courseName, courseSection;
		int courseId,facultyId;
		MapSqlParameterSource params;
		int rowsAffected;
		
		courseCode =course.getCourseCode();
		courseName = course.getCourseName();
		courseSection = course.getCourseSection();
		facultyId =course.getFacultyId();
		courseId = course.getCourseId();
		
		params = new MapSqlParameterSource("courseId", courseId);
		params.addValue("courseCode", courseCode);
		params.addValue("courseName", courseName);
		params.addValue("courseSection", courseSection);
		params.addValue("facultyId", facultyId);
		
		rowsAffected = dbTemplate.update(sql, params);
		return rowsAffected;
		
	}

	public int getCourseCount() {
		String sql = "select count(*) FROM course";
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
	}

}
