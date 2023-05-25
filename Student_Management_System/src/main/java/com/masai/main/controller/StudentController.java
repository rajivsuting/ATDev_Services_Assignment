package com.masai.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.main.exception.StudentException;
import com.masai.main.model.Student;
import com.masai.main.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService s_Service;
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student studnet) throws StudentException{
		
		Student savedStudent = s_Service.addStudent(studnet);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() throws StudentException{
		
		List<Student> studentList = s_Service.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) throws StudentException{
		
		Student student = s_Service.getStudentWithId(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudentWithId(@PathVariable("id") Integer id) throws StudentException{
		
		Student student = s_Service.deleteStudentWithId(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) throws StudentException{
		Student updatedStudent = s_Service.updateStudent(student);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
	}

}
