package com.example.auth_app.services;

import com.example.auth_app.dtos.UserDto;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByEmail(String email);

    UserDto updateUser(UserDto userDto, String userId);

    void deleteUser(String userId);

    UserDto getUserById(String id);

    Iterable<UserDto> getAllUser();
}
