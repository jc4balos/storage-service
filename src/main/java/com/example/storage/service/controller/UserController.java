package com.example.storage.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.storage.service.dto.LoginDto;
import com.example.storage.service.dto.UserDto;
import com.example.storage.service.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);

        } else {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/api/user/all-users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PatchMapping("/api/user/modify-user")
    public ResponseEntity<?> modifyUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.modifyUser(userDto.getUserId(), userDto), HttpStatus.OK);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
    }

}
