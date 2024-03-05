package com.example.storage.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileDto {

    @NotNull(message = "File name is required")
    private String fileName;

    @Size(max = 2000, message = "File description is too long")
    private String description;

    @NotNull(message = "File is required")
    private MultipartFile multipartFile;

    @NotNull
    private Long folderId;

    @NotNull
    private Long ownerId;
}
