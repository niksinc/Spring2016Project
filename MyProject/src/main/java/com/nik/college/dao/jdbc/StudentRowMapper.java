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
		String email;
		Student student;
		
		studName = resultSet.getString("name");
		lastName = resultSet.getString("lastName");
		phoneNumber= resultSet.getString("phoneNumber");
		email  = resultSet.getString("email");
		
		student = new Student(studName, lastName,phoneNumber,email);
		student.setId(resultSet.getInt("id"));
		student.setLastName(lastName);
		student.setName(studName);
		student.setPhoneNumber(resultSet.getString("phoneNumber"));
		student.setEmail(resultSet.getString("email"));
		return student;
	}
}
