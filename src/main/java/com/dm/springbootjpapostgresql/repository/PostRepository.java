package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
