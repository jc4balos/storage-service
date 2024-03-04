package com.example.storage.service.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false, length = 100, name = "fileName")
    private String fileName;

    @Column(nullable = false, length = 2000, name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "folderId")
    private Folder folder;

    @Column(nullable = true, name = "filePath")
    private String filePath;

    @Column(nullable = false, name = "fileType")
    private String fileType;

    @CreationTimestamp
    @Column(nullable = false, name = "createdDateTime")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "updatedDateTime")
    private LocalDateTime updatedDateTime;

    @Column(nullable = false, name = "active")
    private Boolean active;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User owner;

}
