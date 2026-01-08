package com.dm.springbootjpapostgresql.repository.jpa.montaji;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.montaji.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods if needed
     //List<User> findByUserName(String userName);
     Optional<User> findByUserName(String userName);

     //JPQL
     @Query("SELECT u FROM User u WHERE u.userName = :userName")
     User findSingleUserByUserName(String userName);

}
