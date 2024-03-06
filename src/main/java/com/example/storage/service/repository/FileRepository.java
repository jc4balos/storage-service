package com.example.storage.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storage.service.model.FileData;

/**
 * @author Alexandre de Souza Jr.
 */
public interface FileRepository extends JpaRepository<FileData, Long> {

    FileData findByFileName(String fileName);

}
