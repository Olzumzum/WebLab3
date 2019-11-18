
/** Создание таблицы пользователей */
create table Users (
    user_id int auto_increment primary key,
    email_user varchar(255) not null,
    password_user varchar(255) not null
);
