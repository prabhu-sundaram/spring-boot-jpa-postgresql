package com.dm.springbootjpapostgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.dto.StudentDTO;
import com.dm.springbootjpapostgresql.model.Student;
import com.dm.springbootjpapostgresql.model.Tutorial;
import com.dm.springbootjpapostgresql.dto.GuardianDTO;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostResponse;
import com.dm.springbootjpapostgresql.model.Guardian;
import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.utils.AppConstants;

import jakarta.validation.Valid;

import com.dm.springbootjpapostgresql.service.PostService;
import com.dm.springbootjpapostgresql.service.StudentService;


@RestController
//@Validated
@RequestMapping("/api/student")    

public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}

	// @GetMapping("/student")
	// public Student getStudent() {
	// 	return new Student("Ramesh", "Fadatare","test@gmail.com");
	// }

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable(name="id") long id) {

		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	// @GetMapping("/students")
	// public List<Student> getStudents(){		
	// 	List<Student> students = new ArrayList<>();
	// 	students.add(new Student("Ramesh", "Fadatare","test1@gmail.com"));
	// 	students.add(new Student("Tony", "Cena","test2@gmail.com"));
	// 	students.add(new Student("Sanjay", "Jadhav","test3@gmail.com"));
	// 	students.add(new Student("Ram", "Jadhav","test4@gmail.com"));
	// 	students.add(new Student("Umesh", "Fadatare","test5@gmail.com"));
	// 	return students;
	// }

	@GetMapping
    public List<StudentDTO> getAllStudents()
	{
        return studentService.getAllStudents();
    }
	
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }	

	// @GetMapping("/student/{firstName}/{lastName}/")
	// public Student studentPathVariable(@PathVariable("firstName") String firstName, 
	// 		@PathVariable("lastName") String lastName) {
	// 	return new Student(firstName, lastName);
	// }

	// @GetMapping("/student/query")
	// public Student studentQueryParam(
	// 		@RequestParam(name = "firstName") String firstName,
	// 		@RequestParam(name = "lastName") String lastName) {
	// 	return new Student(firstName, lastName);
	// }
    
	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable(name = "id") long id, @Valid @RequestBody StudentDTO studentDTO) {
		StudentDTO studentDTOResponse = studentService.updateStudent(studentDTO, id);
		return new ResponseEntity<>(studentDTOResponse, HttpStatus.OK);
	}		

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
		try {
			studentService.deleteStudentById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllStudent() {
		try {
			studentService.deleteAllStudents();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value="/checkStudentExists/{id}",produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> checkStudentExists(@PathVariable(name="id") long id) {
		return new ResponseEntity<>("Student exists: "+studentService.checkStudentExists(id) , HttpStatus.OK);
	}	

}
