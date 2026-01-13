package com.dm.springbootjpapostgresql.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.model.entity.Student;
import com.dm.springbootjpapostgresql.dto.StudentDTO;

public interface StudentService {
    public StudentDTO getStudentById(Long id);
    public List<StudentDTO> getAllStudents();
    public StudentDTO createStudent(StudentDTO studentDTO);
    public StudentDTO updateStudent(StudentDTO studentDTO,Long id);
    public boolean checkStudentExists(Long id);
    public void deleteStudentById(Long id);
    public void deleteAllStudents();

    //public List<StudentDTO> getAllStudentsByGuardianName(String name);
    
    public StudentResponse getAllStudentsPaged(int pageNo, int pageSize, String sortBy, String sortDir);   

    public List<StudentDTO> getStudentsByFirstName(String firstName);
    public List<StudentDTO> getStudentsByFirstNameIs(String firstName);
    public List<StudentDTO> getStudentsByFirstNameEquals(String firstName);
    public List<StudentDTO> getStudentsByFirstNameStartingWith(String prefix);
    public List<StudentDTO> getStudentsByFirstNameEndingWith(String suffix);        
    public List<StudentDTO> getStudentsByFirstNameIgnoreCase(String firstName);
    public List<StudentDTO> getStudentsByFirstNameContaining(String firstName);
    public List<StudentDTO> getStudentsByFirstNameContainingIgnoreCase(String firstName);
    public List<StudentDTO> getStudentsByFirstNameLike(String likePattern);    
    public List<StudentDTO> getStudentsByFirstNameNot(String firstName);
    public List<StudentDTO> getStudentsByFirstNameIsNot(String firstName);
    public List<StudentDTO> getStudentsByFirstNameIsNull();
    public List<StudentDTO> getStudentsByFirstNameIsNotNull();

    public List<StudentDTO> getStudentsByFirstNameOrderByFirstName(String firstName);
    public List<StudentDTO> getStudentsByFirstNameOrderByFirstNameAsc(String firstName);    
    public List<StudentDTO> getStudentsByFirstNameOrderByFirstNameDesc(String firstName);

    public List<StudentDTO> getStudentsByLastName(String lastName);
    public List<StudentDTO> getStudentsByLastNameNotNull(String lastName);

    public List<StudentDTO> getStudentsByEmail(String email);

    public List<StudentDTO> getStudentsByStatus(Integer status);

    public List<StudentDTO> getStudentsByActiveTrue();
    public List<StudentDTO> getStudentsByActiveFalse();    

    public List<StudentDTO> getStudentsByAgeLessThan(Integer age);
    public List<StudentDTO> getStudentsByAgeLessThanEqual(Integer age);
    public List<StudentDTO> getStudentsByAgeGreaterThan(Integer age);
    public List<StudentDTO> getStudentsByAgeGreaterThanEqual(Integer age);
    public List<StudentDTO> getStudentsByAgeBetween(Integer startAge, Integer endAge);
    public List<StudentDTO> getStudentsByAgeIn(Collection<Integer> ages);
    public List<StudentDTO> getStudentsByBirthDateAfter(LocalDate birthDate);
    public List<StudentDTO> getStudentsByBirthDateBefore(LocalDate birthDate);

    public List<StudentDTO> getStudentsByFirstNameAndLastName(String firstName,String lastName);
    public List<StudentDTO> getStudentsByFirstNameOrLastName(String firstName,String lastName);
    public List<StudentDTO> getStudentsByFirstNameOrAge(String name, Integer age);
    public List<StudentDTO> getStudentsByFirstNameOrAgeAndActive(String name, Integer age, Boolean active);

    //JPQL
    public List<StudentDTO> getAllStudents2();
    public List<StudentDTO> getAllStudentsSorted(Sort sort);
    public StudentResponse getAllStudentsWithPagination(Pageable pageable);
    public StudentDTO getStudentByEmailAddress(String email);
    public List<StudentDTO> getAllStudentsByStatus(Integer status);
    public List<StudentDTO> getAllActiveStudents();
    public List<StudentDTO> getStudentsByFirstNameContainingIgnoreCase2(String firstName);  
    public StudentDTO getStudentFirstNameByEmailAddress(String email);
    public List<StudentDTO> getStudentsByStatusAndFirstName(Integer status, String firstName);
    public List<StudentDTO> getStudentsByStatusAndFirstNameNamedParams(Integer status, String firstName);
    public List<StudentDTO> getStudentsByStudentStatusAndFirstName(Integer studentStatus, String firstName);
    public List<StudentDTO> getAllStudentsByFirstNameList(Collection<String> firstNames);    
    public int updateStudentStatusByFirstName(Integer status, String firstName);
	
	//Native
    public List<StudentDTO> getAllActiveStudentsNative();
    public List<StudentDTO> getAllStudentsByStatusNative(Integer status);
    public StudentDTO getStudentByEmailAddressNative(String email);
    public StudentDTO getStudentByEmailAddressNativeNamedParam(String email);    
    public StudentResponse getAllStudentsWithPaginationNative(Pageable pageable);
    public List<StudentDTO> getAllStudentsByStatusAndNameNamedParamsNative(Integer status, String firstName);

    public int updateStudentNameByEmail(String firstName, String email);
    public int updateStudentStatusByNameNative(Integer status, String firstName);
    public void insertUser(String firstName,String lastName,Integer age,LocalDate birthDate,
        String email,Integer status,Boolean active);
}
