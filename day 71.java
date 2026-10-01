problem:183
problem name: Customers Who Never Order
category:easy
  SELECT name AS Customers
FROM Customers
WHERE id NOT IN (
    SELECT customerId
    FROM Orders
);

problem:596
problem name:Classes More Than 5 Students 
category:easy
  SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;
