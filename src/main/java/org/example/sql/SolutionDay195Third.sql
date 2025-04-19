-- easy #database
-- Time complexity is O(n^2) without an index. With an index on the recordDate column the time complexity is O(nlogn)
-- https://leetcode.com/problems/rising-temperature
-- init (MySql)
Create table If Not Exists Weather (id int, recordDate date, temperature int)
Truncate table Weather
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')
-- solution
select w.id as Id
from Weather as w
left join Weather as w2 on w.recordDate=w2.recordDate + 1
where w.temperature>w2.temperature