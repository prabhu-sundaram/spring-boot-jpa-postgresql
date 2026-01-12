package com.dm.springbootjpapostgresql.mapper.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.StudentDTO;
import com.dm.springbootjpapostgresql.dto.StudentResponse;
import com.dm.springbootjpapostgresql.model.entity.Student;

import org.mapstruct.BeanMapping;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

// @Component
// public class StudentMapper{

// public StudentMapper()
// {

// }

// public Student toEntity(StudentDTO studentDTO)
// {

//     Student student=Student.builder()
//     .firstName(studentDTO.getFirstName())
//     .lastName(studentDTO.getLastName())
//     .email(studentDTO.getEmail())
//     //.guardian(studentDTO.getGuardian())
//     .build();

//     return student;
// }

// public StudentDTO toDTO(Student student)
// {
//     StudentDTO studentDTO=StudentDTO.builder()
//     .studentId(student.getStudentId())
//     .firstName(student.getFirstName())
//     .lastName(student.getLastName())
//     .email(student.getEmail())
//     //.guardian(student.getGuardian())
//     .build();

//     return studentDTO;
// }
// public List<StudentDTO> toDTOs(List<Student> students)
// {
//     // List<StudentDTO> studentDTOs = new ArrayList<>();
    
//     // for (Student student : students) {
//     //     studentDTOs.add(toDTO(student));
//     // }

//     // return studentDTOs;

//         return students.stream()
//                    .map(this::toDTO)
//                    .collect(Collectors.toList());
// }

// }

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentMapper {

    /* =========================
       Entity ↔ DTO
       ========================= */

    Student toEntity(StudentDTO studentDTO);

    // This updates the existing Student entity with data from StudentDTO
    @Mapping(target = "studentId", ignore = true) // Usually, we don't want to change the ID
    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    // This tells MapStruct: if a DTO field is null, don't touch the Entity field
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)    
    void updateStudentFromDto(StudentDTO dto, @MappingTarget Student entity);   

    // This custom condition applies to ALL String mappings in this mapper
    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    StudentDTO toDTO(Student student);

    List<StudentDTO> toDTOs(List<Student> students);

    /* =========================
       Page → StudentResponse
       ========================= */

    @Mapping(source = "content", target = "content")
    @Mapping(source = "number", target = "pageNo")
    @Mapping(source = "size", target = "pageSize")
    @Mapping(source = "totalElements", target = "totalElements")
    @Mapping(source = "totalPages", target = "totalPages")
    @Mapping(source = "last", target = "last")
    StudentResponse toStudentResponse(Page<Student> studentPage);

}