package com.codeacademy.backend.service;

import com.codeacademy.backend.controller.dto.ProductDTO;
import com.codeacademy.backend.entity.Product;
import com.codeacademy.backend.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
//        product.setName(productDTO.getName());
//        product.setDescription(productDTO.getDescription());
//        product.setInStock(productDTO.getInStock());
//        product.setPrice(productDTO.getPrice());
        BeanUtils.copyProperties(productDTO, product);
        Product savedProduct = productRepository.save(product);
        productDTO.setId(savedProduct.getId());
        return productDTO;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (productDTO.getId() == null) {
            // throw bad request exception
        }
        Product product = productRepository.getOne(productDTO.getId());
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
        return productDTO;
    }

    public ProductDTO getProductById(long id) {
        Product product = productRepository.getOne(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public void deleteProduct(long id) {
       productRepository.deleteById(id);
    }
}
