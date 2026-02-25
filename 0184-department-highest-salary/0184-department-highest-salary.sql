# Write your MySQL query statement below
select Department.name as Department, Employee.name as Employee, Employee.salary from Department
JOIN Employee
on Employee.departmentId = Department.id
where (departmentId,salary) in 
(select departmentId,MAX(salary) FROM Employee GROUP BY departmentId) ;

