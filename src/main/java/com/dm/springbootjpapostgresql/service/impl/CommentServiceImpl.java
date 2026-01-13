package com.dm.springbootjpapostgresql.service.impl;

import com.dm.springbootjpapostgresql.model.entity.Comment;
import com.dm.springbootjpapostgresql.model.entity.Post;
import com.dm.springbootjpapostgresql.exception.BlogAPIException;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.mapper.jpa.CommentMapper;
import com.dm.springbootjpapostgresql.dto.CommentDto;
import com.dm.springbootjpapostgresql.repository.jpa.CommentRepository;
import com.dm.springbootjpapostgresql.repository.jpa.PostRepository;
import com.dm.springbootjpapostgresql.service.CommentService;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    //private ModelMapper mapper;
    @Autowired
    private CommentMapper commentMapper;

    /* 
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }*/

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {

        

        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        //Comment comment = commentMapper.mapToEntity(commentDto);
        Comment comment = commentMapper.toEntity(commentDto);
        // set post to comment entity
        comment.setPost(post);

        // comment entity to DB
        Comment newComment =  commentRepository.save(comment);

        //return commentMapper.mapToDTO(newComment);
        return commentMapper.toDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // convert list of comment entities to list of comment dto's
        //return comments.stream().map(comment -> commentMapper.mapToDTO(comment)).collect(Collectors.toList());
        return comments.stream().map(comment -> commentMapper.toDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        //return commentMapper.mapToDTO(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest) {
        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }

        // comment.setName(commentRequest.getName());
        // comment.setEmail(commentRequest.getEmail());
        // comment.setBody(commentRequest.getBody());

        commentMapper.updateCommentFromDto(commentRequest, comment);
        Comment updatedComment = commentRepository.save(comment);
        //return commentMapper.mapToDTO(updatedComment);
        return commentMapper.toDto(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }

        commentRepository.delete(comment);
    }


}
