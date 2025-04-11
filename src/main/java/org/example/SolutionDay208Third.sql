-- medium #database
-- Time complexity is O(n^2), where n is the number of rows in the Delivery table
-- https://leetcode.com/problems/immediate-food-delivery-ii
-- init (MySQL)
Drop table if exists Delivery
Create table If Not Exists Delivery (delivery_id int, customer_id int, order_date date, customer_pref_delivery_date date)
Truncate table Delivery
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('1', '1', '2019-08-01', '2019-08-02')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('2', '2', '2019-08-02', '2019-08-02')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('3', '1', '2019-08-11', '2019-08-12')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('4', '3', '2019-08-24', '2019-08-24')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('5', '3', '2019-08-21', '2019-08-22')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('6', '2', '2019-08-11', '2019-08-13')
insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('7', '4', '2019-08-09', '2019-08-09')
-- solution (MySQL and PostgreSQL)
with customer_first_order as (
    select d.customer_id, min(d.order_date) as order_date
    from Delivery as d
    group by d.customer_id
)
select round(avg(case when c.order_date=d.customer_pref_delivery_date then 1 else 0 end)*100,2) as immediate_percentage
from Delivery as d
join customer_first_order as c on d.customer_id=c.customer_id and d.order_date = c.order_date