package com.example.storage.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {

    @NotNull(message = "First name is required")
    @Size(min = 2, message = "First name should have at least 2 characters")
    @Size(max = 100, message = "First name should have at most 100 characters")
    private String firstName;

    @NotNull(message = "Middle name is required")
    @Size(min = 2, message = "Middle name should have at least 2 characters")
    @Size(max = 100, message = "Middle name should have at most 100 characters")
    private String middleName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    @Size(max = 100, message = "Last name should have at most 100 characters")
    private String lastName;

    @NotNull(message = "User name is required")
    @Size(min = 2, message = "User name should have at least 2 characters")
    @Size(max = 100, message = "User name should have at most 100 characters")
    private String userName;

    @NotNull(message = "Password is required")
    private String password;

    private Long accessLevelId;
}
