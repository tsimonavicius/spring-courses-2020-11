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

INSERT INTO USER (id, password, username) VALUES
  (1, '{bcrypt}$2y$12$fQ32bokGVwHwn8PvC7Q/ROZEEMKuX97epHJlva10Px/ABEPWd2due', 'user'),
  (2, '{bcrypt}$2y$12$zroYgqeBBP1CE9aVnVw7bed4FIzjeiIbWO8PY9N3aGi4it12v5KQq', 'admin');

INSERT INTO ROLE (id, role_name) VALUES
    (1, 'USER'),
    (2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
    (1, 1),
    (2, 2),
    (2, 1);