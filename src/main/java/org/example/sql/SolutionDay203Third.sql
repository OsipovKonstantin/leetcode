-- easy #database
-- Time complexity is O(n*m) because of join (without index on foreign key)
-- https://leetcode.com/problems/project-employees-i
-- init (MySQL)
Drop table if exists Project
Drop table if exists Employee
Create table If Not Exists Project (project_id int, employee_id int)
Create table If Not Exists Employee (employee_id int, name varchar(10), experience_years int)
Truncate table Project
insert into Project (project_id, employee_id) values ('1', '1')
insert into Project (project_id, employee_id) values ('1', '2')
insert into Project (project_id, employee_id) values ('1', '3')
insert into Project (project_id, employee_id) values ('2', '1')
insert into Project (project_id, employee_id) values ('2', '4')
Truncate table Employee
insert into Employee (employee_id, name, experience_years) values ('1', 'Khaled', '3')
insert into Employee (employee_id, name, experience_years) values ('2', 'Ali', '2')
insert into Employee (employee_id, name, experience_years) values ('3', 'John', '1')
insert into Employee (employee_id, name, experience_years) values ('4', 'Doe', '2')
-- solution (PostgreSQL and MySQL)
select p.project_id, round(avg(e.experience_years), 2) as average_years
from Project as p
join Employee as e on p.employee_id = e.employee_id
group by p.project_id