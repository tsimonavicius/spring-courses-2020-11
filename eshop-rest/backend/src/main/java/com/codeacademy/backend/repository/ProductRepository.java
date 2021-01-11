package com.codeacademy.backend.repository;

import com.codeacademy.backend.entity.Product;
import com.codeacademy.backend.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
