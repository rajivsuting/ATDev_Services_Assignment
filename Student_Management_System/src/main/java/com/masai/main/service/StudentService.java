package com.masai.main.service;

import java.util.List;

import com.masai.main.exception.StudentException;
import com.masai.main.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student)throws StudentException;
	
	public List<Student> getAllStudents() throws StudentException;
	
	public Student getStudentWithId(Integer id) throws StudentException;
	
	public Student deleteStudentWithId(Integer id) throws StudentException;
	
	public Student updateStudent(Student student) throws StudentException;

}
