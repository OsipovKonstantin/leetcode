-- medium #database
-- Time complexity is O(n)
-- https://leetcode.com/problems/monthly-transactions-i
-- init (MySQL)
Drop table if exists Transactions
Create table If Not Exists Transactions (id int, country varchar(4), state enum('approved', 'declined'), amount int, trans_date date)
Truncate table Transactions
insert into Transactions (id, country, state, amount, trans_date) values ('121', 'US', 'approved', '1000', '2018-12-18')
insert into Transactions (id, country, state, amount, trans_date) values ('122', 'US', 'declined', '2000', '2018-12-19')
insert into Transactions (id, country, state, amount, trans_date) values ('123', 'US', 'approved', '2000', '2019-01-01')
insert into Transactions (id, country, state, amount, trans_date) values ('124', 'DE', 'approved', '2000', '2019-01-07')
-- solution (H2 syntax due to different approaches for date and time formatting - here using formatdatetime function)
select formatdatetime(t.trans_date, 'yyyy-MM') as year_month, t.country, count(*) as trans_count,
count(case when t.state='approved' then 1 end) as approved_count, sum(t.amount) as trans_total_amount,
sum(case when t.state='approved' then t.amount else 0 end) as approved_total_amount
from Transactions as t
group by t.country, year_month