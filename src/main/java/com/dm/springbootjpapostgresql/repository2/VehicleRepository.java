package com.dm.springbootjpapostgresql.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.pojo.inheritance.TablePerClass.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
    
}
