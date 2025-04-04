-- easy #database
-- Time complexity is O(n*m), where n and m are the numbers of elements in the Employee and Bonus tables, respectively
-- https://leetcode.com/problems/employee-bonus
-- init (MySql)
Create table If Not Exists Employee (empId int, name varchar(255), supervisor int, salary int)
Create table If Not Exists Bonus (empId int, bonus int)
Truncate table Employee
insert into Employee (empId, name, supervisor, salary) values ('3', 'Brad', NULL, '4000')
insert into Employee (empId, name, supervisor, salary) values ('1', 'John', '3', '1000')
insert into Employee (empId, name, supervisor, salary) values ('2', 'Dan', '3', '2000')
insert into Employee (empId, name, supervisor, salary) values ('4', 'Thomas', '3', '4000')
Truncate table Bonus
insert into Bonus (empId, bonus) values ('2', '500')
insert into Bonus (empId, bonus) values ('4', '2000')
-- solution
select e.name, b.bonus
from Employee as e
left join Bonus as b on e.empId = b.empId
where bonus is null or bonus < 1000