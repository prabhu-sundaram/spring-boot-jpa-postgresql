package com.dm.springbootjpapostgresql.mapper.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.CommentDto;
import com.dm.springbootjpapostgresql.model.entity.Comment;

import org.mapstruct.BeanMapping;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// @Component
// public class CommentMapper {
//     @Autowired
//     private ModelMapper modelMapper;

//     /* 
//     // Private constructor to prevent instantiation
//     private CommentMapper() {
//         // private constructor to hide the implicit public one
//     }*/

//     public CommentDto mapToDTO(Comment comment){
//         CommentDto commentDto = modelMapper.map(comment, CommentDto.class);

// //        CommentDto commentDto = new CommentDto();
// //        commentDto.setId(comment.getId());
// //        commentDto.setName(comment.getName());
// //        commentDto.setEmail(comment.getEmail());
// //        commentDto.setBody(comment.getBody());
//         return  commentDto;
//     }

//     public Comment mapToEntity(CommentDto commentDto){
//         Comment comment = modelMapper.map(commentDto, Comment.class);
// //        Comment comment = new Comment();
// //        comment.setId(commentDto.getId());
// //        comment.setName(commentDto.getName());
// //        comment.setEmail(commentDto.getEmail());
// //        comment.setBody(commentDto.getBody());
//         return  comment;
//     }
// }

@Mapper(componentModel = "spring")
public interface CommentMapper {
    
    @Mapping(target = "post", ignore = true) // We handle this in PostMapper
    Comment toEntity(CommentDto commentDto);

    // This updates the existing Post entity with data from CommentDTO
    @Mapping(target = "id", ignore = true) // Usually, we don't want to change the ID
    @Mapping(target = "post", ignore = true)
    // This tells MapStruct: if a DTO field is null, don't touch the Entity field
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)    
    void updateCommentFromDto(CommentDto dto, @MappingTarget Comment entity);   

    // This custom condition applies to ALL String mappings in this mapper
    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    CommentDto toDto(Comment comment);
}