-- easy #database
-- Time complexity is O(n*m), where n and m are the number of rows in tables Prices and UnitsSold, respectively
-- https://leetcode.com/problems/average-selling-price
-- init (MySQL)
Drop table if exists Prices
Drop table if exists UnitsSold
Create table If Not Exists Prices (product_id int, start_date date, end_date date, price int)
Create table If Not Exists UnitsSold (product_id int, purchase_date date, units int)
Truncate table Prices
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-02-17', '2019-02-28', '5')
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-03-01', '2019-03-22', '20')
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-01', '2019-02-20', '15')
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-21', '2019-03-31', '30')
Truncate table UnitsSold
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-02-25', '100')
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-03-01', '15')
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-02-10', '200')
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-03-22', '30')
-- solution (PostgreSQL and MySQL)
select p.product_id, coalesce(round(cast(sum(us.units*p.price) as decimal) /sum(us.units), 2),0) as average_price
from Prices as p
left join UnitsSold as us on p.product_id = us.product_id and us.purchase_date between p.start_date and p.end_date
group by p.product_id