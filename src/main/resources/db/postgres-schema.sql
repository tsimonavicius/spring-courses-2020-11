DROP TABLE IF EXISTS PRODUCTS;

CREATE TABLE PRODUCTS(
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    in_stock INTEGER NOT NULL,
    price DECIMAL(20, 2) NOT NULL,
    description VARCHAR(250) DEFAULT NULL
);