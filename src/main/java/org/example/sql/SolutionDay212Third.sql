-- medium #database
-- Time complexity is O(n^2)
-- https://leetcode.com/problems/product-sales-analysis-iii
-- init (MySQL)
Drop table if exists Sales
Drop table if exists Product
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
-- solution (MySQL and PostgreSQL)
with product_first_year as (
    select s.product_id, min(s.years) as years
    from Sales as s
    group by s.product_id
)
select s.product_id, s.years as first_year, s.quantity, s.price
from Sales as s
join product_first_year as p on p.product_id = s.product_id and p.years=s.years