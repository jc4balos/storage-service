package com.example.storage.service.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.example.storage.service.dto.FileDto;

public interface FileService extends FolderService {

    public FileDto uploadFile(FileDto fileDto, Long userId, HttpServletRequest request); // Uploads file
    // Add folder on this function

    public MultipartFile downloadFile(Long fileId); // Downloads file

    public Map<String, Object> viewFile(Long fileId, HttpServletRequest request); // View file
    // contains {fileInfo:FileDto, file:multipartFile}

    public String deleteFile(Long fileId); // Moves file to trash

    public FileDto updateFile(Long fileId) // Updates file

    public FileDto restoreFile(Long fileId); // Restores file from trash

    public String deleteFileFromTrash(Long fileId); // Deletes file from trash

}