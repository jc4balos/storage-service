package com.example.storage.service.dto;

import java.time.LocalDateTime;

import com.example.storage.service.model.User;

import lombok.Data;

@Data

public class FolderDto {

    private Long folderId;

    private String folderName;

    private String folderDescription;

    private Long folderParentId;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    private Boolean active;

    private User user;

}
