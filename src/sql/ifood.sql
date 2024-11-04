create table restaurant(
id_restaurant int not null primary key autoincrement,
name varchar(50),
foreign key (id_address) references address(id),
telephone varchar(12),
foreign key (category_id) references category(id),
operating_hour time,
picked tinyint(1)
);

create table category(
id_category int not null primary key autoincrement,
type varchar(50),
name varchar(25),
description varchar(200)
);

create table product(
id_product int not null primary key autoincrement,
name varchar(50),
description varchar(200),
price decimal(5, 2),
foreign key (category_id) references category(id),
foreign key (restaurant_id) references restaurant(id)
);

create table follow_up(
id_follow_up int not null primary key autoincrement,
name varchar(50),
description varchar(50),
value decimal(5, 2)
);

create table address(
id_address int not null primary key autoincrement,
road varchar(100),
neighborhood varchar(50),
city varchar(50),
state varchar(50),
number int,
complement varchar(50),
reference_point varchar(200),
zip_code varchar(10)
);

create table promotion(
id_promotion int not null primary key autoincrement,
name varchar(50),
code varchar(50),
type varchar(50),
value decimal(5, 2),
validity date
);

create table assessment(
id_assessment int not null primary key autoincrement,
grade int,
foreign key (order_id) references order(id),
foreign key (restaurant_id) references restaurant(id)
);

create table status_delivery(
id_status_delivery int not null primary key autoincrement,
name varchar(50)
)

create table product_follow_up(
foreign key (product_id) references product(id),
foreign key (follow_up_id) references follow_up(id)
);

create table payment_method(
id_payment_method int not null primary key autoincrement,
payment type varchar(50)
);

create table payment_history(
id_payment_history int not null primary key autoincrement,
date date,
foreign key (payment_method_id) references payment_method(id),
value decimal(5, 2)
);

create table delivery_history(
id_delivery_history int not null primary key autoincrement,
foreign key (status_delivery_id) references status_delivery(id),
foreign key (order_id) references order(id)

);

create table restaurant_payment(
foreign key (restaurant_id) references restaurant(id),
foreign key (payment_method_id) references payment_method(id)
);

create table order(
id_order int not null primary key autoincrement,
date date,
foreign key (restaurant_id) references restaurant(id),
value decimal(5, 2),
delivery_fee decimal(5, 2),
foreign key (promotion_id) references promotion(id),
foreign key (status_delivery_id) references status_delivery(id),
foreign key (payment_method_id) references payment_method(id),
observation varchar(200),
change decimal(5,2),
foreign key (address_id) references address(id)
);

create table order_product(
id_order_product int not null primary key autoincrement,
foreign key (order_id) references order(id)
foreign key (product_id) references product(id),
quantity int
);

create table order_product_follow_up(
id_order_product_follow_up int not null primary key autoincrement,
foreign key (order_product_id) references order_product(id),
foreign key (follow_up_id) references follow_up(id)
);