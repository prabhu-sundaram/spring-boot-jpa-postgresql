package com.dm.springbootjpapostgresql.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {
@GetMapping
    public String getDemo()
    {
        return("Hello world");
    }

    @GetMapping("csrf")
    public CsrfToken getToken(HttpServletRequest request){
return (CsrfToken) request.getAttribute("_csrf");
    }
}
