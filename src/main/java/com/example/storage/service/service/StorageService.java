package com.example.storage.service.service;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.service.model.Image;
import com.example.storage.service.service.persistence.FileRepository;
import com.example.storage.service.service.persistence.ImageRepository;
import com.example.storage.service.util.ImageUtils;

public class StorageService {

    public String uploadImageToDatabase(MultipartFile multipartFile) throws IOException {
        Image image = new Image();

        image.setName(multipartFile.getOriginalFilename());
        image.setType(multipartFile.getContentType());
        image.setImageData(ImageUtils.compressImage(multipartFile.getBytes()));

        image = imageRepository.save(image);

        if (Objects.nonNull(image)) {
            return String.format("File upload successfully: %s", image.getName());
        }

        return String.format("File upload failed!");
    }

    public byte[] downloadImageFromDatabase(String fileName) {
        Optional<Image> image = imageRepository.findByName(fileName);

        return ImageUtils.decompressImage(image.get().getImageData());
    }

    private final String FOLDER_PATH = "C:\\Users\\alexandresouzajr\\storage-service";

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private FileRepository fileRepository;

}
