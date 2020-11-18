package com.codeacademy.eshop.product.repository;

import com.codeacademy.eshop.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository  {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT_ALL_PRODUCT_NAMES = "select p.product_name from PRODUCTS as p";
    private static final String SELECT_ALL_PRODUCTS = "select * from PRODUCTS where id=?";
    private static final String SELECT_PRODUCTS_COUNT_BY_NAME = "select count(*) from PRODUCTS where product_name = :name";

    @Autowired
    public ProductRepository(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            statement = con.prepareStatement(SELECT_ALL_PRODUCT_NAMES);
            rs = statement.executeQuery();

            while (rs.next()) {
                productNames.add(rs.getString(1));
            }
        } catch (SQLException ex1) {
            // do smth
        }
        finally {
            try {
                if (rs != null)
                    rs.close();
                if (statement != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex2) {

            }
        }
        return productNames;
    }

    public Product getProductByIdPreparedStatement(long id) {
        Product product = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            statement = con.prepareStatement(SELECT_ALL_PRODUCTS);
            statement.setLong(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("product_name"));
                product.setInStock(rs.getInt("in_stock"));
                product.setPrice((rs.getBigDecimal("price")));
                product.setDescription((rs.getString("description")));
            }
        } catch (SQLException ex1) {
            // do smth
        }
        finally {
            try {
                if (rs != null)
                    rs.close();
                if (statement != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex2) {

            }
        }
        return product;
    }


    public Product getProductByIdJdbcTemplate(long id) {
        return jdbcTemplate.queryForObject(SELECT_ALL_PRODUCTS, new ProductRowMapper(), id);
    }

    public int countOfProductsByName(String name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject(SELECT_PRODUCTS_COUNT_BY_NAME, namedParameters, Integer.class);
    }
}
