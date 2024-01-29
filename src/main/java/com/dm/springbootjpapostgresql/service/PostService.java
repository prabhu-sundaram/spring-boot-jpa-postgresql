package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
