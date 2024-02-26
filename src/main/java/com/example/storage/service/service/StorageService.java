package com.example.storage.service.service;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.service.model.File;
import com.example.storage.service.service.persistence.FileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StorageService extends FileEncryptor {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";

    @Autowired
    private final FileRepository fileRepository;

    public String uploadImageToFileSystem(String fileName, String description, MultipartFile multipartFile)
            throws IOException {

        try {
            File file = new File();
            FileEncryptor fileEncryptor = new FileEncryptor();

            System.out.println("filename: " + fileName);
            file.setName(fileName);

            file.setDescription(description);

            file.setType(multipartFile.getContentType());

            file = fileRepository.save(file);

            file.setEncryptedFileName(fileEncryptor.encryptFileName(file.getId(), multipartFile.getOriginalFilename()));

            String filePath = folderPath + file.getEncryptedFileName();

            file.setFilePath(filePath);

            multipartFile.transferTo(new java.io.File(filePath));

            file = fileRepository.save(file);

            if (Objects.nonNull(file)) {
                return String.format("File uploaded successfully: %s", file.getName());
            }

            return "File upload failed. Please try again.";
        } catch (Exception e) {

            return "e";
        }

    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        File file = fileRepository.findByName(fileName);

        if (Objects.nonNull(file)) {
            return java.nio.file.Files.readAllBytes(new java.io.File(file.getFilePath()).toPath());
        }

        return null;
    }
}