package com.dm.springbootjpapostgresql.repository.jpa.repository2;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dm.springbootjpapostgresql.model.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.hypersistence.utils.spring.repository.BaseJpaRepository;

@Repository
//public interface ForumRepository extends BaseJpaRepository<Post, Long> {
public interface ForumRepository extends JpaRepository<Post, Long> {
   
    @Query("""
        select p
        from Post p
        join fetch p.comments
        where p.id = :postId
        """)
    Optional<Post> findWithCommentsById(
        @Param("postId") Long postId
    );
}
