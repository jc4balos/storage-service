package com.example.storage.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.storage.service.dto.FolderDto;

@Controller
public class FolderController {

    @PostMapping("/api/v1/folder/create-folder")
    public ResponseEntity<?> createFolder(@RequestBody FolderDto folderDto) {
        return null;
    }
}
