package com.dm.springbootjpapostgresql.mapper;

import com.dm.springbootjpapostgresql.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.StudentDTO;

@Component
public class StudentMapper{

public StudentMapper()
{

}

public Student toEntity(StudentDTO studentDTO)
{

    Student student=Student.builder()
    .firstName(studentDTO.getFirstName())
    .lastName(studentDTO.getLastName())
    .email(studentDTO.getEmail())
    //.guardian(studentDTO.getGuardian())
    .build();

    return student;
}

public StudentDTO toDTO(Student student)
{
    StudentDTO studentDTO=StudentDTO.builder()
    .studentId(student.getStudentId())
    .firstName(student.getFirstName())
    .lastName(student.getLastName())
    .email(student.getEmail())
    //.guardian(student.getGuardian())
    .build();

    return studentDTO;
}
public List<StudentDTO> toDTOs(List<Student> students)
{
    // List<StudentDTO> studentDTOs = new ArrayList<>();
    
    // for (Student student : students) {
    //     studentDTOs.add(toDTO(student));
    // }

    // return studentDTOs;

        return students.stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
}

}
