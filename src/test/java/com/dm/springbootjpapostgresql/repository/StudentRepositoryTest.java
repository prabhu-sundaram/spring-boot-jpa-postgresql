package com.dm.springbootjpapostgresql.repository;

import com.dm.springbootjpapostgresql.model.entity.Student;
import com.dm.springbootjpapostgresql.repository.jpa.StudentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("prabhu3333343@gmail.com")
                .firstName("Prabhu")
                .lastName("Sundaram")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);                

        Student student2 = Student.builder()
                .email("prabhu3333@gmail.com")
                .firstName("aaaaaPrabhuaaa")
                .lastName("Sundaram")
                .build();
                
        studentRepository.save(student2);

        Student student3 = Student.builder()
                .email("prabhu33455@gmail.com")
                .firstName("Prabhubbbb")
                .lastName("Sundaram")
                .build();                

        studentRepository.save(student3);
    }

//    @Test
//    public void saveStudentWithGuardian() {
//
//        Guardian guardian = Guardian.builder()
//                .email("nikhil@gmail.com")
//                .name("Nikhil")
//                .mobile("9999956324")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Shivam")
//                .email("shivam@gmail.com")
//                .lastName("Kumar")
//                .guardian(guardian)
//                .build();
//
//        studentRepository.save(student);
//
//    }
    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students =
                studentRepository.findByFirstName("Prabhu");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("pr");

        System.out.println("students = " + students);
    }


    @Test
    void findByFirstNameIgnoreCase() {
        List<Student> students =
                studentRepository.findByFirstNameIgnoreCase("Prabhu");

        System.out.println("students = " + students);
    }

    @Test
    void findByFirstNameContainingIgnoreCase() {
        List<Student> students =
                studentRepository.findByFirstNameContainingIgnoreCase("pr");

        System.out.println("students = " + students);
    }


    @Test
    void findByLastName() {
        List<Student> students =
                studentRepository.findByLastName("sundaram");

        System.out.println("students = " + students);
    }

    @Test
    void findByFirstNameAndLastName() {
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("prabhu","sundaram");

        System.out.println("students = " + students);
    }

    @Test
    void findByFirstNameOrLastName() {
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("prabhu","sundaram");

        System.out.println("students = " + students);
    }

    @Test
    void findByFirstNameOrderByFirstNameDesc() {
        List<Student> students =
                studentRepository.findByFirstNameOrderByFirstNameDesc("prabhu");

        System.out.println("students = " + students);
    }


    @Test
    void findByFirstNameNot() {
        List<Student> students =
                studentRepository.findByFirstNameNot("prabhu");

        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.findByEmailAddress(
                        "shabbir@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.findFirstNameByEmailAddress(
                        "shivam@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.findByEmailAddressNative(
                        "shivam@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.findByEmailAddressNativeNamedParam(
                        "shivam@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmail(
                "shabbir dawoodi",
                "shabbir@gmail.com");
    }

    @Test
    public void findByIdTest() {
        Optional<Student> student = studentRepository.findById(1L);
        System.out.println("student = " + student);
    }    
}