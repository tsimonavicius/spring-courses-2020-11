package com.codeacademy.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String uniqueName;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long size;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}