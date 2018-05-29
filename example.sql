
create database example;
use example;
create table product(
	`id` int(10) primary key,
	`name` nvarchar(30),
    `price` int,
    `comment` nvarchar(100)
    
)

select * from product;

insert into product values (1, 'TiVi', 15000000 , 'New'),(2, 'Dien Thoai',20000000,'New'),(3, 'Tu Lanh',23000000,'New'),(4, 'May Giat',23000000,'New'),(5, 'Laptop',20000000,'New'),(6, 'HeadPhone',2000000,'New');
insert into product values (99, 'ConDom', 150000 , 'New');
UPDATE product SET `name` = 'Mouse', `price` = 3333, `comment` = 'New' WHERE  `id` = 2;
DELETE FROM product WHERE  id = ?