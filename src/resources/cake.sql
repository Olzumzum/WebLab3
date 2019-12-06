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
select item_product_id, product_name, assortment_cake_name, product_description,
       product_image, weight, price  from Cake
INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id
JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id
where assortment_cake_name = 'донаты'
;

/**поиск по имени продукции */
select product_name, assortment_cake_name, product_description,
       product_image, weight, price  from Cake
                                              INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id
                                              JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id
where product_name = 'Донат очень круглый'
and
      assortment_cake_name = 'донаты';
;

insert into ItemProduct(product_name, product_description, product_image, weight, price)
value ('name', 'ddddd', null, 5, 4);

insert into Cake(assortment_cake_id, item_product_id) VALUE (1,5);

select assortment_cake_id from AssortmentCake
where assortment_cake_name = 'Донаты';


select * from


