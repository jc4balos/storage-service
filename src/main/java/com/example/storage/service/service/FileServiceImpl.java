package com.example.storage.service.service;

import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.FileDto;
import com.example.storage.service.mapper.FileMapper;
import com.example.storage.service.model.File;
import com.example.storage.service.repository.FileRepository;
import com.example.storage.service.util.FileEncryptor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    public FileDto createFile(FileDto fileDto) {

        try {
            File file = fileMapper.toFile(fileDto);
            FileEncryptor fileEncryptor = new FileEncryptor();
            String fileType = fileDto.getMultipartFile().getContentType();

            System.out.println(fileType);

            String encryptedFileName = fileEncryptor.encryptFileName(1L,
                    fileDto.getMultipartFile().getOriginalFilename());

            String fullPath = Paths
                    .get(folderPath, encryptedFileName).toString();

            fileDto.getMultipartFile().transferTo(new java.io.File(fullPath));
            // to fix this refactor the file class hayssst

            file.setFilePath(fullPath);

            file.setFileType(fileType);

            file.setActive(true);

            fileRepository.save(file);
            System.out.println(file.toString());
            return fileDto;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error in creating file: " + e);
        }

    }

}