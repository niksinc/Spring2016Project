package com.nik.college.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nik.college.dao.StudentDao;
import com.nik.college.domain.Course;
import com.nik.college.domain.Student;

import sun.reflect.LangReflectAccess;

import org.springframework.stereotype.Service;

@Repository("studentjdbc")
public class StudentjdbcImpl implements StudentDao{

	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private StudentRowMapper studentRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		studentRowMapper = new StudentRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("student")
		                 .usingGeneratedKeyColumns("id")
		                 .usingColumns("name", "lastName", "phoneNumber","email");
	}
	
	public int getStudentCount() {
		String sql = "select count(*) FROM student";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public Student findStudentById(long id) {
		String sql = "select * FROM student WHERE id= :id";
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		List<Student> matchingStudents = dbTemplate.query(sql, params, studentRowMapper);
		if (matchingStudents.size() == 0) {
			return null;
		}
		return matchingStudents.get(0);
	}

	public Student findStudentByName(String name) {
		String sql  ="select * FROM student WHERE name =:name";
		MapSqlParameterSource params = new MapSqlParameterSource("name",name);
		List<Student> matchingStudents = dbTemplate.query(sql, params, studentRowMapper);
		if (matchingStudents.size() == 0) {
			return null;
		}
		return matchingStudents.get(0);
	}
	

	public void insertStudent(Student stud) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(stud);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		stud.setId(newId.intValue());
		
	}

	public void deleteStudent(Student stud) {
		String sql  ="delete from student where id=?";
		jdbcTemplate.update(sql,Long.valueOf(stud.getId()));
	}

	public void updatePhone(Student stud) {
		
		
	}

	public void updateProfile(Student stud) {
		
	}

	public int updateStudent(long id, Student student) {
		
		String sql = "update student  set name=:name ,lastName:=lastName,phoneNumber:=phoneNumber, email:=email where id=:id";
		String name,lastName,phoneNumber,email;
		System.out.println("the update query ois"+sql);
		MapSqlParameterSource params;
		int rowsAffected;
		
		name = student.getName();
		lastName = student.getLastName();
		phoneNumber = student.getPhoneNumber();
		email = student.getEmail();
		
		params = new MapSqlParameterSource("id", id);
		params.addValue("name", name);
		params.addValue("lastName", lastName);
		params.addValue("phoneNumber", phoneNumber);
		params.addValue("email", email);
		rowsAffected = dbTemplate.update(sql, params);
		
		return rowsAffected;

	}

	public void insertStudentCourse(Course course) {
		
		
		
		
	}
	
	

}
