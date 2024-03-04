package com.dm.springbootjpapostgresql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.springbootjpapostgresql.dto.PostRecord;
import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.repository.PostRepository2;
import com.dm.springbootjpapostgresql.service.ForumService;

@Service
@Transactional(readOnly = true)
public class ForumServiceImpl implements ForumService {
 
    private PostRepository2 postRepository;
 
    public ForumServiceImpl(@Autowired PostRepository2 postRepository) {
        this.postRepository = postRepository;
    }
 
    public PostRecord findPostRecordById(Long postId) {
        return postRepository
            .findWithCommentsById(postId)
            .map(Post::toRecord)
            .orElse(null);
    }
  
    @Transactional
    public PostRecord insertPostRecord(PostRecord postRecord) {
        return postRepository.persist(postRecord.toPost()).toRecord();
    }
  
    // @Transactional
    // public PostRecord mergePostRecord(PostRecord postRecord) {
    //     return postRepository.merge(postRecord.toPost()).toRecord();
    // }
}