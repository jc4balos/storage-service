package com.example.storage.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storage.service.dto.UserDto;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // study sessionId to know how to use request variable
        // if sessionId is ok then execute all below and return userDto
        try {
            User user = new User();

            System.out.println("UserDto: " + userDto.getFirstName());
            user.setFirstName(userDto.getFirstName());
            user.setMiddleName(userDto.getMiddleName());
            user.setLastName(userDto.getLastName());
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            user.setAccessLevelId(userDto.getAccessLevelId());
            user.setActive(true);
            userRepository.save(user);
            return userDto;

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }

    }

}
