package com.codeacademy.backend.service;

import com.codeacademy.backend.controller.dto.ProductDTO;
import com.codeacademy.backend.entity.Product;
import com.codeacademy.backend.repository.ProductRepository;
import com.codeacademy.backend.service.exception.EntityNotFoundException;
import com.codeacademy.backend.service.exception.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.convertProductDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        productDTO.setId(savedProduct.getId());
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Long id = productDTO.getId();
        if (id == null) {
            throw new EntityNotFoundException(id);
        }

        Product product = getById(id);
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
        return productDTO;
    }

    public ProductDTO getProductById(long id) {
        Product product = getById(id);
        return productMapper.convertProductToDTO(product);
    }

    public void deleteProduct(long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(e -> productMapper.convertProductToDTO(e))
                .collect(Collectors.toList());
    }

    private Product getById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }
}
