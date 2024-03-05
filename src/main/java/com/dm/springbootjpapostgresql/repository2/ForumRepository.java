package com.dm.springbootjpapostgresql.repository2;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dm.springbootjpapostgresql.model.Post;

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
