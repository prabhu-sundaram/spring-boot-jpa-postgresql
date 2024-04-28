package com.dm.springbootjpapostgresql.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateRequestDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateResponseDto;
import com.dm.springbootjpapostgresql.model.montaji.Nationality;
import com.dm.springbootjpapostgresql.model.montaji.User;
import com.dm.springbootjpapostgresql.repository.montaji.NationalityRepository;
import com.dm.springbootjpapostgresql.repository.montaji.UserRepository;
import com.dm.springbootjpapostgresql.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NationalityRepository nationalityRepository;   
    
    @Autowired
    UserService userService;
    @Autowired
    private HttpServletRequest request;    

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // public ResponseEntity<User> createUser(@RequestBody User user) {
    //     User createdUser = userRepository.save(user);
    //     return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    // }
    @PostMapping    
    public ResponseEntity<UserCreateResponseDto> createUser(@RequestBody UserCreateRequestDto userCreateRequestDto) {
        System.out.println("Inside createUser controller");

        // Access the request headers
        String contentType = request.getHeader("Content-Type");
        String accept = request.getHeader("Accept");
        String method = request.getMethod();

        // Log the headers and potentially the body using a logger
        logger.info("Request received: Content-Type={}, Accept={}, Method={}", contentType, accept,method);


        UserCreateResponseDto userCreateResponseDto = userService.createUser(userCreateRequestDto);
        System.out.println("After calling createUser service");
        try {
            return new ResponseEntity<>(userCreateResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }    

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            user.setUserId(id);
            User updatedUser = userRepository.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
