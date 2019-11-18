create table ItemProduct
(
    item_product_id int auto_increment primary key,
    product_name varchar(255) not null,
    product_description varchar(255),
    product_image blob,
    weight int not null,
    price int not null
);