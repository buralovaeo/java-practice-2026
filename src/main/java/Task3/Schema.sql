*Создание таблицы 
create table Product (
    id serial unique not null,
    name char(100) not null,
    price integer check(price > -1) not null
);

*Добавление данных
insert into Product (name, price) values ('Ноутбук', 15000);
insert into Product (name, price) values ('Телефон', 10000);
insert into Product (name, price) values ('Мышь', 1000);
insert into Product (name, price) values ('Телевизор', 20000);

*Получение данных
select * from Product;

*Удаление
drop table Product;