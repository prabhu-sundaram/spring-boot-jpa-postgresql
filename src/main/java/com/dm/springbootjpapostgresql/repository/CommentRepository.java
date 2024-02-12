package com.dm.springbootjpapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.springbootjpapostgresql.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}