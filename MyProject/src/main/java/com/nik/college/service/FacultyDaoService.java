package com.nik.college.service;

import com.nik.college.domain.Faculty;

public interface FacultyDaoService {

	public Faculty findCourseByIdCode(int id);
	public Faculty findFacultyByFacultyCode(String facultyCode);
	public void insertFaculty(Faculty faculty);
	public void deleteFaculty(Faculty faculty);
	public int updatefaculty(int facultyId, Faculty faculty);
	public int getFacultyCount();

}
