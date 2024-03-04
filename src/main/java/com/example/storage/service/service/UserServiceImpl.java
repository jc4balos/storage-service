package com.example.storage.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.LoginDto;
import com.example.storage.service.dto.UserDto;
import com.example.storage.service.mapper.UserMapper;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private User user;

    @Override
    public UserDto createUser(UserDto userDto) {
        // study sessionId to know how to use request variable
        // if sessionId is ok then execute all below and return userDto

        // User user = new User();
        user = userMapper.toUser(userDto);
        userRepository.save(user);
        return userDto;

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto modifyUser(Long userId, UserDto userDto) {
        user = userRepository.findById(userId).get();
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setAccessLevelId(userDto.getAccessLevelId());
        user.setActive(userDto.getActive());
        userRepository.save(user);
        return userDto;
    }

    @Override
    public String deactivateUser(Long userId) {
        user = userRepository.findById(userId).get();
        user.setActive(false);
        String userName = user.getUserName();
        userRepository.save(user);
        return "User " + userName + " deactivated";
    }

    @Override
    public String activateUser(Long userId) {
        user = userRepository.findById(userId).get();
        user.setActive(true);
        String userName = user.getUserName();
        userRepository.save(user);
        return "User " + userName + " activated";
    }

    @Override
    public Map<String, Object> loginUser(LoginDto loginDto) {
        user = userRepository.findByUserName(loginDto.getUserName());

        if (user.getPassword().equals(loginDto.getPassword())) {
            Map<String, Object> result = new HashMap<>();
            result.put("user", userMapper.toUserDto(user));
            return result;
        } else {
            Map<String, Object> result = new HashMap<>();
            result.put("validation", loginDto);
            return result;
        }
    }
}
