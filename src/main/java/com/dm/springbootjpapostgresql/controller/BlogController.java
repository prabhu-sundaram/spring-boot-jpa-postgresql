package com.dm.springbootjpapostgresql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dm.springbootjpapostgresql.service.BlogService;
import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.CommentDto;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // 2. GET: Fetch category name by ID (Primitive OUT param example)
    @GetMapping("/category/{id}/name")
    public ResponseEntity<String> getCategoryName(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.fetchCategoryName(id));
    }    

    // 1. GET: Fetch all posts (Returns List<PostDto>)
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(blogService.getAllPosts());
    }

    // 3. POST: Create a new post (Returns the new ID)
    @PostMapping("/posts")
    public ResponseEntity<Long> createPost(@RequestBody PostDto postDto) {
        Long id = blogService.createNewPost(postDto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    // 4. PUT: Update category using JSON (JSON Input example)
    @PutMapping("/category")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDto categoryDto) {
        blogService.updateCategory(categoryDto);
        return ResponseEntity.noContent().build();
    }

    // 5. GET: Get comments by post (Ref Cursor with Filter example)
    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPost(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getCommentsByPostId(id));
    }
}
