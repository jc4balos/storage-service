package com.example.storage.service.service;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.FileDto;
import com.example.storage.service.model.File;
import com.example.storage.service.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";

    private final FileRepository fileRepository;

    public FileDto createFile(FileDto fileDto) {
        File file = new File();

        fileRepository.save(file);
        return fileDto;
    }

}