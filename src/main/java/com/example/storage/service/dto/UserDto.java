package com.example.storage.service.dto;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private Long accessLevelId;
}
