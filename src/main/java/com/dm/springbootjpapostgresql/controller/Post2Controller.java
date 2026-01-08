package com.dm.springbootjpapostgresql.controller;

import com.dm.springbootjpapostgresql.model.Page;
import com.dm.springbootjpapostgresql.model.model.CategoryStats;
import com.dm.springbootjpapostgresql.service.Post2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/post2")
public class Post2Controller {

    @Autowired
    private Post2Service postService;

    @GetMapping("/search")
    public Page search(@RequestParam(name = "content", required = false) String content,
                       @RequestParam(name = "tags", required = false) Set<String> tags,
                       @RequestParam(name = "page", defaultValue = "1") Integer page) {
        return postService.search(content,tags,page);
    }

    @GetMapping("/categoryWisePost")
    public List<CategoryStats> getCategoryWiseTotalPost() {
        return postService.getCategoryWiseTotalPost();
    }
}