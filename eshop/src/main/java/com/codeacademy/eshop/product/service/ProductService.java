package com.codeacademy.eshop.product.service;

import com.codeacademy.eshop.product.exception.ProductNotFoundException;
import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.repository.JdbcTemplateProductRepository;
import com.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * This class is responsible for our business logic
 */
@Service
public class ProductService {

    private JdbcTemplateProductRepository jdbcTemplateProductRepository;
    private ProductRepository productRepository;
    List<Product> products = List.of(new Product(), new Product());

    public ProductService(JdbcTemplateProductRepository jdbcTemplateProductRepository, ProductRepository productRepository) {
        this.jdbcTemplateProductRepository = jdbcTemplateProductRepository;
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        // business logic goes here (in this class)!
        String currLang = LocaleContextHolder.getLocale().getDisplayName();

//        Product alwaysVisibleProduct = new Product();
//        alwaysVisibleProduct.setDescription("Visada matomas produktas");
//        alwaysVisibleProduct.setPrice(BigDecimal.valueOf(10000));
//        alwaysVisibleProduct.setInStock(99999);
//        alwaysVisibleProduct.setName(Translator.getMessage("product.language").concat(currLang));

//        List<Product> products = jdbcTemplateProductRepository.getAll();
        Page<Product> products = productRepository.findAll(pageable);
//        products.add(alwaysVisibleProduct);
        return products;
    }

    public Product getProductById(long id) {

        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public Product addProduct(Product product) {
//        jdbcTemplateProductRepository.save(product);
        return productRepository.save(product);
    }

    public void deleteById(long id) {
        jdbcTemplateProductRepository.deleteById(id);
    }

    @Transactional
    public void updateProductName(Product productFromModel) {
        Product product = productRepository.getOne(productFromModel.getId());
        product.setName(productFromModel.getName());
    }
}
