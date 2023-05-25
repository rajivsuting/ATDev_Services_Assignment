package com.masai.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.masai.main.exception.StudentException;
import com.masai.main.model.Student;
import com.masai.main.service.StudentService;

@SpringBootTest
class StudentManagementSystemApplicationTests {
	
	@Autowired
	private StudentService sService;
	
	@Test
	public void testAddStudent() throws StudentException {
		
		Student student = new Student();
		student.setName("Rajiv Suting");
		student.setEmail("rajiv@gmail.com");
		student.setScore(800);
		
		sService.addStudent(student);
		assertNotNull(sService.getStudentWithId(1));
	}
	
	
	@Test
	public void testGetAll() throws StudentException {
		
		List<Student> list = sService.getAllStudents();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testDetProductById() throws StudentException {
		
		Student student = sService.getStudentWithId(1);
		assertEquals("Rajiv Suting", student.getName());

	}
	
	
	@Test
	public void testUpdateStudent() throws StudentException {
		
		Student student = sService.getStudentWithId(1);
		sService.updateStudent(new Student(1, "Rahul Suting", "rahul@gmail.com", 800));
		assertNotEquals("Rajiv Suting", sService.getStudentWithId(1).getName());
	}
	
	

	
	

}
