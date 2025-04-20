-- easy #database
-- Time complexity is O(nlogn) because primary key has B-Tree index by default
-- https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee
-- init (MySQL)
Drop table if exists Employees
Create table If Not Exists Employees(employee_id int, name varchar(20), reports_to int, age int)
Truncate table Employees
insert into Employees (employee_id, name, reports_to, age) values ('9', 'Hercy', NULL, '43')
insert into Employees (employee_id, name, reports_to, age) values ('6', 'Alice', '9', '41')
insert into Employees (employee_id, name, reports_to, age) values ('4', 'Bob', '9', '36')
insert into Employees (employee_id, name, reports_to, age) values ('2', 'Winston', NULL, '37')
-- solution (PostgreSQL and MySQL)
select m.employee_id, m.name, count(m.employee_id) as reports_count, round(avg(e.age)) as average_age
from Employees as e
join Employees as m on e.reports_to = m.employee_id
group by m.employee_id, m.name
order by m.employee_id