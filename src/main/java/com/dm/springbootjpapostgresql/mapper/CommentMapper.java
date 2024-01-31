package com.dm.springbootjpapostgresql.mapper;

import org.modelmapper.ModelMapper;

import com.dm.springbootjpapostgresql.dto.CommentDto;
import com.dm.springbootjpapostgresql.model.Comment;

public class CommentMapper {
    private ModelMapper mapper;
    // Private constructor to prevent instantiation
    private CommentMapper() {
        // private constructor to hide the implicit public one
    }

    public CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = mapper.map(comment, CommentDto.class);

//        CommentDto commentDto = new CommentDto();
//        commentDto.setId(comment.getId());
//        commentDto.setName(comment.getName());
//        commentDto.setEmail(comment.getEmail());
//        commentDto.setBody(comment.getBody());
        return  commentDto;
    }

    public Comment mapToEntity(CommentDto commentDto){
        Comment comment = mapper.map(commentDto, Comment.class);
//        Comment comment = new Comment();
//        comment.setId(commentDto.getId());
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
        return  comment;
    }
}
