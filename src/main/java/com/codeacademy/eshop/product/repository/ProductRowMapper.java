package com.codeacademy.eshop.product.repository;

import com.codeacademy.eshop.product.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int runNumber) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("product_name"));
        product.setInStock(rs.getInt("in_stock"));
        product.setPrice((rs.getBigDecimal("price")));
        product.setDescription((rs.getString("description")));
        return product;
    }
}