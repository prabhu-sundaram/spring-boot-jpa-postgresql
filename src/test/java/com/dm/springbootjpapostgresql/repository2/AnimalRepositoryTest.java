package com.dm.springbootjpapostgresql.repository2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.pojo.inheritance.JoinedTable.Animal;

@SpringBootTest 
public class AnimalRepositoryTest {

@Autowired
private AnimalRepository animalRepository;

@Test
public void saveAnimal()
{
    Animal animal = new Animal(2,"cat");
    animalRepository.save(animal);
}
}
