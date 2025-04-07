-- easy #database
-- Time complexity is O(n)
-- https://leetcode.com/problems/queries-quality-and-percentage
-- init (MySQL)
Drop table If Exists Queries
Create table If Not Exists Queries (query_name varchar(30), result varchar(50), position int, rating int)
Truncate table Queries
insert into Queries (query_name, result, position, rating) values ('Dog', 'Golden Retriever', '1', '5')
insert into Queries (query_name, result, position, rating) values ('Dog', 'German Shepherd', '2', '5')
insert into Queries (query_name, result, position, rating) values ('Dog', 'Mule', '200', '1')
insert into Queries (query_name, result, position, rating) values ('Cat', 'Shirazi', '5', '2')
insert into Queries (query_name, result, position, rating) values ('Cat', 'Siamese', '3', '3')
insert into Queries (query_name, result, position, rating) values ('Cat', 'Sphynx', '7', '4')
-- solution (PostgreSQL and MySQL)
select q.query_name, round(avg(cast(q.rating as decimal)/q.position),2) as quality,
round(cast(count(case when q.rating < 3 then 1 end) as decimal)*100/count(q.query_name),2) as poor_query_percentage
from Queries as q
group by q.query_name