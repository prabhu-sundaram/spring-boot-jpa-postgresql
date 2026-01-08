package com.dm.springbootjpapostgresql.repository2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.model.entity.pojo.inheritance.TablePerClass.Car;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.CarRepository;
import com.dm.springbootjpapostgresql.repository.jpa.repository2.VehicleRepository;

@SpringBootTest
public class CarRepositoryTest {

@Autowired
private CarRepository carRepository;

@Autowired
private VehicleRepository vehicleRepository;

@Test
public void testSaveCar()
{
    Car car = new Car(1, "audi", "xyz");
    carRepository.save(car);

    System.out.println("vehicles:"+vehicleRepository.findAll().size());
    System.out.println("cars:"+carRepository.findAll().size());


}
}


