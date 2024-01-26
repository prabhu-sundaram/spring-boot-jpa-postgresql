package com.dm.springbootjpapostgresql.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.dm.springbootjpapostgresql.model.Administration.Nationality;
import com.dm.springbootjpapostgresql.repository.NationalityRepository;

@RestController
@RequestMapping("/api/nationality")
public class NationalityController {

    @Autowired
    private NationalityRepository nationalityRepository;

    @GetMapping
    public List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nationality> getNationalityById(@PathVariable Long id) {
        Nationality nationality = nationalityRepository.findById(id).orElse(null);
        if (nationality != null) {
            return new ResponseEntity<>(nationality, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Nationality> createNationality(@RequestBody Nationality nationality) {
        Nationality createdNationality = nationalityRepository.save(nationality);
        return new ResponseEntity<>(createdNationality, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nationality> updateNationality(@PathVariable Long id, @RequestBody Nationality nationality) {
        Nationality existingNationality = nationalityRepository.findById(id).orElse(null);
        if (existingNationality != null) {
            nationality.setNationalityId(id);
            Nationality updatedNationality = nationalityRepository.save(nationality);
            return new ResponseEntity<>(updatedNationality, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNationality(@PathVariable Long id) {
        Nationality existingNationality = nationalityRepository.findById(id).orElse(null);
        if (existingNationality != null) {
            nationalityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
