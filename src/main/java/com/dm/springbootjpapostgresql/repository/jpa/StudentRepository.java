package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.Student;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

    //Student findById(Long id);
// save() – to persist entities into the database
// findById() – to find database record by its id
// findAll() – to get all entities
// findAll(Sort) 
// findById() – to get an entity by its id.

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameIs(String firstName);
    List<Student> findByFirstNameEquals(String firstName);
    List<Student> findByFirstNameStartingWith(String prefix);
    List<Student> findByFirstNameEndingWith(String suffix);        
    List<Student> findByFirstNameIgnoreCase(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByFirstNameLike(String likePattern);    
    List<Student> findByFirstNameNot(String firstName);
    List<Student> findByFirstNameIsNot(String firstName);
    List<Student> findByFirstNameIsNull();
    List<Student> findByFirstNameIsNotNull();

    List<Student> findByFirstNameOrderByFirstName(String name);
    List<Student> findByFirstNameOrderByFirstNameAsc(String name);    
    List<Student> findByFirstNameOrderByFirstNameDesc(String firstName);

    List<Student> findByLastName(String lastName);
    //List<Student> findByGuardianName(String guardianName);


    List<Student> findByEmail(String email);

    List<Student> findByStatus(Integer status);

    List<Student> findByActiveTrue();
    List<Student> findByActiveFalse();    

    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByAgeLessThanEqual(Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeGreaterThanEqual(Integer age);
    List<Student> findByAgeBetween(Integer startAge, Integer endAge);
    List<Student> findByAgeIn(Collection<Integer> ages);
    List<Student> findByBirthDateAfter(LocalDate birthDate);
    List<Student> findByBirthDateBefore(LocalDate birthDate);

    List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrAge(String name, Integer age);
    List<Student> findByFirstNameOrAgeAndActive(String name, Integer age, Boolean active);

    //JPQL
    @Query(value = "SELECT s FROM Student s")
    List<Student> findAllStudents();

    @Query(value = "SELECT s FROM Student s")
    List<Student> findAllStudentsSorted(Sort sort);

    @Query(value = "SELECT s FROM Student s ORDER BY studentId")
    Page<Student> findAllStudentsWithPagination(Pageable pageable);

    @Query("select s from Student s where s.email=?1")
    List<Student> findByEmailAddress(String email);

    @Query("SELECT s FROM Student s WHERE s.status = ?1")
    List<Student> findStudentByStatus(Integer status);

    @Query("SELECT s FROM Student s WHERE s.active = true")
    List<Student> findAllActiveStudents();

    @Query("SELECT s FROM Student s WHERE UPPER(s.firstName) LIKE UPPER(?1)")
    List<Student> findByFirstNameContainingIgnoreCase2(String firstName);  

    @Query("select s.firstName from Student s where s.email=?1")
    String findFirstNameByEmailAddress(String email);

    @Query("SELECT s FROM Student s WHERE s.status = ?1 and s.firstName = ?2")
    List<Student> findStudentByStatusAndFirstName(Integer status, String firstName);

    @Query("SELECT s FROM Student s WHERE s.status = :status and s.firstName = :firstName")
    List<Student> findStudentByStatusAndFirstNameNamedParams(
    @Param("status") Integer status, 
    @Param("firstName") String firstName);

    @Query("SELECT s FROM Student s WHERE s.status = :status and s.firstName = :firstName")
    List<Student> findStudentByStudentStatusAndFirstName(
    @Param("status") Integer studentStatus, 
    @Param("firstName") String firstName);

    @Query(value = "SELECT s FROM Student s WHERE s.firstName IN :firstNames")
    List<Student> findStudentByFirstNameList(@Param("firstNames") Collection<String> firstNames);    

    //Modifying
    @Modifying
    @Transactional
    @Query("update Student s set s.status = :status where s.firstName = :firstName")
    int updateStudentSetStatusForFirstName(@Param("status") Integer status, 
    @Param("firstName") String firstName);

    //Native
    @Query(
    value = "SELECT * FROM tbl_student u WHERE u.active = true", 
    nativeQuery = true)
    List<Student> findAllActiveStudentsNative();

    //Native--Indexed param
    @Query(
    value = "select * from tbl_student s where s.status = ?1", 
    nativeQuery = true)
    List<Student> findStudentByStatusNative(Integer status);

    @Query(
        value="select * from tbl_student s where s.email_address=?1"
        ,nativeQuery = true
    )
    Student findByEmailAddressNative(String email);

    //Native--Named Param
    @Query(
        value="select * from tbl_student s where s.email_address=:email"
        ,nativeQuery = true
    )
    Student findByEmailAddressNativeNamedParam(@Param("email") String email);    

    @Query(
    value = "SELECT * FROM tbl_student ORDER BY id", 
    countQuery = "SELECT count(*) FROM tbl_student", 
    nativeQuery = true)
    Page<Student> findAllStudentsWithPaginationNative(Pageable pageable);

    @Query(value = "SELECT * FROM tbl_student s WHERE s.status = :status and s.firstName = :firstName", 
    nativeQuery = true)
    List<Student> findStudentByStatusAndNameNamedParamsNative(
    @Param("status") Integer status, @Param("firstName") String firstName);

    //Modifying
    @Modifying
    @Transactional
    @Query(
        value="update tbl_student s set s.first_name=:firstName where s.email_address=:email"
        ,nativeQuery = true
    )
    int updateStudentNameByEmail(@Param("firstName") String firstName,@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student s set s.status = :status where s.firstName = :firstName", 
    nativeQuery = true)
    int updateStudentSetStatusForNameNative(@Param("status") Integer status, @Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(
    value = 
    "insert into tbl_student (first_name,last_name, age, birth_date, email_address, status, active) values (:firstName, :lastName, :age, :birthDate, :email, :status, :active)"
    ,nativeQuery = true)
    void insertUser(
        @Param("firstName") String firstName, 
        @Param("lastName") String lastName,
        @Param("age") Integer age, 
        @Param("birthDate") LocalDate birthDate, 
        @Param("email") String email,
        @Param("status") Integer status, 
        @Param("active") Boolean active
    );

}
