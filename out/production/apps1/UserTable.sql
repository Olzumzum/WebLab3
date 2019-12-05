
/** Создание таблицы пользователей */
create table Users (
    user_id int auto_increment primary key,
    email_user varchar(255) not null,
    password_user varchar(255) not null
);

insert into Users(email_user, password_user, role_id) value ( 'EMAIL', 'PASSWORD', 2);
