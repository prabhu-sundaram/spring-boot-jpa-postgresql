package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.model.Comment;

public record CommentRecord(
    Long id,
    String name,
    String email,
    String body
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
