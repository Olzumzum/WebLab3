
/** Создание таблицы пользователей */
create table Users (
    user_id int auto_increment primary key,
    email_user varchar(255) not null,
    password_user varchar(255) not null
);
<<<<<<< HEAD:out/artifacts/apps1_war_exploded/WEB-INF/classes/resources/dbfile.sql

/** создать таблицу продукции*/
create table Product (
    product_id int auto_increment primary key,
    product_name varchar(255) not null
);

/*создать таблицу тортов */
create table Cake_Product(
    cake_id int auto_increment primary key,
    product_id int not null,
    product_name varchar(255) not null,
    description_product varchar(255),
    weight int not null,
    price int not null
)
=======
>>>>>>> listProduct:out/production/apps1/UserTable.sql
