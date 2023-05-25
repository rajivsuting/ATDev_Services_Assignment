package com.masai.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.main.exception.StudentException;
import com.masai.main.model.Student;
import com.masai.main.repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student addStudent(Student student) throws StudentException {
		
		String email = student.getEmail();
		Student existStudent = studentRepo.findByEmail(email);
		
		//Checking if any student with this email exist or not. If exist then it will throw student exception.
		if(existStudent == null) {
			return studentRepo.save(student);
			
		}
		throw new StudentException("Student with this email already exist...");
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> result = studentRepo.findAll();
		
		//If no students are found in the database it will throw student exception with the bellow message.
		if(result.isEmpty()) throw new StudentException("No student found");

		return result;
	}

	@Override
	public Student getStudentWithId(Integer id) throws StudentException {
		
		Optional<Student> opt = studentRepo.findById(id);
		
		//Checking if student with the given id exists or not.
		if(opt.isEmpty()) throw new StudentException("No student found with id "+ id);
		else {
			Student result = opt.get();
			return result;
		}
	}



	@Override
	public Student deleteStudentWithId(Integer id) throws StudentException {
		
		Optional<Student> opt = studentRepo.findById(id);
		
		//Checking if student with the given id exists or not.
		if(opt.isEmpty()) throw new StudentException("No student found with id "+ id);
		else {
			Student result = opt.get();
			studentRepo.delete(result);
			return result;
		}
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		Optional<Student> opt = studentRepo.findById(student.getId());
		
		//Checking if student with the given id exists or not.
		if(opt.isEmpty()) throw new StudentException("No student found with id "+ student.getId());
		else {
			Student studentUpdate = opt.get();
			studentRepo.save(student);
			return studentUpdate;
		}
	}



}
