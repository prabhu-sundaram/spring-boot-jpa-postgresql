package com.dm.springbootjpapostgresql.service.impl;

import org.springframework.stereotype.Service;

import com.dm.springbootjpapostgresql.repository.jpa.BlogRepository;
import com.dm.springbootjpapostgresql.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.CommentDto;

@Service // This is what tells Spring to create the "Bean"
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final ObjectMapper objectMapper; // For JSON conversion

    // Spring finds this constructor and automatically "wires" the dependencies
    public BlogServiceImpl(BlogRepository blogRepository, ObjectMapper objectMapper) {
        this.blogRepository = blogRepository;
        this.objectMapper = objectMapper;
    }

    // Get Category Name (Primitive Out Parameter)
    public String fetchCategoryName(Long id) {
        // We will add this method to the repository in the next step
        return blogRepository.getCategoryName(id);
    }

    // 1. Get All Posts (Mapping Map to DTO)
    public List<PostDto> getAllPosts() {
        List<Map<String, Object>> rows = blogRepository.getAllPosts();
        // return rows.stream().map(row -> new PostDto(
        //     ((Number) row.get("ID")).longValue(),
        //     (String) row.get("TITLE"),
        //     (String) row.get("DESCRIPTION"),
        //     (String) row.get("CONTENT"),
        //     row.get("CATEGORY_ID") != null ? ((Number) row.get("CATEGORY_ID")).longValue() : null
        // )).collect(Collectors.toList());

        return rows.stream().map(row -> {
            PostDto dto = new PostDto();
            dto.setId(((Number) row.get("ID")).longValue());
            dto.setTitle((String) row.get("TITLE"));
            dto.setDescription((String) row.get("DESCRIPTION"));
            dto.setContent((String) row.get("CONTENT"));
            dto.setCategoryId(row.get("CATEGORY_ID") != null ? ((Number) row.get("CATEGORY_ID")).longValue() : null);
            dto.setCreatedAt(convertToOffsetDateTime(row.get("CREATED_AT")));
            dto.setUpdatedAt(convertToOffsetDateTime(row.get("UPDATED_AT")));            
            return dto;
    }).collect(Collectors.toList());        
    }

    // 2. Create Post
    @Transactional
    public Long createNewPost(PostDto postDto) {
        return blogRepository.createPost(
            postDto.getTitle(), 
            postDto.getDescription(), 
            postDto.getContent(), 
            postDto.getCategoryId()
        );
    }

    // 3. Update Category via JSON
    @Transactional
    public void updateCategory(CategoryDto categoryDto) {
        try {
            // Convert DTO to JSON String for the Procedure
            String jsonInput = objectMapper.writeValueAsString(categoryDto);
            blogRepository.updateCategoryViaJson(jsonInput);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Category to JSON", e);
        }
    }

    // 4. Get Comments by Post ID
    public List<CommentDto> getCommentsByPostId(Long postId) {
        List<Map<String, Object>> rows = blogRepository.getCommentsByPost(postId);

        // return rows.stream().map(row -> new CommentDto(
        //     ((Number) row.get("ID")).longValue(),
        //     (String) row.get("BODY"),
        //     (String) row.get("EMAIL"),
        //      (String) row.get("NAME")
        //     // ((Number) row.get("POST_ID")).longValue()
        // )).collect(Collectors.toList());

        return rows.stream().map(row -> {
            CommentDto dto = new CommentDto();
            dto.setId(((Number) row.get("ID")).longValue());
            dto.setBody((String) row.get("BODY"));
            dto.setEmail((String) row.get("EMAIL"));
            dto.setName((String) row.get("NAME"));
            //dto.setPostId(((Number) row.get("POST_ID")).longValue());
            dto.setCreatedAt(convertToOffsetDateTime(row.get("CREATED_AT")));
            dto.setUpdatedAt(convertToOffsetDateTime(row.get("UPDATED_AT")));             
            return dto;
        }).collect(Collectors.toList());
    }

    // Helper method to handle the conversion safely
    private OffsetDateTime convertToOffsetDateTime(Object obj) {
        if (obj == null) return null;
        
        if (obj instanceof OffsetDateTime) {
            return (OffsetDateTime) obj;
        } else if (obj instanceof Timestamp) {
            return ((Timestamp) obj).toInstant().atOffset(java.time.ZoneOffset.UTC);
        } 
        // else if (obj instanceof oracle.sql.TIMESTAMPTZ) {
        //     // Some older OJDBC drivers return this specific Oracle type
        //     try {
        //         return ((oracle.sql.TIMESTAMPTZ) obj).offsetDateTimeValue();
        //     } catch (Exception e) {
        //         return null;
        //     }
        // }
        return null;
    }    
}
