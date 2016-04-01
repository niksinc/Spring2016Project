package com.nik.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nik.college.dao.FacultyDao;
import com.nik.college.dao.StudentDao;
import com.nik.college.domain.Faculty;
@Service("facultyService")
@Transactional
public class FacultyDaoServiceImpl implements FacultyDaoService {
	@Autowired
	private FacultyDao facultyjdbc;
	
	public Faculty findCourseByIdCode(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Faculty findFacultyByFacultyCode(String facultyCode) {
		// TODO Auto-generated method stub
		return facultyjdbc.findFacultyByFacultyCode(facultyCode);
		
		
	}

	public void insertFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		facultyjdbc.insertFaculty(faculty);
		
	}

	public void deleteFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		facultyjdbc.deleteFaculty(faculty);
		
	}

	public int updatefaculty(int facultyId, Faculty faculty) {
		
		return facultyjdbc.updatefaculty(facultyId, faculty);
	}

	public int getFacultyCount() {
		// TODO Auto-generated method stub
		return facultyjdbc.getFacultyCount();
		
	}

}
