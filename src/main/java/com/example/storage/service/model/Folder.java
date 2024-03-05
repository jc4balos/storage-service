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
@Table(name = "folder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "folderId")
    private Long folderId;

    @Column(nullable = false, length = 100, name = "folderName")
    private String folderName;

    @Column(nullable = false, length = 2000, name = "folderDescription")
    private String folderDescription;

    @Column(nullable = false, name = "folderParentId")
    private Long folderParentId;

    @CreationTimestamp
    @Column(nullable = false, name = "createdDateTime")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(nullable = false, name = "updatedDateTime")
    private LocalDateTime updatedDateTime;

    @Column(nullable = false, name = "active")
    private Boolean active;

    @ManyToOne(targetEntity = File.class)
    @JoinColumn(name = "ownerId")
    private User owner;

}