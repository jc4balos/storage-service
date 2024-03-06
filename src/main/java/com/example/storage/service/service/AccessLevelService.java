package com.example.storage.service.service;

import org.springframework.stereotype.Service;

import com.example.storage.service.dto.CreateAccessLevelDto;

@Service
public interface AccessLevelService {

    public String addAccessLevel(CreateAccessLevelDto createAccessLevelDto);

    // public String deactivateAccessLevel(Long userId, Long accessLevelId);

    // public String activateAccessLevel(Long userId, Long accessLevelId);

}
