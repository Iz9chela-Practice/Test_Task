- use userdb;

-- create table users(id int primary key not null unique auto_increment, login varchar(60) not null, 
-- password varchar(60) not null,disk_Size int, user_file varchar(100), mail varchar(100));

-- create table user_file(id int primary key not null unique auto_increment, file_Text varchar(100), 
-- user_id int, foreign key (user_id) references users(id));

-- insert into users (login,password,disk_Size, user_File, mail) values
-- ("test1", "test1", 10, "test1", "test@gmail.com"),
-- ("test2", "test2", 0, "", "test@mail.com"),
-- ("test3", "test3", 0, "", "test@yandex.com");

-- update users set disk_size = 0 where login = "test2";

-- insert into user_file(file_text, user_id) values ("YOYOYOYO", 2)

-- drop table user_file;
-- drop table users;
