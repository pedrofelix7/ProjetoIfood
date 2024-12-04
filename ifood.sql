CREATE database ifood;
USE ifood;

CREATE TABLE clientes(
id_clientes INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name varchar(200),
age int,
email varchar(200)
);

INSERT INTO clientes(name, age, email)
VALUES
('Pedro', 18, 'imperio@email.com'),
('Predela', 30, 'costagold@email.com'),
('Simon', 29, 'simon@email.com'),
('Thales', 20, 'thales@email.com'),
('Ricardo', 24, 'ricardo@email.com'),
('Gabriel', 21, 'gabriel@email.com'),
('Paulo', 23, 'paulo@email.com'),
('Henrique', 19, 'henrique@email.com'),
('Arthur', 28, 'arthur@email.com'),
('Fred', 30, 'fred@email.com');

SELECT * FROM clientes;

CREATE TABLE address (
    id_address INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    road VARCHAR(100),
    neighborhood VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(50),
    number INT,
    complement VARCHAR(50),
    reference_point VARCHAR(200),
    zip_code VARCHAR(10)
);
INSERT INTO address(road, neighborhood, city, state, number, complement, reference_point, zip_code)
VALUES
('Rua das Flores', 'Centro', 'Arcoverde', 'Pernambuco', 123, 'Apto 101', 'Próximo ao supermercado', '56500-000'),
('Avenida Paulista', 'Bela Vista', 'São Paulo', 'São Paulo', 456, 'Edifício XYZ', 'Em frente ao parque', '01311-000'),
('Rua XV de Novembro', 'Centro', 'Curitiba', 'Paraná', 789, 'Casa', 'Perto da praça', '80020-310'),
('Rua das Palmeiras', 'Jardim das Acácias', 'Recife', 'Pernambuco', 101, 'Cobertura', 'Atrás do shopping', '51020-290'),
('Avenida Brasil', 'Centro', 'Rio de Janeiro', 'Rio de Janeiro', 202, 'Bloco A', 'Próximo ao estádio', '20031-170'),
('Rua das Oliveiras', 'Jardim Europa', 'Porto Alegre', 'Rio Grande do Sul', 303, 'Apto 302', 'Perto da faculdade', '91330-060'),
('Avenida Independência', 'Centro', 'Fortaleza', 'Ceará', 404, 'Sala 45', 'Ao lado do hospital', '60010-100'),
('Rua da Aurora', 'Boa Vista', 'Recife', 'Pernambuco', 505, 'Loja 7', 'Em frente ao banco', '50050-000'),
('Rua das Nações', 'Centro', 'Campinas', 'São Paulo', 606, 'Apto 801', 'Perto do mercado', '13010-000'),
('Rua Santa Clara', 'Copacabana', 'Rio de Janeiro', 'Rio de Janeiro', 707, 'Casa 2', 'Próximo à praia', '22041-012');

SELECT * FROM address;

CREATE TABLE category (
    id_category INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50),
    name VARCHAR(25),
    description VARCHAR(200)
);
INSERT INTO category(type, name, description)
VALUES
('Comida', 'Lanches', 'Diversos tipos de lanches e sanduíches'),
('Comida', 'Massas', 'Variedade de massas e pratos italianos'),
('Comida', 'Sushi', 'Pratos da culinária japonesa'),
('Comida', 'Carnes', 'Cortes de carnes e churrascos'),
('Comida', 'Saladas', 'Saladas frescas e acompanhamentos'),
('Bebida', 'Refrigerantes', 'Refrigerantes e bebidas gaseificadas'),
('Bebida', 'Sucos', 'Sucos naturais e industrializados'),
('Bebida', 'Água', 'Água mineral e com gás'),
('Bebida', 'Cervejas', 'Variedade de cervejas artesanais e comerciais'),
('Bebida', 'Vinhos', 'Seleção de vinhos nacionais e importados');


CREATE TABLE restaurant (
    id_restaurant INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    id_address INT,
    telephone VARCHAR(12),
    category_id INT,
    operating_hour TIME,
    picked TINYINT(1),
    FOREIGN KEY (id_address) REFERENCES address(id_address),
    FOREIGN KEY (category_id) REFERENCES category(id_category)
);

ALTER TABLE restaurant MODIFY telephone VARCHAR(20);

INSERT INTO restaurant(name, id_address, telephone, category_id, operating_hour, picked)
VALUES
('Cantana', '87 99130-4321', '09:00:00', 1),
('Ferreira Espetos', '87 99940-9999', '11:00:00', 1),
('Bistrô Gourmet', '87 99950-9876', '10:30:00', 0),
('Pizza Mania', '87 99960-1234', '17:00:00', 1),
('Sushi Express', '87 99970-4567', '12:00:00', 0),
('Hamburgueria do Zé', '87 99980-7890', '18:00:00', 1),
('Churrascaria Gaúcha', '87 99990-3210', '11:30:00', 1),
('Lanchonete da Praça', '87 99900-6543', '08:00:00', 0),
('Café Central', '87 99810-9876', '07:00:00', 0),
('Tapiocaria da Maria', '87 99820-1111', '16:00:00', 1);

UPDATE restaurant
SET id_address = 1, category_id = 1;

SELECT * FROM restaurant;

CREATE TABLE product (
    id_product INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    description VARCHAR(200),
    price DECIMAL(5, 2),
    category_id INT,
    restaurant_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id_category),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant)
);
INSERT INTO product(name, description, price, category_id, restaurant_id)
VALUES
('Parmegiana de Frango', 'Frango com queijo', 49.90, 1, 1),
('Parmegiana de Carne', 'Filé mignon com queijo', 59.90, 1, 1),
('Espeto de picanha', '200g de picanha no espeto', 9.90, 2, 2),
('Strogonoff de Frango', 'Frango em cubos', 29.90, 1, 2),
('Coca-Cola Lata', 'Refrigerante em lata', 4.50, 2, 2),
('Guaraná Antártica', 'Refrigerante em lata', 4.00, 2, 2),
('Suco de Laranja', 'Suco natural de laranja', 7.00, 2, 1),
('Hambúrguer Clássico', 'Pão, carne, queijo e salada', 19.90, 1, 3),
('Pizza Margherita', 'Molho de tomate, mussarela e manjericão', 29.90, 1, 4),
('Salada Caesar', 'Alface, croutons e molho Caesar', 15.90, 1, 4);

SELECT * FROM product;

CREATE TABLE promotion (
    id_promotion INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    code VARCHAR(50),
    type VARCHAR(50),
    value DECIMAL(5, 2),
    validity DATE
);
INSERT INTO promotion(name, code, type, value, validity)
VALUES
('Promoção de Verão', 'SUMMER2024', 'Desconto', 10.00, '2024-12-31'),
('Promoção de Inverno', 'WINTER2024', 'Desconto', 15.00, '2024-12-31'),
('Frete Grátis', 'FRETEGRATIS', 'Frete', 5.00, '2024-12-31'),
('Desconto de Natal', 'NATAL2024', 'Desconto', 20.00, '2024-12-25'),
('Combo Família', 'FAMILIA2024', 'Desconto', 30.00, '2024-12-31'),
('Desconto de Páscoa', 'PASCOA2024', 'Desconto', 25.00, '2024-04-21'),
('Desconto de Aniversário', 'ANIV2024', 'Desconto', 50.00, '2024-12-31'),
('Desconto de Ano Novo', 'ANONOVO2024', 'Desconto', 15.00, '2024-01-01'),
('Promoção Relâmpago', 'RELAMPAGO', 'Desconto', 5.00, '2024-12-31'),
('Desconto Especial', 'ESPECIAL2024', 'Desconto', 10.00, '2024-11-30');


CREATE TABLE status_delivery (
    id_status_delivery INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);
INSERT INTO status_delivery(name)
VALUES
('Pedido Recebido'),
('Em Preparo'),
('Saiu para Entrega'),
('Entregue'),
('Cancelado'),
('Aguardando Pagamento'),
('Pagamento Confirmado'),
('Recolhido'),
('A Caminho'),
('Devolvido');

CREATE TABLE payment_method (
    id_payment_method INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    payment_type VARCHAR(50)
);
INSERT INTO payment_method(payment_type)
VALUES
('PIX'),
('DINHEIRO'),
('CARTÃO DE DÉBITO'),
('CARTÃO DE CRÉDITO');



CREATE TABLE payment_history (
    id_payment_history INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    payment_method_id INT,
    value DECIMAL(5, 2),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method)
);
INSERT INTO payment_history(date, payment_method_id, value)
VALUES
('2024-11-20', 1, 100.00),
('2024-11-21', 2, 50.00),
('2024-11-22', 3, 25.00),
('2024-11-23', 4, 75.00),
('2024-11-24', 4, 30.00),
('2024-11-25', 3, 120.00),
('2024-11-26', 2, 90.00),
('2024-11-27', 1, 60.00),
('2024-11-28', 1, 80.00),
('2024-11-29', 2, 45.00);

CREATE TABLE delivery_history (
    id_delivery_history INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status_delivery_id INT,
    orders_id INT,
    FOREIGN KEY (status_delivery_id) REFERENCES status_delivery(id_status_delivery),
    FOREIGN KEY (orders_id) REFERENCES orders(id_orders)
);
INSERT INTO delivery_history(status_delivery_id, orders_id)
VALUES
(1, 21),
(2, 22),
(3, 23),
(4, 24),
(5, 25),
(6, 26),
(7, 27),
(8, 28),
(9, 29),
(10, 30);


CREATE TABLE restaurant_payment (
    restaurant_id INT,
    payment_method_id INT,
    PRIMARY KEY (restaurant_id, payment_method_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method)
);
INSERT INTO restaurant_payment(restaurant_id, payment_method_id)
VALUES
(1, 3),
(2, 2),
(3, 1),
(4, 4),
(5, 3),
(6, 2),
(7, 1),
(8, 2),
(9, 3),
(10, 4);

select * from restaurant_payment;

CREATE TABLE orders (
    id_orders INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    restaurant_id INT,
    value DECIMAL(5, 2),
    delivery_fee DECIMAL(5, 2),
    promotion_id INT,
    status_delivery_id INT,
    payment_method_id INT,
    observation VARCHAR(200),
    transshipment DECIMAL(5, 2),
    address_id INT,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant),
    FOREIGN KEY (promotion_id) REFERENCES promotion(id_promotion),
    FOREIGN KEY (status_delivery_id) REFERENCES status_delivery(id_status_delivery),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method),
    FOREIGN KEY (address_id) REFERENCES address(id_address)
);
INSERT INTO orders(date, restaurant_id, value, delivery_fee, promotion_id, status_delivery_id, payment_method_id, observation, transshipment, address_id)
VALUES
('2024-11-20', 1, 59.90, 5.00, 1, 1, 1, 'Sem cebola', 1.00, 1 ),
('2024-11-21', 2, 49.90, 4.00, 2, 2, 2, 'Com gelo', 1.50, 2 ),
('2024-11-22', 3, 39.90, 3.00, 3, 3, 3, 'Extra bacon', 2.00, 3),
('2024-11-23', 4, 29.90, 2.00, 4, 4, 4, 'Sem sal', 0.50, 4),
('2024-11-24', 5, 19.90, 1.00, 5, 5, 1, 'Sem açúcar', 0.25, 5),
('2024-11-25', 6, 99.90, 10.00, 6, 6, 2, 'Extra queijo', 3.00, 6),
('2024-11-26', 7, 79.90, 8.00, 7, 7, 3, 'Extra molho', 2.50, 7),
('2024-11-27', 8, 69.90, 7.00, 8, 8, 4, 'Sem glúten', 2.00, 8),
('2024-11-28', 9, 89.90, 9.00, 9, 9, 3, 'Sem lactose', 2.75, 9),
('2024-11-29', 10, 109.90, 11.00, 10, 10, 1, 'Sem pimenta', 3.50, 10);


CREATE TABLE assessment (
    id_assessment INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    grade INT,
    id_orders INT,
    id_restaurant INT,
    FOREIGN KEY (id_orders) REFERENCES orders(id_orders),
    FOREIGN KEY (id_restaurant) REFERENCES restaurant(id_restaurant)
);
INSERT INTO assessment(grade, id_orders, id_restaurant)
VALUES
(5, 1, 1),
(4, 2, 2),
(3, 3, 3),
(5, 4, 4),
(4, 5, 5),
(3, 6, 6),
(5, 7, 7),
(4, 8, 8),
(3, 9, 9),
(5, 10, 10);


CREATE TABLE orders_product (
    id_orders_product INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    orders_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT DEFAULT 1,
    FOREIGN KEY (orders_id) REFERENCES orders(id_orders),
    FOREIGN KEY (product_id) REFERENCES product(id_product)
);
INSERT INTO orders_product(orders_id, product_id, quantity)
VALUES
(21, 31, 2),
(22, 32, 1),
(23, 33, 3),
(24, 34, 1),
(25, 35, 2),
(26, 36, 1),
(27, 37, 3),
(28, 38, 1),
(29, 39, 2),
(30, 40, 1);


SHOW TABLES;
DROP TABLE product_follow_up;
DROP TABLE follow_up;

SELECT p.name, SUM(op.quantity) AS total_vendido
FROM product p
INNER JOIN orders_product op ON p.id_product = op.product_id
GROUP BY p.name
ORDER BY total_vendido DESC
LIMIT 1;

SELECT p.name, SUM(op.quantity) AS total_vendido
FROM product p
INNER JOIN orders_product op ON p.id_product = op.product_id
GROUP BY p.name
ORDER BY total_vendido ASC
LIMIT 1;

SELECT MONTH(o.date) AS mes, SUM(op.quantity) AS total_vendido
FROM orders o
INNER JOIN orders_product op ON o.id_orders = op.orders_id
GROUP BY mes
ORDER BY total_vendido DESC
LIMIT 1;

SELECT pm.payment_type, COUNT(o.id_orders) AS total_usos
FROM payment_method pm
INNER JOIN orders o ON pm.id_payment_method = o.payment_method_id
GROUP BY pm.payment_type
ORDER BY total_usos DESC
LIMIT 1;

SELECT a.road, a.neighborhood, a.city, a.state, COUNT(o.id_orders) AS total_entregas
FROM address a
INNER JOIN orders o ON a.id_address = o.address_id
GROUP BY a.road, a.neighborhood, a.city, a.state
ORDER BY total_entregas DESC
LIMIT 1;

SELECT o.id_orders, SUM(op.quantity) AS total_produtos
FROM orders o
INNER JOIN orders_product op ON o.id_orders = op.orders_id
GROUP BY o.id_orders
ORDER BY total_produtos DESC
LIMIT 1;

SELECT pm.payment_type, SUM(o.value) AS total_vendas
FROM orders o
INNER JOIN payment_method pm ON o.payment_method_id = pm.id_payment_method
WHERE MONTH(o.date) = MONTH(CURRENT_DATE) AND YEAR(o.date) = YEAR(CURRENT_DATE)
GROUP BY pm.payment_type
ORDER BY total_vendas DESC;

SELECT pm.payment_type, SUM(o.value) AS total_vendas
FROM orders o
INNER JOIN payment_method pm ON o.payment_method_id = pm.id_payment_method
WHERE MONTH(o.date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AND YEAR(o.date) = YEAR(CURRENT_DATE)
GROUP BY pm.payment_type
ORDER BY total_vendas DESC;

UPDATE orders SET date = '2024-01-20' WHERE id_orders = 1;
UPDATE orders SET date = '2024-02-21' WHERE id_orders = 2;
UPDATE orders SET date = '2024-03-22' WHERE id_orders = 3;
UPDATE orders SET date = '2024-04-23' WHERE id_orders = 4;
UPDATE orders SET date = '2024-05-24' WHERE id_orders = 5;
UPDATE orders SET date = '2024-06-25' WHERE id_orders = 6;
UPDATE orders SET date = '2024-07-26' WHERE id_orders = 7;
UPDATE orders SET date = '2024-08-27' WHERE id_orders = 8;
UPDATE orders SET date = '2024-09-28' WHERE id_orders = 9;
UPDATE orders SET date = '2024-10-29' WHERE id_orders = 10;
UPDATE orders SET date = '2024-11-20' WHERE id_orders = 11;
UPDATE orders SET date = '2024-12-21' WHERE id_orders = 12;

SELECT MONTH(o.date) AS mes, COUNT(o.id_orders) AS total_vendas
FROM orders o
INNER JOIN orders_product op ON o.id_orders = op.orders_id
GROUP BY mes
ORDER BY total_vendas DESC
LIMIT 1;

SELECT * FROM orders WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(date) = YEAR(CURRENT_DATE);

INSERT INTO orders (date, restaurant_id, value, delivery_fee, promotion_id, status_delivery_id, payment_method_id, observation, transshipment, address_id)
VALUES
(CURRENT_DATE, 1, 100.00, 5.00, 1, 1, 1, 'Teste 1', 1.00, 1),
(CURRENT_DATE, 2, 150.00, 10.00, 2, 2, 2, 'Teste 2', 2.00, 2);

SELECT * FROM orders;

SELECT pm.payment_type, SUM(o.value) AS total_vendas
FROM orders o
INNER JOIN payment_method pm ON o.payment_method_id = pm.id_payment_method
WHERE MONTH(o.date) = MONTH(CURRENT_DATE) AND YEAR(o.date) = YEAR(CURRENT_DATE)
GROUP BY pm.payment_type
ORDER BY total_vendas DESC;