package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.entity.Category;
import com.dm.springbootjpapostgresql.model.entity.Comment;
import com.dm.springbootjpapostgresql.model.entity.Post;

import java.time.OffsetDateTime;
import java.util.List;

public record PostRecord(
    Long id,
    String title,
    String description,
    String content,
    List<CommentRecord> comments,
    Long categoryId,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
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