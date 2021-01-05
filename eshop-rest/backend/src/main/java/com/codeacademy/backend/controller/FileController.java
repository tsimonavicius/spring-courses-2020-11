package com.codeacademy.backend.controller;

import com.codeacademy.backend.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/file")
public class FileController {

    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    private List<String> getAllFiles() {
        return List.of("failas", "failas2");
    }

    @PostMapping
    private String uploadFile(@RequestParam("document") MultipartFile file) {
        return fileService.uploadFile(file);
    }

    @PutMapping("/{name2}")
    private String updateFile(@PathVariable String name2) {
        return name2;
    }
}
