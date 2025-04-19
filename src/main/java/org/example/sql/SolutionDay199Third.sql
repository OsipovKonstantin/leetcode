-- medium #database #inner join #having
-- Time complexity is O(n^2), where n is the number of the rows in the Employee table
-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports
-- init (MySQL)
Drop table Employee
Create table If Not Exists Employee (employeeId int, name varchar(255), department varchar(255), managerId int)
Truncate table Employee
insert into Employee (employeeId, name, department, managerId) values ('101', 'John', 'A', NULL)
insert into Employee (employeeId, name, department, managerId) values ('102', 'Dan', 'A', '101')
insert into Employee (employeeId, name, department, managerId) values ('103', 'James', 'A', '101')
insert into Employee (employeeId, name, department, managerId) values ('104', 'Amy', 'A', '101')
insert into Employee (employeeId, name, department, managerId) values ('105', 'Anne', 'A', '101')
insert into Employee (employeeId, name, department, managerId) values ('106', 'Ron', 'B', '101')
-- solution (PostgreSQL and MySQL)
select e2.name
from Employee as e1
inner join Employee as e2 on e1.managerId = e2.employeeId
group by e1.managerId, e2.name
having count(e1.managerId) >= 5