package com.example.storage.service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.service.service.StorageService;

@RestController
public class StorageController {

    @PostMapping("/image")
    public ResponseEntity<?> uploadImageToDatabase(@RequestParam("image") MultipartFile multipartFile)
            throws IOException {
        String image = storageService.uploadImageToDatabase(multipartFile);

        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<?> downloadImageFromDatabase(@PathVariable(name = "filename") String fileName) {
        byte[] image = storageService.downloadImageFromDatabase(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @PostMapping("/file/system")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile multipartFile)
            throws IOException {
        String image = storageService.uploadImageToFileSystem(multipartFile);

        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    @GetMapping("/file/system/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] image = storageService.downloadImageFromFileSystem(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @Autowired
    private StorageService storageService;

}
