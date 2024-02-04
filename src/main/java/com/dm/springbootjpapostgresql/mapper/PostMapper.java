package com.dm.springbootjpapostgresql.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.model.Post;

@Component
public class PostMapper {
 
    @Autowired
    private ModelMapper modelMapper;
    /* 
    // Private constructor to prevent instantiation
    private PostMapper() {
        // private constructor to hide the implicit public one
    }*/

    // convert Entity into DTO
    public PostDto mapToDTO(Post post){
        PostDto postDto = modelMapper.map(post, PostDto.class);
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
        return postDto;
    }

    // convert DTO to entity
    public Post mapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return post;
    }

}
