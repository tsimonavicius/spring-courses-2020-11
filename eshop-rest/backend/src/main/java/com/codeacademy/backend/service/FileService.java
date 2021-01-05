package com.codeacademy.backend.service;

import com.codeacademy.backend.service.exception.FileStorageException;
import jdk.jfr.ContentType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Set;

import static org.springframework.http.MediaType.*;

@Service
public class FileService {

    private static final Set<String> ALLOWED_MEDIA_TYPES = Set.of(IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE, IMAGE_GIF_VALUE, APPLICATION_PDF_VALUE);
    private static int MAX_SIZE = 10000000; // 10 mb
    private Path storageLocation;

    public FileService() throws FileStorageException {
        this.storageLocation = Paths.get("./storage").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.storageLocation);
        } catch (IOException e) {
            throw new FileStorageException("Unable to create file storage");
        }
    }

    public String uploadFile(MultipartFile file) {

        String fileName = validateFile(file);

        Path targetLocation = this.storageLocation.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file");
        }
    }

    private String validateFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        if (file.getSize() > MAX_SIZE) {
            throw new FileStorageException("File size is too large");
        }

        if (fileName.contains("..")) {
            throw new FileStorageException("File name is invalid");
        }

        if (!ALLOWED_MEDIA_TYPES.contains(file.getContentType())) {
            throw new FileStorageException("File media type is not supported");
        }

        return fileName;
    }
}
