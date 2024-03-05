package com.example.storage.service.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "folder_access")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FolderAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "folderAccessId")
    private Long folderAccessId;

    @ManyToMany(targetEntity = Folder.class)
    @JoinColumn(nullable = false, name = "folderId")
    private List<Folder> folder;

    @ManyToOne
    @JoinColumn(nullable = false, name = "accessLevelId")
    private AccessLevel accessLevel;

    @Column(nullable = false, name = "allowAddFolder")
    private Boolean allowAddFolder;

    @Column(nullable = false, name = "allowModifyFolder")
    private Boolean allowModifyFolder;

    @Column(nullable = false, name = "allowViewFolder")
    private Boolean allowViewFolder;

    @Column(nullable = false, name = "allowDeleteFolder")
    private Boolean allowDeleteFolder;

    @Column(nullable = false, name = "allowAddFile")
    private Boolean allowAddFile;

    @Column(nullable = false, name = "allowModifyFile")
    private Boolean allowModifyFile;

    @Column(nullable = false, name = "allowDeleteFile")
    private Boolean allowDeleteFile;

    @Column(nullable = false, name = "allowViewFile")
    private Boolean allowViewFile;
}
