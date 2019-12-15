
/** Создание таблицы пользователей */
create table Users (
    user_id int auto_increment primary key,
    email_user varchar(255) not null,
    password_user varchar(255) not null,
    role_id int not null ,

    foreign key (role_id) references RoleUser(id_role)
);


