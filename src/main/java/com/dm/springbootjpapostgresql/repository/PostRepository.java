package com.dm.springbootjpapostgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Long categoryId);

}
