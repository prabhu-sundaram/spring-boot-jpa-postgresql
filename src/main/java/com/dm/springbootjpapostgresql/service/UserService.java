package com.dm.springbootjpapostgresql.service;

import java.util.List;

import com.dm.springbootjpapostgresql.dto.montaji.UserCreateRequestDto;
import com.dm.springbootjpapostgresql.dto.montaji.UserCreateResponseDto;

public interface UserService {
    UserCreateResponseDto createUser(UserCreateRequestDto userDto);

    //UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);

    // UserDto getUserById(long id);
    // UserDto getUserByUserName(String userName);

    // UserDto updateUser(UserDto userDto, long id);
    // UserDto updateUserByUserName(UserDto userDto, String userName);

    // void deleteUserById(long id);
    // void deleteUserByUserName(String userName);

}
