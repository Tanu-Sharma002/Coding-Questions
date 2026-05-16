# Write your MySQL query statement below
select p.product_name,sum(o.unit) as unit from Products p
join Orders o 
USING(product_id)
WHERE o.order_date >= "2020-02-01"
  AND o.order_date <= "2020-02-29"
GROUP BY product_id
HAVING unit >= 100;
