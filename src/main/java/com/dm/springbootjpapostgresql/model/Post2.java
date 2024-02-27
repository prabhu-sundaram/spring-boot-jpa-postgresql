package com.dm.springbootjpapostgresql.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Post2 {
    private String postId;
    private String content;
    private String title;
    private Set<String> tags = new HashSet<>();
    private Integer views;
}
