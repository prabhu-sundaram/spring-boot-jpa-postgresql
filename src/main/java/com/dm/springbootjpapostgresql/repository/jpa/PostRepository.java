package com.dm.springbootjpapostgresql.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Long categoryId);
}
