package com.example.storage.service.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexandre de Souza Jr.
 */
@Entity
@Table(name = "file")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "fileId")
    private Long fileId;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false, length = 100, name = "fileName")
    private String fileName;

    @NotBlank(message = "Description is mandatory")
    @Column(nullable = false, length = 2000, name = "description")
    private String description;

    @Column(nullable = true, name = "encryptedFileName")
    private String encryptedFileName;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = true, name = "filePath")
    private String filePath;

    @CreationTimestamp
    @Column(nullable = false, name = "createdDateTime")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "updatedDateTime")
    private LocalDateTime updatedDateTime;

}
