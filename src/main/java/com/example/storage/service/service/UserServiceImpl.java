package com.example.storage.service.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.storage.service.dto.UserDto;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private User user;

    @Override
    public UserDto createUser(UserDto userDto, HttpServletRequest request) {
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setAccessLevelId(userDto.getAccessLevelId());
        userRepository.save(user);
        return userDto;
    }

}
