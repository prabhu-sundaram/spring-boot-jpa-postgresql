package com.dm.springbootjpapostgresql.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.dto.StudentDTO;
import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.mapper.jpa.StudentMapper;
import com.dm.springbootjpapostgresql.model.entity.Guardian;
import com.dm.springbootjpapostgresql.model.entity.Student;
import com.dm.springbootjpapostgresql.repository.jpa.StudentRepository;
import com.dm.springbootjpapostgresql.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    //private GuardianRepository guardianRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository,StudentMapper studentMapper
    //,GuardianRepository guardianRepository
    )
    {
        this.studentRepository=studentRepository;
        this.studentMapper=studentMapper;
        //this.guardianRepository=guardianRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents()
    {
        LOGGER.info("Getting all students");
        List<Student> students=studentRepository.findAll();
        List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        LOGGER.info("All students:"+studentsDTO);

        return studentsDTO;
    }

    @Override
    public List<StudentDTO> getAllStudentsByFirstName(String firstName)
    {
        List<Student> students=studentRepository.findByFirstName(firstName);
        List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        return studentsDTO;
    }   
    @Override
    public List<StudentDTO> getAllStudentsByFirstNameContaining(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameContaining(firstName);
        List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        return studentsDTO;
    }       
    @Override
    public List<StudentDTO> getAllStudentsByLastNameNotNull(String lastName)
    {
        List<Student> students=studentRepository.findByLastName(lastName);
        List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        return studentsDTO;
    } 

    // @Override
    // public List<StudentDTO> getAllStudentsByGuardianName(String name)
    // {
    //     List<Student> students=studentRepository.findByGuardianName(name);
    //     List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
    //     return studentsDTO;
    // }     

    @Override
    public StudentResponse getAllStudentsPaged(int pageNo, int pageSize, String sortBy, String sortDir)
    {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Student> students = studentRepository.findAll(pageable);

        // get content for page object
        List<Student> listOfStudents = students.getContent();

        List<StudentDTO> content= listOfStudents.stream().map(student -> studentMapper.toDTO(student)).collect(Collectors.toList());

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setContent(content);
        studentResponse.setPageNo(students.getNumber());
        studentResponse.setPageSize(students.getSize());
        studentResponse.setTotalElements(students.getTotalElements());
        studentResponse.setTotalPages(students.getTotalPages());
        studentResponse.setLast(students.isLast());

        return studentResponse;
    }

    @Override
    public StudentDTO getStudentById(long id)
    {
        Student student = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student","id",id));
        return  studentMapper.toDTO(student);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO)
    {
        Student student=studentMapper.toEntity(studentDTO);
        Student newStudent=studentRepository.save(student);
        return studentMapper.toDTO(newStudent);

    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO,long id)
    {
        Student student=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student", "id", id));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        Student updatedStudent=studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    @Override
    public void deleteStudentById(long id)
    {
        Student student=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student", "id", id));
        studentRepository.delete(student);
    }

    @Override
    public void deleteAllStudents()
    {
        studentRepository.deleteAll();
    }
    
    @Override
    public boolean checkStudentExists(long id)
    {
        return studentRepository.existsById(id);
    }

}
