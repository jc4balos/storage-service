package com.example.storage.service.service;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.UserDto;

@Service
public interface UserService {
    public UserDto createUser(UserDto userDto);

    // public String deleteUser(Long userId, HttpServletRequest request);

    // public UserDto modifyUser(Long userId, UserDto userDto, HttpServletRequest
    // request);

    // public Map<String, Object> loginUser(LoginDto loginDto);
    // // contains {user:UserDto, sessionId:String}

    // public UserDto changePassword(Long userId, String oldPassword, String
    // newPassword, HttpServletRequest request);

}
