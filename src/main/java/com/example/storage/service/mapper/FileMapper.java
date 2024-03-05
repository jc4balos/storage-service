package com.example.storage.service.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.storage.service.dto.FileDto;
import com.example.storage.service.model.File;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.UserRepository;

import lombok.Data;

@Data
@Component
public class FileMapper {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";
    private final UserRepository userRepository;
    private User user;

    public File toFile(FileDto fileDto) {
        Optional<User> userOptional = userRepository.findById(fileDto.getOwnerId());

        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        File file = new File();
        file.setFileName(fileDto.getFileName());
        file.setDescription(fileDto.getDescription());

        // get the multipartfile name and add id as salt at the service

        file.setFilePath(folderPath + fileDto.getFileName());
        file.setOwner(user);

        return file;
    }

}
