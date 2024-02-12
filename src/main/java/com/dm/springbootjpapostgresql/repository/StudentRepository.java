package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dm.springbootjpapostgresql.model.Student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);    
    List<Student> findByLastName(String lastName);
    //List<Student> findByGuardianName(String guardianName);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrderByFirstNameDesc(String firstName);
    List<Student> findByFirstNameIgnoreCase(String firstName);
    List<Student> findByFirstNameNot(String firstName);
    List<Student> findByEmail(String email);

    //JPQL
    @Query("select s from Student s where s.email=?1")
    Student findByEmailAddress(String email);

    //JPQL
    @Query("select s.firstName from Student s where s.email=?1")
    String findFirstNameByEmailAddress(String email);

    //Native
    @Query(
        value="select * from tbl_student s where s.email_address=?1"
        ,nativeQuery = true
    )
    Student findByEmailAddressNative(String email);

    //Native Named Param
    @Query(
        value="select * from tbl_student s where s.email_address=:email"
        ,nativeQuery = true
    )
    Student findByEmailAddressNativeNamedParam(@Param("email") String email);    

    @Modifying
    @Transactional
    @Query(
        value="update tbl_student s set s.first_name=:firstName where s.email_address=:email"
        ,nativeQuery = true
    )
    int updateStudentNameByEmail(@Param("firstName") String firstName,@Param("email") String email);

}