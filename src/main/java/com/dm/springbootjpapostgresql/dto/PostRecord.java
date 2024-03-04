package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.model.Comment;

import java.util.List;

public record PostRecord(
    Long id,
    String title,
    String description,
    String content,
    List<CommentRecord> comments
    ) 
{
    public Post toPost() {
        // Post post = new Post()
        //     .setId(id)
        //     .setTitle(title)
        //     .setDescription(description)
        //     .setContent(content);

        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setContent(content);

        comments.forEach(
            comment -> post.addComment(comment.toComment())
        );
        return post;
    }
}