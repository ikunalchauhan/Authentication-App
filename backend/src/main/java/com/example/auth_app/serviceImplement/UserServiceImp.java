package com.example.auth_app.serviceImplement;

import com.example.auth_app.dtos.UserDto;
import com.example.auth_app.entites.Provider;
import com.example.auth_app.entites.User;
import com.example.auth_app.repositories.UserRepository;
import com.example.auth_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userDto.getEmail()==null || userDto.getEmail().isBlank())
            throw new IllegalArgumentException("Email is Required");

        if(userRepository.existsByEmail(userDto.getEmail()))
            throw new IllegalArgumentException("Email already exists");

        User user = modelMapper.map(userDto, User.class);
        user.setProvider(userDto.getProvider()==null ? Provider.LOCAL : userDto.getProvider());

//        TODO :: Role assign to user for authorisation

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public Iterable<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for(User user : users)
            usersDto.add(modelMapper.map(user, UserDto.class));

        return usersDto;
    }
}
