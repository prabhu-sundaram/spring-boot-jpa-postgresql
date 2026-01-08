package com.dm.springbootjpapostgresql.controller;

import com.dm.springbootjpapostgresql.model.entry.LdapUser;
import com.dm.springbootjpapostgresql.repository.ldap.LdapUserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/LDAPUsers")
public class LdapUserController {

    @Autowired
    private LdapUserRepository userRepo;

    @Operation(summary = "Add a new User entry")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User successfully inserted."),
        @ApiResponse(responseCode = "409", description = "User already exists."),
        @ApiResponse(responseCode = "500", description = "Unknown error.")
    })
    @PostMapping
    public void addUser(@Valid @RequestBody LdapUser user) {
        System.out.println("ldap user: " + user.getCn() + " " + user.getUid());
        userRepo.addUser(user);
    }

    @Operation(summary = "Get a User entry by its uid")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User successfully found."),
        @ApiResponse(responseCode = "404", description = "User not found."),
        @ApiResponse(responseCode = "500", description = "Unknown error.")
    })
    @GetMapping("/{uid}")
    public LdapUser getUser(@PathVariable String uid) {
        return userRepo.getUser(uid);
    }

    @Operation(summary = "Get all User entries")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully returned all entries."),
        @ApiResponse(responseCode = "500", description = "Unknown error.")
    })
    @GetMapping
    public List<LdapUser> getUsers() {
        return userRepo.getUsers();
    }

    @Operation(summary = "Delete a User by its uid")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "User successfully deleted."),
        @ApiResponse(responseCode = "404", description = "User not found."),
        @ApiResponse(responseCode = "500", description = "Unknown error.")
    })
    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable String uid) {
        userRepo.delete(uid);
    }
}