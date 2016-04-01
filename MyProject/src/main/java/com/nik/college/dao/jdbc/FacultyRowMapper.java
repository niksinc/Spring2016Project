package com.nik.college.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.nik.college.domain.Faculty;


public class FacultyRowMapper implements RowMapper<Faculty> {
	
	public Faculty mapRow(ResultSet resultSet, int row) throws SQLException {
		
		String facultyName;
		String phoneNumber;
		String email;
		String facultyCode;
		Faculty faculty;
		
		facultyName = resultSet.getString("facultyName");
		phoneNumber = resultSet.getString("phoneNumber");
		email= resultSet.getString("email");
		facultyCode= resultSet.getString("facultyCode");
		
		faculty = new Faculty(facultyName, phoneNumber, email,facultyCode);
		faculty.setFacultyId(resultSet.getInt("facultyId"));
		faculty.setEmail(email);
		System.out.println("email is mapper is "+email);
		faculty.setFacultyCode(facultyCode);
		faculty.setFacultyName(facultyName);
		faculty.setPhoneNumber(phoneNumber);
		return faculty;
		
	}
	
}
