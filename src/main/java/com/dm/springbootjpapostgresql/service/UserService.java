package com.dm.springbootjpapostgresql.service;

import java.util.List;

import com.dm.springbootjpapostgresql.dto.montaji.UserCreateRequestDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateResponseDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserFetchAllResponseDto;

public interface UserService {
    UserCreateResponseDto createUser(UserCreateRequestDto userDto);

    //UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
    List<UserFetchAllResponseDto> getAllUsers();
    

    // UserDto getUserById(Long id);
    // UserDto getUserByUserName(String userName);

    // UserDto updateUser(UserDto userDto, Long id);
    // UserDto updateUserByUserName(UserDto userDto, String userName);

    // void deleteUserById(Long id);
    // void deleteUserByUserName(String userName);

}
