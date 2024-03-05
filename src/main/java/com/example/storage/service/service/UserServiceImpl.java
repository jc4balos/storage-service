package com.example.storage.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.storage.service.dto.LoginDto;
import com.example.storage.service.dto.PasswordDto;
import com.example.storage.service.dto.UserDto;
import com.example.storage.service.exception.CredentialsInvalidException;
import com.example.storage.service.exception.UserNameAlreadyExistsException;
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

        try {
            user = userMapper.toUser(userDto);
            userRepository.save(user);
            return userDto;
        } catch (DataIntegrityViolationException e) {
            throw new UserNameAlreadyExistsException("Username already exist");

        }

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
        user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
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
            String message = new String("Login successful");
            result.put("message", message);
            return result;
        } else {
            throw new CredentialsInvalidException("Invalid username or password");
        }
    }

    @Override
    public String changePassword(PasswordDto passwordDto) {
        user = userRepository.findById(passwordDto.getUserId()).get();

        if (user.getPassword().equals(passwordDto.getOldPassword())) {
            user.setPassword(passwordDto.getNewPassword());
            userRepository.save(user);
            return "Password changed successfully";
        } else {
            throw new CredentialsInvalidException("Invalid old password");
        }
    }
}