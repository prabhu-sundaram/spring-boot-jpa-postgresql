package com.dm.springbootjpapostgresql.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.CommentDto;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.model.Category;
import com.dm.springbootjpapostgresql.model.Comment;
import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.repository.CategoryRepository;

@Component
public class PostMapper {
 
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;
    /* 
    // Private constructor to prevent instantiation
    private PostMapper() {
        // private constructor to hide the implicit public one
    }*/

    // convert Entity into DTO
    public PostDto mapToDTO(Post post){
        //PostDto postDto = modelMapper.map(post, PostDto.class);
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setCategoryId(post.getCategory().getId());
        postDto.setComments(post.getComments().stream()
                .map(comment -> {
                    CommentDto commentDto = new CommentDto();
                    commentDto.setId(comment.getId());
                    commentDto.setName(comment.getName());
                    commentDto.setEmail(comment.getEmail());
                    commentDto.setBody(comment.getBody());                    
                    return commentDto;
                })
                .collect(Collectors.toList()));
        return postDto;
    }

    // convert DTO to entity
    public Post mapToEntity(PostDto postDto){
        //Post post = modelMapper.map(postDto, Post.class);
        //List<Comment> comments = modelMapper.mapCollection(postDto.getComments(), Comment.class);
        //post.setComments(comments); 

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());       
        if(postDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(postDto.getCategoryId()).orElse(null);
            post.setCategory(category);
        };        
        post.setComments(postDto.getComments().stream()
                .map(commentDto -> {
                    Comment comment = new Comment();
                    comment.setId(commentDto.getId());
                    comment.setName(commentDto.getName());
                    comment.setEmail(commentDto.getEmail());
                    comment.setBody(commentDto.getBody());                    
                    comment.setPost(post);
                    return comment;
                }).collect(Collectors.toList()));
        return post;
    }

}
