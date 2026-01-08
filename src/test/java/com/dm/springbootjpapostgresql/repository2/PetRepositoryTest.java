package com.dm.springbootjpapostgresql.repository2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.JoinedTable.Pet;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.PetRepository;

@SpringBootTest 
public class PetRepositoryTest {

@Autowired
private PetRepository petRepository;

@Test
public void savePet()
{
    Pet pet = new Pet(1, "dog", "lassie");
    petRepository.save(pet);

}
}
