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

CREATE TABLE category (
    id_category INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50),
    name VARCHAR(25),
    description VARCHAR(200)
);

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

CREATE TABLE follow_up (
    id_follow_up INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    description VARCHAR(50),
    value DECIMAL(5, 2)
);

CREATE TABLE promotion (
    id_promotion INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    code VARCHAR(50),
    type VARCHAR(50),
    value DECIMAL(5, 2),
    validity DATE
);

CREATE TABLE status_delivery (
    id_status_delivery INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE payment_method (
    id_payment_method INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    payment_type VARCHAR(50)
);

CREATE TABLE payment_history (
    id_payment_history INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    payment_method_id INT,
    value DECIMAL(5, 2),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method)
);

CREATE TABLE delivery_history (
    id_delivery_history INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    status_delivery_id INT,
    order_id INT,
    FOREIGN KEY (status_delivery_id) REFERENCES status_delivery(id_status_delivery),
    FOREIGN KEY (order_id) REFERENCES `order`(id_order)
);

CREATE TABLE restaurant_payment (
    restaurant_id INT,
    payment_method_id INT,
    PRIMARY KEY (restaurant_id, payment_method_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method)
);

CREATE TABLE `order` (
    id_order INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    restaurant_id INT,
    value DECIMAL(5, 2),
    delivery_fee DECIMAL(5, 2),
    promotion_id INT,
    status_delivery_id INT,
    payment_method_id INT,
    observation VARCHAR(200),
    change DECIMAL(5, 2),
    address_id INT,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant),
    FOREIGN KEY (promotion_id) REFERENCES promotion(id_promotion),
    FOREIGN KEY (status_delivery_id) REFERENCES status_delivery(id_status_delivery),
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id_payment_method),
    FOREIGN KEY (address_id) REFERENCES address(id_address)
);

CREATE TABLE assessment (
    id_assessment INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    grade INT,
    order_id INT,
    restaurant_id INT,
    FOREIGN KEY (order_id) REFERENCES `order`(id_order),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id_restaurant)
);

CREATE TABLE order_product (
    id_order_product INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES `order`(id_order),
    FOREIGN KEY (product_id) REFERENCES product(id_product)
);

CREATE TABLE product_follow_up (
    product_id INT,
    follow_up_id INT,
    PRIMARY KEY (product_id, follow_up_id),
    FOREIGN KEY (product_id) REFERENCES product(id_product),
    FOREIGN KEY (follow_up_id) REFERENCES follow_up(id_follow_up)
);

CREATE TABLE order_product_follow_up (
    id_order_product_follow_up INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_product_id INT,
    follow_up_id INT,
    FOREIGN KEY (order_product_id) REFERENCES order_product(id_order_product),
    FOREIGN KEY (follow_up_id) REFERENCES follow_up(id_follow_up)
);
