package com.dm.springbootjpapostgresql.service;

import java.util.List;

import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.dto.StudentDTO;

public interface StudentService {
    public List<StudentDTO> getAllStudents();
    StudentResponse getAllStudentsPaged(int pageNo, int pageSize, String sortBy, String sortDir);
    public List<StudentDTO> getAllStudentsByFirstName(String firstName);
    public List<StudentDTO> getAllStudentsByFirstNameContaining(String firstName);
    public List<StudentDTO> getAllStudentsByLastNameNotNull(String lastName);

    //public List<StudentDTO> getAllStudentsByGuardianName(String name);


    public StudentDTO getStudentById(long id);

    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO updateStudent(StudentDTO studentDTO,long id);

    public void deleteStudentById(long id);
    public void deleteAllStudents();

    public boolean checkStudentExists(long id);
    
    

}
