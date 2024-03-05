package com.example.storage.service.service;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.FolderDto;
import com.example.storage.service.model.Folder;
import com.example.storage.service.model.User;
import com.example.storage.service.repository.FolderRepository;
import com.example.storage.service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    @Override
    public FolderDto createFolder(FolderDto folderDto, Long userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " does not exist"));
        Folder folder = new Folder();

        folder.setFolderName(folderDto.getFolderName());
        folder.setFolderDescription(folderDto.getFolderDescription());
        folder.setOwner(owner);
        folder.setActive(true);
        if (folderDto.getFolderParentId() != null) {
            folder.setFolderParentId(folderDto.getFolderParentId());
        } else {
            folder.setFolderParentId(0L);
        }

        folderRepository.save(folder);
        return folderDto;
    }

    // @Override
    // public Map<String, Object> getAllFiles(Long folderId, Long userId) {

    // }
}
