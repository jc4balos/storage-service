package com.example.storage.service.mapper;

import org.springframework.stereotype.Component;

import com.example.storage.service.dto.FileDto;
import com.example.storage.service.model.File;
import com.example.storage.service.model.Folder;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.FolderRepository;
import com.example.storage.service.repository.UserRepository;

import lombok.Data;

@Data
@Component
public class FileMapper {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;

    public File toFile(FileDto fileDto) {
        User owner = userRepository.findById(fileDto.getOwnerId()).get();
        Folder folder = folderRepository.findById(fileDto.getFolderId()).get();

        if (owner != null) {
            File file = new File();
            file.setFileName(fileDto.getFileName());
            file.setDescription(fileDto.getDescription());
            file.setFolder(folder);
            // get the multipartfile name and add id as salt at the service

            file.setOwner(owner);

            return file;
        } else {
            throw new IllegalArgumentException("User not found");
        }

    }

}
