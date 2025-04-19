-- easy #database
-- Time complexity is O(n)
-- https://leetcode.com/problems/biggest-single-number
-- init (MySQL)
Drop table if exists MyNumbers
Create table If Not Exists MyNumbers (num int)
Truncate table MyNumbers
insert into MyNumbers (num) values ('8')
insert into MyNumbers (num) values ('8')
insert into MyNumbers (num) values ('3')
insert into MyNumbers (num) values ('3')
insert into MyNumbers (num) values ('1')
insert into MyNumbers (num) values ('4')
insert into MyNumbers (num) values ('5')
insert into MyNumbers (num) values ('6')
-- solution (PostgreSQL and MySQL)
select max(single_numbers.num) as num
from (select m.num
    from MyNumbers as m
    group by m.num
    having count(m.num)=1) as single_numbers