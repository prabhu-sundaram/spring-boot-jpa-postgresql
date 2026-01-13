package com.dm.springbootjpapostgresql.dto;

import java.time.OffsetDateTime;

import com.dm.springbootjpapostgresql.model.entity.Comment;
import com.dm.springbootjpapostgresql.model.entity.Post;

public record CommentRecord(
    Long id,
    String name,
    String email,
    String body,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
    ) 
{
    public Comment toComment() {
        // return new Comment()
        //     .setId(id)
        //     .setName(name)
        //     .setEmail(email)
        //     .setBody(body);

        Comment comment = new Comment();
        //comment.setId(id);
        comment.setName(name);
        comment.setEmail(email);
        comment.setBody(body);
        return comment;        
    }
}
