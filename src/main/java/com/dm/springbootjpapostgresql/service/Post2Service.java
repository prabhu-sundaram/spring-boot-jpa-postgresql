package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.model.CategoryStats;
import com.dm.springbootjpapostgresql.model.Page;
import com.dm.springbootjpapostgresql.repository.Post2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Post2Service {

    @Autowired
    private Post2Repository postRepository;

    public Page search(String content, Set<String> tags, Integer page) {
        return postRepository.search(content,tags,page);
    }

    public List<CategoryStats> getCategoryWiseTotalPost() {
        return postRepository.getCategoryWiseTotalPost();
    }
}