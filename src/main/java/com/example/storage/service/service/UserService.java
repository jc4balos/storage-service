package com.example.storage.service.service;

import javax.servlet.http.HttpServletRequest;

import com.example.storage.service.dto.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDto, HttpServletRequest request);

    // public String deleteUser(Long userId, HttpServletRequest request);

    // public UserDto modifyUser(Long userId, UserDto userDto, HttpServletRequest
    // request);

    // public Map<String, Object> loginUser(LoginDto loginDto);
    // // contains {user:UserDto, sessionId:String}

    // public UserDto changePassword(Long userId, String oldPassword, String
    // newPassword, HttpServletRequest request);

}
