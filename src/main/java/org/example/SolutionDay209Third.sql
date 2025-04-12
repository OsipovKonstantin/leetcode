-- medium #database
-- Time complexity is O(n^2)
-- https://leetcode.com/problems/game-play-analysis-iv
-- init (MySQL)
Drop table if exists Activity
Create table If Not Exists Activity (player_id int, device_id int, event_date date, games_played int)
Truncate table Activity
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-01', '5')
insert into Activity (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-02', '6')
insert into Activity (player_id, device_id, event_date, games_played) values ('2', '3', '2017-06-25', '1')
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '1', '2016-03-02', '0')
insert into Activity (player_id, device_id, event_date, games_played) values ('3', '4', '2018-07-03', '5')
-- solution (H2). To use PostgreSQL we need to replace dateadd('DAY', 1, p.event_date) with "p.event_date + interval '1 day'
with player_first_entrance as (
    select a.player_id, min(a.event_date) as event_date
    from Activity as a
    group by a.player_id
)
select round(cast(count(distinct p.player_id) as decimal)/count(distinct a.player_id), 2) as fraction
from Activity as a
left join player_first_entrance as p on a.player_id = p.player_id and a.event_date=dateadd('DAY', 1, p.event_date)