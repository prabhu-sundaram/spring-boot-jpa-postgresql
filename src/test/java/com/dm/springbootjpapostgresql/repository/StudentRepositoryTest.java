package com.dm.springbootjpapostgresql.repository;

import com.dm.springbootjpapostgresql.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("prabhu3333445555@gmail.com")
                .firstName("Prabhu")
                .lastName("Sundaram")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
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
                studentRepository.findByFirstName("shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");

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
    void findByFirstNameIgnoreCase() {
        List<Student> students =
                studentRepository.findByFirstNameIgnoreCase("prabhu");

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
}