package com.dm.springbootjpapostgresql.controller;

import com.dm.springbootjpapostgresql.model.User4;
import com.dm.springbootjpapostgresql.repository.User4Repository;
import com.dm.springbootjpapostgresql.service.User4Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")

public class User4Controller{

    private final User4Repository userRepository;

    private final User4Service userService;

    public User4Controller(User4Repository userRepository, User4Service userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User4 register(@RequestBody User4 user){
        //return userRepository.save(user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User4 user){

//        User u = userRepository.findByUserName(user.getUserName());
//
//        if(Objects.nonNull(u))
//            return "success";
//        else
//            return "failure";
        return userService.verify(user);

    }

}