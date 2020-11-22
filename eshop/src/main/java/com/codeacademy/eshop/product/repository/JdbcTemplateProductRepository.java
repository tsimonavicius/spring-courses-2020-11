package com.codeacademy.eshop.product.repository;

import com.codeacademy.eshop.product.exception.ProductNotFoundException;
import com.codeacademy.eshop.product.model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This class is responsible for interaction with our database
 */
@Repository
public class JdbcTemplateProductRepository {

    private static final String SELECT_PRODUCT_BY_ID = "select * from PRODUCTS where id=?";
    private static final String INSERT_PRODUCT = "INSERT INTO PRODUCTS (product_name, in_stock, price, description) VALUES (:name, :stock, :price, :desc)";
    private static final String UPDATE_PRODUCT_NAME_BY_ID = "UPDATE PRODUCTS SET product_name = :name WHERE id = :id";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM PRODUCTS WHERE id = ?";

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcTemplateProductRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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