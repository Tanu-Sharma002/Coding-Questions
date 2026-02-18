# Write your MySQL query statement below

select query_name, 
    ROUND (AVG(rating/position),2) as quality,
    ROUND (100*SUM(rating<3)/COUNT(*),2) as poor_query_percentage
    from Queries GROUP BY query_name;
