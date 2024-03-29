package com.dm.springbootjpapostgresql.service;

import java.util.List;

import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostRecord;
import com.dm.springbootjpapostgresql.dto.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostsByCategory(Long categoryId);
}
