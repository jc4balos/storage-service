package com.example.storage.service.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storage.service.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String fileName);

}
