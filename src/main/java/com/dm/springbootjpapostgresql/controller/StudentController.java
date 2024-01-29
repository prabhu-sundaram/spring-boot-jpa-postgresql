package com.dm.springbootjpapostgresql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.Student;

@RestController
@RequestMapping("/api")    

public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Ramesh", "Fadatare","test@gmail.com");
	}

	@GetMapping("/students")
	public List<Student> getStudents(){		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ramesh", "Fadatare","test1@gmail.com"));
		students.add(new Student("Tony", "Cena","test2@gmail.com"));
		students.add(new Student("Sanjay", "Jadhav","test3@gmail.com"));
		students.add(new Student("Ram", "Jadhav","test4@gmail.com"));
		students.add(new Student("Umesh", "Fadatare","test5@gmail.com"));
		return students;
	}

	@GetMapping("/student/{firstName}/{lastName}/")
	public Student studentPathVariable(@PathVariable("firstName") String firstName, 
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}

	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
	}
    
}
