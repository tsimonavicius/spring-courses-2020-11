INSERT INTO PRODUCT (name, in_stock, price, description) VALUES
('Kremukas0', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas1', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas2', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas3', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas4', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas5', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas6', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas7', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas8', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas9', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas10', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas11', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas12', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas13', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas14', 20, 19.99, 'Kremukas odai sausint'),
('Kremukas plaukam', 22, 24.99, 'Kremukas plaukams sviestint'),
('Plauku balzamas', 30, 4.99, 'Balzamas plaukams');

INSERT INTO USER (id, password, username, name, lastname) VALUES
  (1, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'user', 'Vardenis', 'Pavardenis'),
  (2, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'admin', 'Adminas', 'Adminauskas');

INSERT INTO ROLE (id, role_name) VALUES
    (1, 'USER'),
    (2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
    (1, 1),
    (2, 2),
    (2, 1);
