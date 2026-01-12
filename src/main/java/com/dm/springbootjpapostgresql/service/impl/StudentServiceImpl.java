package com.dm.springbootjpapostgresql.service.impl;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of("studentId", "firstName", "age");

    @Override
    public StudentDTO getStudentById(long id)
    {
        Student student = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student","id",id));
        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents()
    {
        //LOGGER.info("Getting all students");
        List<Student> students=studentRepository.findAll();
        //List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        //LOGGER.info("All students:"+studentsDTO);
        return studentMapper.toDTOs(students);
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

        // student.setFirstName(studentDTO.getFirstName());
        // student.setLastName(studentDTO.getLastName());
        // if (studentDTO.getAge() != null) {
        //     student.setAge(studentDTO.getAge());
        // }
        // if (studentDTO.getBirthDate() != null && !studentDTO.getBirthDate().isEmpty()) {
        //         // This parses ISO-8601 strings (e.g., "2024-05-20T10:15:30+01:00")
        //         ZonedDateTime parsedDate = ZonedDateTime.parse(studentDTO.getBirthDate());
        //         student.setBirthDate(parsedDate);
        //     }        
        // student.setEmail(studentDTO.getEmail());
        // if (studentDTO.getStatus() != null) {
        //     student.setStatus(studentDTO.getStatus());
        // }
        // if(studentDTO.getActive() != null){
        //     student.setActive(studentDTO.getActive()); 
        // }       

        studentMapper.updateStudentFromDto(studentDTO, student);

        Student updatedStudent=studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    @Override
    public boolean checkStudentExists(long id)
    {
        return studentRepository.existsById(id);
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
        if (!ALLOWED_SORT_FIELDS.contains(sortBy)) {
            throw new IllegalArgumentException("Invalid sort field: " + sortBy);
        }
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        // Page<Student> students = studentRepository.findAll(pageable);

        // // get content for page object
        // List<Student> listOfStudents = students.getContent();

        // List<StudentDTO> content= listOfStudents.stream().map(student -> studentMapper.toDTO(student)).collect(Collectors.toList());

        // StudentResponse studentResponse = new StudentResponse();
        // studentResponse.setContent(content);
        // studentResponse.setPageNo(students.getNumber());
        // studentResponse.setPageSize(students.getSize());
        // studentResponse.setTotalElements(students.getTotalElements());
        // studentResponse.setTotalPages(students.getTotalPages());
        // studentResponse.setLast(students.isLast());

        // return studentResponse;
        Page<Student> page = studentRepository.findAll(pageable);
        return studentMapper.toStudentResponse(page);

    }

    @Override
    public List<StudentDTO> getStudentsByFirstName(String firstName)
    {
        List<Student> students=studentRepository.findByFirstName(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }   

    @Override
    public List<StudentDTO> getStudentsByFirstNameIs(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameIs(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameEquals(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameEquals(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameStartingWith(String prefix)
    {
        List<Student> students=studentRepository.findByFirstNameStartingWith(prefix);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameEndingWith(String suffix)
    {
        List<Student> students=studentRepository.findByFirstNameEndingWith(suffix);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameIgnoreCase(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameIgnoreCase(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }
        
    @Override
    public List<StudentDTO> getStudentsByFirstNameContaining(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameContaining(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }       

    @Override
    public List<StudentDTO> getStudentsByFirstNameContainingIgnoreCase(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameContainingIgnoreCase(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameLike(String likePattern)
    {
        List<Student> students=studentRepository.findByFirstNameLike(likePattern);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    } 

    @Override
    public List<StudentDTO> getStudentsByFirstNameNot(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameNot(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameIsNot(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameIsNot(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameIsNull()
    {
        List<Student> students=studentRepository.findByFirstNameIsNull();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameIsNotNull()
    {
        List<Student> students=studentRepository.findByFirstNameIsNotNull();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameOrderByFirstName(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameOrderByFirstName(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameOrderByFirstNameAsc(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameOrderByFirstNameAsc(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }  
    
    @Override
    public List<StudentDTO> getStudentsByFirstNameOrderByFirstNameDesc(String firstName)
    {
        List<Student> students=studentRepository.findByFirstNameOrderByFirstNameDesc(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByLastName(String lastName)
    {
        List<Student> students=studentRepository.findByLastName(lastName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByLastNameNotNull(String lastName)
    {
        List<Student> students=studentRepository.findByLastName(lastName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }     

    @Override
    public List<StudentDTO> getStudentsByEmail(String email)
    {
        List<Student> students=studentRepository.findByEmail(email);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByStatus(Integer status)
    {
        List<Student> students=studentRepository.findByStatus(status);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByActiveTrue()
    {
        List<Student> students=studentRepository.findByActiveTrue();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByActiveFalse()
    {
        List<Student> students=studentRepository.findByActiveFalse();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }    

    @Override
    public List<StudentDTO> getStudentsByAgeLessThan(Integer age)
    {
        List<Student> students=studentRepository.findByAgeLessThan(age);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByAgeLessThanEqual(Integer age)
    {
        List<Student> students=studentRepository.findByAgeLessThanEqual(age);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByAgeGreaterThan(Integer age)
    {
        List<Student> students=studentRepository.findByAgeGreaterThan(age);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByAgeGreaterThanEqual(Integer age)
    {
        List<Student> students=studentRepository.findByAgeGreaterThanEqual(age);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByAgeBetween(Integer startAge, Integer endAge)
    {
        List<Student> students=studentRepository.findByAgeBetween(startAge, endAge);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByAgeIn(Collection<Integer> ages)
    {
        List<Student> students=studentRepository.findByAgeIn(ages);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByBirthDateAfter(ZonedDateTime birthDate)
    {
        List<Student> students=studentRepository.findByBirthDateAfter(birthDate);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByBirthDateBefore(ZonedDateTime birthDate)
    {
        List<Student> students=studentRepository.findByBirthDateBefore(birthDate);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameAndLastName(String firstName,String lastName)
    {
        List<Student> students=studentRepository.findByFirstNameAndLastName(firstName,lastName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameOrLastName(String firstName,String lastName)
    {
        List<Student> students=studentRepository.findByFirstNameOrLastName(firstName,lastName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameOrAge(String name, Integer age)
    {
        List<Student> students=studentRepository.findByFirstNameOrAge(name,age);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameOrAgeAndActive(String name, Integer age, Boolean active)
    {
        List<Student> students=studentRepository.findByFirstNameOrAgeAndActive(name,age,active);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    //JPQL
    @Override
    public List<StudentDTO> getAllStudents2()
    {
        List<Student> students=studentRepository.findAllStudents();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getAllStudentsSorted(Sort sort)
    {
        List<Student> students=studentRepository.findAllStudentsSorted(sort);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public StudentResponse getAllStudentsWithPagination(Pageable pageable)
    {
        Page<Student> page = studentRepository.findAllStudentsWithPagination(pageable);
        return studentMapper.toStudentResponse(page);
    }

    @Override
    public StudentDTO getStudentByEmailAddress(String email)
    {
        List<Student> students=studentRepository.findByEmailAddress(email);
        if(students!=null && !students.isEmpty())
        {
            return studentMapper.toDTO(students.get(0));
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudentsByStatus(Integer status)
    {
        List<Student> students=studentRepository.findStudentByStatus(status);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getAllActiveStudents()
    {
        List<Student> students=studentRepository.findAllActiveStudents();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByFirstNameContainingIgnoreCase2(String firstName)  
    {
        List<Student> students=studentRepository.findByFirstNameContainingIgnoreCase2(firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }  

    @Override
    public StudentDTO getStudentFirstNameByEmailAddress(String email)
    {
        String firstName=studentRepository.findFirstNameByEmailAddress(email);
        return studentMapper.toDTO(new Student().builder().firstName(firstName).build());
    }

    @Override
    public List<StudentDTO> getStudentsByStatusAndFirstName(Integer status, String firstName)
    {
        List<Student> students=studentRepository.findStudentByStatusAndFirstName(status, firstName);
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByStatusAndFirstNameNamedParams(Integer status, String firstName)
    {
        List<Student> students=studentRepository.findStudentByStatusAndFirstNameNamedParams(status, firstName);
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getStudentsByStudentStatusAndFirstName(Integer studentStatus, String firstName)
    {
        List<Student> students=studentRepository.findStudentByStudentStatusAndFirstName(studentStatus, firstName);
        return studentMapper.toDTOs(students);
    }

    @Override
    public List<StudentDTO> getAllStudentsByFirstNameList(Collection<String> firstNames)    
    {
        List<Student> students=studentRepository.findStudentByFirstNameList(firstNames);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }
    
    @Override
    public int updateStudentStatusByFirstName(Integer status, String firstName)
    {
        return studentRepository.updateStudentSetStatusForFirstName(status, firstName);
    }
	
	//Native
    @Override
    public List<StudentDTO> getAllActiveStudentsNative()
    {
        List<Student> students=studentRepository.findAllActiveStudentsNative();
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);

    }

    @Override
    public List<StudentDTO> getAllStudentsByStatusNative(Integer status)
    {
        List<Student> students=studentRepository.findStudentByStatusNative(status);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public StudentDTO getStudentByEmailAddressNative(String email)
    {
        Student student=studentRepository.findByEmailAddressNative(email);
        return studentMapper.toDTO(student);
    }

    @Override
    public StudentDTO getStudentByEmailAddressNativeNamedParam(String email)    
    {
        Student student=studentRepository.findByEmailAddressNativeNamedParam(email);
        return studentMapper.toDTO(student);
    }   

    // @Override
    // public Page<StudentDTO> getAllStudentsWithPaginationNative(Pageable pageable)
    // {
    //     return studentRepository.findAllStudentsWithPaginationNative(pageable).map(studentMapper::toDTO);
    // }
    @Override
    public StudentResponse getAllStudentsWithPaginationNative(Pageable pageable)
    {
        Page<Student> page = studentRepository.findAllStudentsWithPaginationNative(pageable);
        return studentMapper.toStudentResponse(page);        
    }

    @Override
    public List<StudentDTO> getAllStudentsByStatusAndNameNamedParamsNative(Integer status, String firstName)
    {
        List<Student> students=studentRepository.findStudentByStatusAndNameNamedParamsNative(status, firstName);
        // List<StudentDTO> studentsDTO=students.stream().map(student->studentMapper.toDTO(student)).collect(Collectors.toList());
        // return studentsDTO;
        return studentMapper.toDTOs(students);
    }

    @Override
    public int updateStudentNameByEmail(String firstName, String email)
    {
        return studentRepository.updateStudentNameByEmail(firstName, email);
    }

    @Override
    public int updateStudentStatusByNameNative(Integer status, String firstName)
    {
        return studentRepository.updateStudentSetStatusForNameNative(status, firstName);
    }

    @Override
    public void insertUser(String firstName,String lastName,Integer age,ZonedDateTime birthDate,
        String email,Integer status,Boolean active)
    {
        studentRepository.insertUser(firstName, lastName, age, birthDate, email, status, active);
    }    
}
