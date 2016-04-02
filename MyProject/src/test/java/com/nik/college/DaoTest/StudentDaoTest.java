package com.nik.college.DaoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nik.college.dao.StudentDao;
import com.nik.college.domain.Student;

@ContextConfiguration("classpath:college-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDaoTest {

	@Autowired
	@Qualifier("studentjdbc")
	private StudentDao studentjdbc;
	
	private Student setupStudent;   /*  Initialized in the setup() method  */
	private int setupStudentId;    /*  Initialized in the setup() method  */
	
	
	@Before
	public void setup() {
		/*  We'll use this student in various tests. The student should already be in the database */
		setupStudent = new Student("Nikhil", "Surti", "9558885756","n@n.com");
		setupStudentId = 1;   /* In the DB, the student should have this id */
		setupStudent.setId(setupStudentId);
	}
	
	@Test
	public void testFindAcctByName() throws Exception {
		String acctName = setupStudent.getName();
		Student studFromDb;
		studFromDb = studentjdbc.findStudentByName(acctName);
		assertNotNull(studFromDb);
		assertEquals(setupStudent.getId(),studFromDb.getId());
	}
	

/*	@Test
	public void testGetStudentCount() {
		//List<Student> studList = StudentDao.findAllStudents();
		int count = studentjdbc.getStudentCount();
		assertEquals(count, studList.size());
	}
*/
	
	
}
