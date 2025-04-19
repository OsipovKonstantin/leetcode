-- easy #database
-- Time complexity is O(n*m)
-- https://leetcode.com/problems/product-sales-analysis-i
-- init (MySql)
Create table If Not Exists Sales (sale_id int, product_id int, years int, quantity int, price int)
Create table If Not Exists Product (product_id int, product_name varchar(10))
Truncate table Sales
insert into Sales (sale_id, product_id, years, quantity, price) values ('1', '100', '2008', '10', '5000')
insert into Sales (sale_id, product_id, years, quantity, price) values ('2', '100', '2009', '12', '5000')
insert into Sales (sale_id, product_id, years, quantity, price) values ('7', '200', '2011', '15', '9000')
Truncate table Product
insert into Product (product_id, product_name) values ('100', 'Nokia')
insert into Product (product_id, product_name) values ('200', 'Apple')
insert into Product (product_id, product_name) values ('300', 'Samsung')
-- solution
select p.product_name, s.years, s.price
from Sales as s
left join Product as p on s.product_id = p.product_id