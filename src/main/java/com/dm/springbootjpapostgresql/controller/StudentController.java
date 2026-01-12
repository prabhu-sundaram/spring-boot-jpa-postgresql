package com.dm.springbootjpapostgresql.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.dto.StudentDTO;
import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.utils.AppConstants;

import jakarta.validation.Valid;

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
    // public List<StudentDTO> getAllStudents()
	// {
    //     return studentService.getAllStudents();
    // }
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<StudentDTO> students = studentService.getAllStudents();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200
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

	@GetMapping(value="/checkStudentExists/{id}",produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> checkStudentExists(@PathVariable(name="id") long id) {
		return new ResponseEntity<>("Student exists: "+studentService.checkStudentExists(id) , HttpStatus.OK);
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
	//--------------------------------------------------------------	

	@GetMapping("/getAllStudentsPaged")
	public ResponseEntity<StudentResponse> getAllStudentsPaged(
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "studentId") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {

		StudentResponse studentResponse =
				studentService.getAllStudentsPaged(pageNo, pageSize, sortBy, sortDir);

		return ResponseEntity.ok(studentResponse); // ALWAYS 200
	}
 
	@GetMapping("/getStudentsByFirstName")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstName
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstName(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}
	@GetMapping("/getStudentsByFirstNameIs")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameIs
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIs(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}
	@GetMapping("/getStudentsByFirstNameEquals")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameEquals
	(@RequestParam(required = true) String firstName)
		{
		List<StudentDTO> students = studentService.getStudentsByFirstNameEquals(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}
	@GetMapping("/getStudentsByFirstNameStartingWith")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameStartingWith
	(@RequestParam(required = true) String prefix)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameStartingWith(prefix);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameEndingWith")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameEndingWith
	(@RequestParam(required = true) String suffix)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameEndingWith(suffix);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameIgnoreCase")    
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameIgnoreCase
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIgnoreCase(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameContaining")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameContaining
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameContaining(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameContainingIgnoreCase")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameContainingIgnoreCase
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameContainingIgnoreCase(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameLike")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameLike
	(@RequestParam(required = true) String likePattern)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameLike(likePattern);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameNot")    
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameNot
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameNot(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameIsNot")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameIsNot
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIsNot(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameIsNull")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameIsNull()
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIsNull();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameIsNotNull")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameIsNotNull()
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIsNotNull();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByFirstNameOrderByFirstName")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrderByFirstName
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameOrderByFirstName(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameOrderByFirstNameAsc")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrderByFirstNameAsc
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIs(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameOrderByFirstNameDesc")   
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrderByFirstNameDesc
	(@RequestParam(required = true) String firstName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameIs(firstName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByLastName")
    public ResponseEntity<List<StudentDTO>> getStudentsByLastName
	(@RequestParam(required = true) String lastName)
	{
		List<StudentDTO> students = studentService.getStudentsByLastName(lastName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByLastNameNotNull")
    public ResponseEntity<List<StudentDTO>> getStudentsByLastNameNotNull
	(@RequestParam(required = true) String lastName)
	{
		List<StudentDTO> students = studentService.getStudentsByLastNameNotNull(lastName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByEmail")
    public ResponseEntity<List<StudentDTO>> getStudentsByEmail
	(@RequestParam(required = true) String email)
	{
		List<StudentDTO> students = studentService.getStudentsByEmail(email);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByStatus")
    public ResponseEntity<List<StudentDTO>> getStudentsByStatus
	(@RequestParam(required = true) Integer status)
	{
		List<StudentDTO> students = studentService.getStudentsByStatus(status);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByActiveTrue")
    public ResponseEntity<List<StudentDTO>> getStudentsByActiveTrue()
	{
		List<StudentDTO> students = studentService.getStudentsByActiveTrue();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByActiveFalse")
    public ResponseEntity<List<StudentDTO>> getStudentsByActiveFalse()
	{
		List<StudentDTO> students = studentService.getStudentsByActiveFalse();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	   

	@GetMapping("/getStudentsByAgeLessThan")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeLessThan
	(@RequestParam(required = true) Integer age)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeLessThan(age);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByAgeLessThanEqual")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeLessThanEqual
	(@RequestParam(required = true) Integer age)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeLessThanEqual(age);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByAgeGreaterThan")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeGreaterThan
	(@RequestParam(required = true) Integer age)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeGreaterThan(age);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByAgeGreaterThanEqual")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeGreaterThanEqual
	(@RequestParam(required = true) Integer age)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeGreaterThanEqual(age);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByAgeBetween")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeBetween
	(@RequestParam(required = true) Integer startAge, 
	@RequestParam(required = true) Integer endAge)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeBetween(startAge,endAge);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByAgeIn")
    public ResponseEntity<List<StudentDTO>> getStudentsByAgeIn
	(@RequestParam(required = true) Collection<Integer> ages)
	{
		List<StudentDTO> students = studentService.getStudentsByAgeIn(ages);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByBirthDateAfter")
    public ResponseEntity<List<StudentDTO>> getStudentsByBirthDateAfter
	(@RequestParam(required = true) ZonedDateTime birthDate)
	{
		List<StudentDTO> students = studentService.getStudentsByBirthDateAfter(birthDate);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByBirthDateBefore")
    public ResponseEntity<List<StudentDTO>> getStudentsByBirthDateBefore
	(@RequestParam(required = true) ZonedDateTime birthDate)
	{
		List<StudentDTO> students = studentService.getStudentsByBirthDateBefore(birthDate);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

	@GetMapping("/getStudentsByFirstNameAndLastName")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameAndLastName
	(@RequestParam(required = true) String firstName,
	@RequestParam(required = true) String lastName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameAndLastName(firstName,lastName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameOrLastName")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrLastName
	(@RequestParam(required = true) String firstName,
	@RequestParam(required = true) String lastName)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameOrLastName(firstName,lastName);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	
	@GetMapping("/getStudentsByFirstNameOrAge")
	public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrAge
	(@RequestParam(required = true) String name, 
	@RequestParam(required = true) Integer age) {
		List<StudentDTO> students = studentService.getStudentsByFirstNameOrAge(name, age);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200
	}
	@GetMapping("/getStudentsByFirstNameOrAgeAndActive")
    public ResponseEntity<List<StudentDTO>> getStudentsByFirstNameOrAgeAndActive
	(@RequestParam(required = true) String name, 
	@RequestParam(required = true) Integer age, 
	@RequestParam(required = true) Boolean active)
	{
		List<StudentDTO> students = studentService.getStudentsByFirstNameOrAgeAndActive(name,age,active);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200		
	}	

    // //JPQL
	@GetMapping("/getAllStudents2")
    public ResponseEntity<List<StudentDTO>> getAllStudents2()
	{
		List<StudentDTO> students = studentService.getAllStudents2();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200			
	}
	@GetMapping("/getAllStudentsSorted")
    public ResponseEntity<List<StudentDTO>> getAllStudentsSorted(
		@SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort)
	{
		List<StudentDTO> students = studentService.getAllStudentsSorted(sort);
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200			
	}	

	@GetMapping("/getAllStudentsWithPagination")
    public ResponseEntity<StudentResponse> getAllStudentsWithPagination(
		@PageableDefault(size = 20, sort = "studentId", direction = Sort.Direction.DESC) Pageable pageable)
	{
		StudentResponse studentResponse = studentService.getAllStudentsWithPagination(pageable);	
		return ResponseEntity.ok(studentResponse); // ALWAYS 200
	}		
    // public StudentDTO getStudentByEmailAddress(String email);
    // public List<StudentDTO> getAllStudentsByStatus(Integer status);
    // public List<StudentDTO> getAllActiveStudents();
    // public List<StudentDTO> getStudentsByFirstNameContainingIgnoreCase2(String firstName);  
    // public StudentDTO getStudentFirstNameByEmailAddress(String email);
    // public List<StudentDTO> getStudentsByStatusAndFirstName(Integer status, String firstName);
    // public List<StudentDTO> getStudentsByStatusAndFirstNameNamedParams(Integer status, String firstName);
    // public List<StudentDTO> getStudentsByStudentStatusAndFirstName(Integer studentStatus, String firstName);
    // public List<StudentDTO> getAllStudentsByFirstNameList(Collection<String> firstNames);    
    
	@GetMapping("/updateStudentStatusByFirstName")
	public ResponseEntity<String> updateStudentStatusByFirstName(
		@RequestParam(required = true) Integer status, 
		@RequestParam(required = true) String firstName)
	{
		Integer count = studentService.updateStudentStatusByFirstName(status,firstName);

		if (count > 0) {
			// Returns 200 OK with a success message
			return ResponseEntity.ok("Successfully updated " + count + " student(s).");
		} else {
			// Returns 404 Not Found if no rows were affected
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("No student found with first name: " + firstName);
		}		
	}
	
	//--------------------------------------------------------------	
	//Native
	@GetMapping("/getAllActiveStudentsNative")
    public ResponseEntity<List<StudentDTO>> getAllActiveStudentsNative()
	{
		List<StudentDTO> students = studentService.getAllActiveStudentsNative();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();   // HTTP 204
		}
		return ResponseEntity.ok(students);             // HTTP 200			
	}
    // public List<StudentDTO> getAllStudentsByStatusNative(Integer status);
    // public StudentDTO getStudentByEmailAddressNative(String email);
    // public StudentDTO getStudentByEmailAddressNativeNamedParam(String email);    
    // public StudentResponse getAllStudentsWithPaginationNative(Pageable pageable);
    // public List<StudentDTO> getAllStudentsByStatusAndNameNamedParamsNative(Integer status, String firstName);

	// @GetMapping("/updateStudentNameByEmail")
    // public ResponseEntity<String> updateStudentNameByEmail(
	// 	@RequestParam(required = true) String firstName, 
	// 	@RequestParam(required = true) String email);


	// @GetMapping("/updateStudentStatusByNameNative")
    // public ResponseEntity<String> updateStudentStatusByNameNative(
	// 	@RequestParam(required = true) Integer status, 
	// 	@RequestParam(required = true) String firstName);

	// @GetMapping("/insertUser")
    // public ResponseEntity<String> insertUser(
	// 	@RequestParam(required = true) String firstName,
	// 	@RequestParam(required = true) Integer age,
	// 	@RequestParam(required = true) Integer status,
	// 	@RequestParam(required = true) String email);

}
