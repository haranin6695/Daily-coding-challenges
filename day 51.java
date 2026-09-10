problem:511
problem name:game play analysis I
category:easy
SELECT
    player_id,
    MIN(event_date) AS first_login
FROM activity
GROUP BY player_id;


problem:512
problem name:game play analysis II
category:easy
  SELECT player_id, MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;
