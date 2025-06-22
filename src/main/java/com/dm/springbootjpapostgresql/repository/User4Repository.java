package com.dm.springbootjpapostgresql.repository;

import com.dm.springbootjpapostgresql.model.User4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface User4Repository extends JpaRepository<User4,Integer> {

    User4 findByUserName(String userName);

}
