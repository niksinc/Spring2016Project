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



import com.nik.college.dao.FacultyDao;
import com.nik.college.domain.Faculty;
import com.nik.college.domain.Student;

@Repository("facultyjdbc")
public class FacultyjdbcImpl implements FacultyDao {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private FacultyRowMapper facultyRowMapper;
	
	@PostConstruct
	public void setup() {
		System.out.println("i am in the FacultyJdbc");
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("i am in the FacultyJdbc2");
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		facultyRowMapper = new FacultyRowMapper();
		
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("faculty")
		                 .usingGeneratedKeyColumns("facultyId")
		                 .usingColumns("facultyName", "phoneNumber", "email");
		System.out.println("i am in the FacultyJdbc0");
	}
	
	public Faculty findCourseByIdCode(int id) {
			
		return null;
	}

	public Faculty findFacultyByFacultyCode(String facultyCode) {

		String sql  ="select * FROM faculty WHERE facultyCode =:facultyCode";
		MapSqlParameterSource params = new MapSqlParameterSource("facultyCode",facultyCode);
		List<Faculty> matchingFaculty = dbTemplate.query(sql, params, facultyRowMapper);
		if (matchingFaculty.size() == 0) {
			return null;
		}
		return matchingFaculty.get(0);
	}

	public void insertFaculty(Faculty faculty) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(faculty);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		faculty.setFacultyId(newId.intValue());
	}

	public void deleteFaculty(Faculty faculty) {
		String sql  ="delete from faculty where facultyId=?";
		jdbcTemplate.update(sql,Long.valueOf(faculty.getFacultyId()));
		
	}

	public int updatefaculty(int facultyId, Faculty faculty) {
		// TODO Auto-generated method stub
		String sql = "update faculty  set facultyName=:facultyName,phoneNumber:=phoneNumber,email:=email,facultyCode:=facultyCode where facultyId=:facultyId";
		String facultyName,phoneNumber,email,facultyCode;
		MapSqlParameterSource params;
		int rowsAffected;
		
		facultyName = faculty.getFacultyName();
		phoneNumber = faculty.getPhoneNumber();
		facultyCode = faculty.getFacultyCode();
		email = faculty.getEmail();
		
		params = new MapSqlParameterSource("facultyId", facultyId);
		
		params.addValue("facultyName", facultyName);
		params.addValue("phoneNumber", phoneNumber);
		params.addValue("facultyCode", facultyCode);
		params.addValue("email", email);
		System.out.println("--- sql is ---"+params.getValue("email"));
		rowsAffected = dbTemplate.update(sql, params);
		
		
		
		
		return rowsAffected;
		
	}

	public int getFacultyCount() {
		String sql = "select count(*) FROM faculty";
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
	}

}