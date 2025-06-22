package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.model.User4;
import com.dm.springbootjpapostgresql.repository.User4Repository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class User4Service {
    private final User4Repository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public User4Service(User4Repository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public User4 register(User4 user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(User4 user) {

//        User u = userRepository.findByUserName(user.getUserName());
//
//        if(Objects.nonNull(u))
//            //return "success";
//            return "1234567890";
//        else
//            return "failure";

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(), user.getPassword()
                )
        );

        if(authenticate.isAuthenticated())
            //return "1234567890";
            return jwtService.generateToken(user);
        else
            return "failure";

    }
}
