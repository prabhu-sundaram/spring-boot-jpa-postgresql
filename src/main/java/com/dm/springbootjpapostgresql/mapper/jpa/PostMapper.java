package com.dm.springbootjpapostgresql.mapper.jpa;

import java.util.List;
import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostResponse;
import com.dm.springbootjpapostgresql.model.entity.Category;
import com.dm.springbootjpapostgresql.model.entity.Comment;
import com.dm.springbootjpapostgresql.model.entity.Post;
import com.dm.springbootjpapostgresql.repository.jpa.CategoryRepository;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;


// @Component
// public class PostMapper {
 
//     //@Autowired
//     //private ModelMapper modelMapper;

//     @Autowired
//     private CategoryRepository categoryRepository;
//     /* 
//     // Private constructor to prevent instantiation
//     private PostMapper() {
//         // private constructor to hide the implicit public one
//     }*/

//     // convert Entity into DTO
//     public PostDto mapToDTO(Post post){
//         //PostDto postDto = modelMapper.map(post, PostDto.class);
//         PostDto postDto = new PostDto();
//         postDto.setId(post.getId());
//         postDto.setTitle(post.getTitle());
//         postDto.setDescription(post.getDescription());
//         postDto.setContent(post.getContent());
//         postDto.setCategoryId(post.getCategory().getId());
//         postDto.setComments(post.getComments().stream()
//                 .map(comment -> {
//                     CommentDto commentDto = new CommentDto();
//                     commentDto.setId(comment.getId());
//                     commentDto.setName(comment.getName());
//                     commentDto.setEmail(comment.getEmail());
//                     commentDto.setBody(comment.getBody());                    
//                     return commentDto;
//                 })
//                 .collect(Collectors.toList()));
//         return postDto;
//     }

//     // convert DTO to entity
//     public Post mapToEntity(PostDto postDto){
//         //Post post = modelMapper.map(postDto, Post.class);
//         //List<Comment> comments = modelMapper.mapCollection(postDto.getComments(), Comment.class);
//         //post.setComments(comments); 

//         Post post = new Post();
//         post.setTitle(postDto.getTitle());
//         post.setDescription(postDto.getDescription());
//         post.setContent(postDto.getContent());       
//         if(postDto.getCategoryId() != null) {
//             Category category = categoryRepository.findById(postDto.getCategoryId()).orElse(null);
//             post.setCategory(category);
//         };        
//         post.setComments(postDto.getComments().stream()
//                 .map(commentDto -> {
//                     Comment comment = new Comment();
//                     comment.setId(commentDto.getId());
//                     comment.setName(commentDto.getName());
//                     comment.setEmail(commentDto.getEmail());
//                     comment.setBody(commentDto.getBody());                    
//                     comment.setPost(post);
//                     return comment;
//                 }).collect(Collectors.toList()));
//         return post;
//     }

// }

@Mapper(componentModel = "spring", uses = {CommentMapper.class}) 
public abstract class PostMapper {

    /* =========================
       Entity ↔ DTO
       ========================= */

    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected CommentMapper commentMapper;

    // DTO to Entity
    @Mapping(target = "category", expression = "java(fetchCategory(postDto.getCategoryId()))")
    @Mapping(target = "comments", ignore = true) // Handled in @AfterMapping to set back-reference
    public abstract Post toEntity(PostDto postDto);

    // This updates the existing Post entity with data from PostDTO
    @Mapping(target = "id", ignore = true) // Usually, we don't want to change the ID
    @Mapping(target = "category", ignore = true)
    // This tells MapStruct: if a DTO field is null, don't touch the Entity field
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePostFromDto(PostDto dto, @MappingTarget Post entity);   

    // This custom condition applies to ALL String mappings in this mapper
    @Condition
    @Named("postStringCheck")
    boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }    

    // Helper to fetch Category
    protected Category fetchCategory(Long categoryId) {
        if (categoryId == null) return null;
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @AfterMapping
    protected void linkComments(@MappingTarget Post post, PostDto postDto) {
        if (postDto.getComments() != null) {
            // post.setComments(postDto.getComments().stream()
            //     .map(dto -> {
            //         Comment comment = new Comment();
            //         comment.setId(dto.getId());
            //         comment.setName(dto.getName());
            //         comment.setEmail(dto.getEmail());
            //         comment.setBody(dto.getBody());
            //         comment.setPost(post); // The critical back-reference
            //         return comment;
            //     }).collect(Collectors.toList()));

        List<Comment> comments = postDto.getComments().stream()
                    .map(commentMapper::toEntity)
                    .peek(comment -> comment.setPost(post)) // Link each comment to this post
                    .collect(Collectors.toList());
                post.setComments(comments);            
        }
    }

    // Entity to DTO
    @Mapping(source = "category.id", target = "categoryId")
    public abstract PostDto toDto(Post post);

    /* =========================
       Page → PostResponse
       ========================= */

    @Mapping(source = "content", target = "content")
    @Mapping(source = "number", target = "pageNo")
    @Mapping(source = "size", target = "pageSize")
    @Mapping(source = "totalElements", target = "totalElements")
    @Mapping(source = "totalPages", target = "totalPages")
    @Mapping(source = "last", target = "last")
    public abstract PostResponse toPostResponse(Page<Post> postPage);    
}

