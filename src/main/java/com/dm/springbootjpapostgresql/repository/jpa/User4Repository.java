package com.dm.springbootjpapostgresql.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.dm.springbootjpapostgresql.model.entity.User4;

@Controller
public interface User4Repository extends JpaRepository<User4,Integer> {

    User4 findByUserName(String userName);

}
