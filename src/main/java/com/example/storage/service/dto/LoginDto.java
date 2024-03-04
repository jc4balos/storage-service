package com.example.storage.service.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginDto {

    @NotEmpty(message = "User name is required")
    @NotNull(message = "User name is required")
    @Size(min = 2, message = "User name should have at least 2 characters")
    @Size(max = 100, message = "User name should have at most 100 characters")
    private String userName;

    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    private String password;

}
