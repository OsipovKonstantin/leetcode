-- easy #database
-- Time complexity is O(n)
-- https://leetcode.com/problems/invalid-tweets
-- init (MySql)
Create table If Not Exists Tweets(tweet_id int, content varchar(50))
Truncate table Tweets
insert into Tweets (tweet_id, content) values ('1', 'Let us Code')
insert into Tweets (tweet_id, content) values ('2', 'More than fifteen chars are here!')
-- solution
select t.tweet_id
from Tweets as t
where length(t.content)>15