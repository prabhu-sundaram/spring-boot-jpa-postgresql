package com.dm.springbootjpapostgresql.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dm.springbootjpapostgresql.model.Person;
import com.dm.springbootjpapostgresql.model.User;
import com.dm.springbootjpapostgresql.dto.UserDTO;


public class UserMapper {
@Autowired
private ModelMapper modelMapper;

//UserDTO userDTO = modelMapper.map(user, UserDTO.class);

/* 
TypeMap<User, UserDTO> typeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
typeMap.addMappings(modelMapper -> {
    modelMapper.map(src -> src.getFirstName() + " " + src.getLastName(), UserDTO::setFullName);
});*/

    // convert Entity into DTO
    public UserDTO mapToDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
        return userDTO;
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(this::mapToDTO).collect(Collectors.toList());
    }



    // convert DTO to entity
    public User mapToEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return user;
    }

    public List<User> toUserList(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
