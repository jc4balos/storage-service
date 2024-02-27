package com.example.storage.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileDto {

    @NotBlank(message = "File name is mandatory")
    @Size(max = 100, message = "File name is too long")
    private String fileName;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 2000, message = "Description is too long")
    private String description;

    @NotNull(message = "File is mandatory")
    private MultipartFile file;
}
