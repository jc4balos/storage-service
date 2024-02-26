package com.example.storage.service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.service.service.StorageService;

/**
 * @author Alexandre de Souza Jr.
 */
@RestController
public class StorageController {

    @PostMapping("/file/system")
    public ResponseEntity<?> uploadImageToFIleSystem(String fileName, String description,
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        String file = storageService.uploadImageToFileSystem(fileName, description, multipartFile);

        return ResponseEntity.status(HttpStatus.OK).body(file);
    }

    // @GetMapping("/file/system/{fileName}")
    // public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String
    // fileName) throws IOException {
    // byte[] image = storageService.downloadImageFromFileSystem(fileName);

    // return
    // ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    // }

    @Autowired
    private StorageService storageService;

}
