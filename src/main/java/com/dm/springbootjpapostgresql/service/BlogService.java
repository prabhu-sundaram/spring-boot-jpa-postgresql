package com.dm.springbootjpapostgresql.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.repository.jpa.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dm.springbootjpapostgresql.dto.CommentDto;


public interface BlogService {

    // Get Category Name (Primitive Out Parameter)
    public String fetchCategoryName(Long id);

    // 1. Get All Posts (Mapping Map to DTO)
    public List<PostDto> getAllPosts();

    // 2. Create Post
    public Long createNewPost(PostDto postDto);

    // 3. Update Category via JSON
    public void updateCategory(CategoryDto categoryDto);

    // 4. Get Comments by Post ID
    public List<CommentDto> getCommentsByPostId(Long postId);
  
}
