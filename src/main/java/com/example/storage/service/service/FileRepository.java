package com.example.storage.service.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storage.service.model.File;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findByName(String fileName);

}
