package com.dm.springbootjpapostgresql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.springbootjpapostgresql.dto.PostRecord;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.model.Category;
import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.repository2.ForumRepository;
import com.dm.springbootjpapostgresql.service.ForumService;

@Service
@Transactional(readOnly = true)
public class ForumServiceImpl implements ForumService {
 
    private ForumRepository postRepository;
 
    public ForumServiceImpl(@Autowired ForumRepository postRepository) {
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
        //return postRepository.persist(postRecord.toPost()).toRecord();
        return postRepository.save(postRecord.toPost()).toRecord();
    }
  
    // @Transactional
    // public PostRecord mergePostRecord(PostRecord postRecord) {
    //     return postRepository.merge(postRecord.toPost()).toRecord();
    // }

    @Transactional
    public PostRecord updatePostRecord(PostRecord postRecord) {

        Post post = postRepository.findById(postRecord.id()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postRecord.id()));
        post.setTitle(postRecord.title());
        post.setDescription(postRecord.description());
        post.setContent(postRecord.content());
        //post.setComments(null);
        Post updatedPost = postRepository.save(post);    
        return updatedPost.toRecord();
    }

}