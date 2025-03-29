-- easy #database
-- Time complexity is O(n)
-- https://leetcode.com/problems/not-boring-movies
-- init (MySQL)
Create table If Not Exists Cinema (id int, movie varchar(255), description varchar(255), rating decimal(2, 1))
Truncate table cinema
insert into Cinema (id, movie, description, rating) values ('1', 'War', 'great 3D', '8.9')
insert into Cinema (id, movie, description, rating) values ('2', 'Science', 'fiction', '8.5')
insert into Cinema (id, movie, description, rating) values ('3', 'irish', 'boring', '6.2')
insert into Cinema (id, movie, description, rating) values ('4', 'Ice song', 'Fantacy', '8.6')
insert into Cinema (id, movie, description, rating) values ('5', 'House card', 'Interesting', '9.1')
-- solution
SELECT *
FROM Cinema as c
WHERE c.id%2=1 and c.description !='boring'
ORDER BY c.rating DESC