package com.example.storage.service.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.storage.service.service.persistence.FileRepository;
import com.example.storage.service.service.persistence.ImageRepository;

public class StorageService {

    private final String FOLDER_PATH = "C:\\Users\\alexandresouzajr\\storage-service";

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private FileRepository fileRepository;

}
