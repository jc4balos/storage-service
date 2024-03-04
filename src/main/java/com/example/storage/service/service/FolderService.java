package com.example.storage.service.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.storage.service.dto.FolderDto;

public interface FolderService {

    public FolderDto createFolder(String folderName, Long userId);

    public String deleteFolder(Long folderId, Long userId, HttpServletRequest request);

    public Map<String, Object> getAllFiles(Long folderId, Long userId, HttpServletRequest request);
    // contains {folders:List<FolderDto>, files:List<FileDto>}

    public FolderDto modifyFolder(Long folderId, String folderName, String description);

    public FolderDto restoreFolder(Long folderId, Long userId, HttpServletRequest request);

}