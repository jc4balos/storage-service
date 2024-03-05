package com.example.storage.service.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.service.dto.FileDto;
import com.example.storage.service.exception.ApplicationExceptionHandler;
import com.example.storage.service.service.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private ApplicationExceptionHandler applicationExceptionHandler;

    @PostMapping("/api/v1/file/create-file")
    public ResponseEntity<?> uploadToFileSystem(@Valid @ModelAttribute FileDto fileDto,
            BindingResult bindingResult) throws IOException {

        if (!bindingResult.hasErrors()) {
            return new ResponseEntity<>(fileService.createFile(fileDto), HttpStatus.OK);
        } else {
            return applicationExceptionHandler.handleBadRequest(bindingResult);
        }

    }

}
