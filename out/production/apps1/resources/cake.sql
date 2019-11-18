create table AssortmentCake
(
    assortment_cake_id   int auto_increment primary key,
    assortment_cake_name varchar(255) not null
);

create table Cake
(
    cake_id int auto_increment primary key,
    assortment_cake_id int not null,
    item_product_id int not null,

    foreign key (assortment_cake_id) references AssortmentCake(assortment_cake_id),
    foreign key (item_product_id) references ItemProduct(item_product_id)
);
/** вывод всего ассортимента */
select product_name, assortment_cake_name, product_description, product_image, weight, price  from Cake
INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id
JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id
;

/** вывод донатов */
select product_name, assortment_cake_name, product_description,
       product_image, weight, price  from Cake
INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id
JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id
where assortment_cake_name = 'донаты'
;




