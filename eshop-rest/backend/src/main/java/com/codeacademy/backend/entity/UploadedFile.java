package com.codeacademy.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private UUID name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long size;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}
