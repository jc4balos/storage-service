package com.example.storage.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storage.service.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl {

    private final String folderPath = "D:\\Documents\\Repositories\\FileBank\\Storage\\";

    @Autowired
    private final FileRepository fileRepository;

}