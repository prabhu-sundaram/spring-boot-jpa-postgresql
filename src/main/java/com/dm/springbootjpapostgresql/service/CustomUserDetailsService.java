package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.service.CustomUserDetails;
import com.dm.springbootjpapostgresql.model.User4;
import com.dm.springbootjpapostgresql.repository.User4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    User4Repository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User4 user = userRepository.findByUserName(username);
        if(Objects.isNull(user))
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
