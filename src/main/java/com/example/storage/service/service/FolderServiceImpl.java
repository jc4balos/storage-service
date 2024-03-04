package com.example.storage.service.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    // private final FolderRepository folderRepository;
    // private final UserRepository userRepository;

    // private Folder folder;

    // @Override
    // public FolderDto createFolder(FolderDto folderDto) {
    // folder.setName(folderDto.getName());
    // folder.setOwner(userRepository.findById(folderDto.getOwnerId())
    // .orElseThrow(() -> new UserNotFoundException("User not found")));
    // folder.setPath(folderDto.getPath());
    // return FolderMapper.toDto(folderRepository.save(folder));
    // }

}
