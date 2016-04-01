package com.nik.college.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.nik.college.domain.Student;


public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet, int row) throws SQLException {
		String studName;
		String lastName;
		String phoneNumber;
		Student student;
		
		studName = resultSet.getString("name");
		lastName = resultSet.getString("lastName");
		phoneNumber= resultSet.getString("phoneNumber");
		
		student = new Student(studName, lastName,phoneNumber);
		student.setId(resultSet.getInt("id"));
		student.setLastName(lastName);
		student.setName(studName);
		student.setPhoneNumber(resultSet.getString("phoneNumber"));
		
		return student;
	}
}
