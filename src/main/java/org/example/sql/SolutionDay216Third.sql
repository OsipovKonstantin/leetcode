-- medium #database
-- Time complexity is O(n+m), where n and m are the sizes of Customer and Product tables, respectively
-- https://leetcode.com/problems/customers-who-bought-all-products
-- init (MySQL)
Drop table if exists Customer
Drop table if exists Product
Create table If Not Exists Customer (customer_id int, product_key int)
Create table Product (product_key int)
Truncate table Customer
insert into Customer (customer_id, product_key) values ('1', '5')
insert into Customer (customer_id, product_key) values ('2', '6')
insert into Customer (customer_id, product_key) values ('3', '5')
insert into Customer (customer_id, product_key) values ('3', '6')
insert into Customer (customer_id, product_key) values ('1', '6')
Truncate table Product
insert into Product (product_key) values ('5')
insert into Product (product_key) values ('6')
-- solution (PostgreSQL and MySQL)
select c.customer_id
from Customer as c
group by c.customer_id
having count(distinct c.product_key)=(select count(*) from Product as p)