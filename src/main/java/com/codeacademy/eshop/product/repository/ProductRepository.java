package com.codeacademy.eshop.product.repository;

import com.codeacademy.eshop.product.exception.ProductNotFoundException;
import com.codeacademy.eshop.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository  {

    private static final String SELECT_ALL_PRODUCTS = "select * from PRODUCTS";
    private static final String SELECT_PRODUCT_BY_ID = "select * from PRODUCTS where id=?";
    private static final String INSERT_PRODUCT = "INSERT INTO PRODUCTS (product_name, in_stock, price, description) VALUES (:name, :stock, :price, :desc)";
    private static final String UPDATE_PRODUCT_NAME_BY_ID = "UPDATE PRODUCTS SET product_name = :name WHERE id = :id";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCTS WHERE id = ?";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Product> getAll() {
        return jdbcTemplate.query(SELECT_ALL_PRODUCTS, new ProductRowMapper());
    }

    public Product findById(long id) {
        Product p = jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new ProductRowMapper(), id);
        if (p == null) throw new ProductNotFoundException();
        return p;
    }

    public void save(Product product) {
        MapSqlParameterSource namedParams = new MapSqlParameterSource();
        namedParams.addValue("name", product.getName());
        namedParams.addValue("stock", product.getInStock());
        namedParams.addValue("price", product.getPrice());
        namedParams.addValue("desc", product.getDescription());
        namedParameterJdbcTemplate.update(INSERT_PRODUCT, namedParams);
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
    }

    public void updateNameById(String newName, long id) {
        MapSqlParameterSource namedParams = new MapSqlParameterSource();
        namedParams.addValue("name", newName);
        namedParams.addValue("id", id);
        namedParameterJdbcTemplate.update(UPDATE_PRODUCT_NAME_BY_ID, namedParams);
    }
}
