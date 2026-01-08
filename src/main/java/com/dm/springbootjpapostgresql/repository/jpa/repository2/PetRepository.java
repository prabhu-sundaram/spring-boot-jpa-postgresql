package com.dm.springbootjpapostgresql.repository.jpa.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.JoinedTable.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long>{
    
}
