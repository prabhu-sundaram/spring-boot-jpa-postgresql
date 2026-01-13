package com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    private Long animalId;

    private String species;
    
    public Animal() {}    

    public Animal(Long animalId, String species) {
        this.animalId = animalId;
        this.species = species;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
