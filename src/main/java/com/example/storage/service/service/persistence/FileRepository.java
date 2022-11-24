package com.example.storage.service.service.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storage.service.model.File;

/**
 * @author Alexandre de Souza Jr.
 */
public interface FileRepository extends JpaRepository<File, Long> {

    File findByName(String fileName);

}
