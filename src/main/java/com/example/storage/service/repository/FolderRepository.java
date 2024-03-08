package com.example.storage.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.storage.service.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM folder as a, folder_access as b, access_level as c\n" + //
            "WHERE c.access_level_id = ?1\n" +
            "AND a.folder_parent_id=?2\n" +
            "AND c.access_level_id = b.access_level_id\n" +
            "AND b.folder_id = a.folder_id\n" +
            "AND b.allow_view_folder=1\n" +
            "AND a.active=1;")
    List<Folder> findByFolderParentIdAndAccessLevel(Long accessLevelId, Long folderParentId);
}
