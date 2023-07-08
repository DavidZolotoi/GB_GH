-- показать таблицы
SELECT tablename
FROM pg_tables
WHERE schemaname = 'public';

-- создать таблицу, если не существует
--DROP TABLE public.staff;	--раскомментировать для удаления
create table if not exists public.staff
(
    id		  	integer UNIQUE NOT NULL GENERATED ALWAYS AS IDENTITY,
    firstname 	VARCHAR(45),
    lastname 	VARCHAR(45),
    post 		VARCHAR(45),
    seniority 	integer, 
    salary 		DECIMAL(8,2),
    age 		integer
);

INSERT INTO staff (firstname, lastname, post, seniority, salary, age)
VALUES
 ('Вася', 'Петров', 'Начальник', 40, 100000, 60),
 ('Петр', 'Власов', 'Начальник', 8, 70000, 30),
 ('Катя', 'Катина', 'Инженер', 2, 70000, 25),
 ('Саша', 'Сасин', 'Инженер', 12, 50000, 35),
 ('Иван', 'Петров', 'Рабочий', 40, 30000, 59),
 ('Петр', 'Петров', 'Рабочий', 20, 55000, 60),
 ('Сидр', 'Сидоров', 'Рабочий', 10, 20000, 35),
 ('Антон', 'Антонов', 'Рабочий', 8, 19000, 28),
 ('Юрий', 'Юрков', 'Рабочий', 5, 15000, 25),
 ('Максим', 'Петров', 'Рабочий', 2, 11000, 19),
 ('Юрий', 'Петров', 'Рабочий', 3, 12000, 24),
 ('Людмила', 'Маркина', 'Уборщик', 10, 10000, 49);
 
SELECT * FROM staff;

/*-- Задание 1 --*/
-- Отсортируйте данные по полю заработная плата (salary) в порядке возрастания 
SELECT
	id,
    salary,
    CONCAT(firstname,' ', lastname) AS fullname
FROM staff
ORDER BY salary; -- DESC - по убыванию, по воз-ю - автоматически ставится ASC
-- Отсортируйте данные по полю заработная плата (salary) в порядке убывания 
SELECT
	id,
    salary,
    CONCAT(firstname,' ', lastname) AS fullname
FROM staff
ORDER BY salary DESC; -- DESC - по убыванию, по воз-ю - автоматически ставится asc

/*-- Задание 2 --*/
-- Выведите 5 максимальных заработных плат (saraly)
SELECT
	id,
    salary,
    CONCAT(firstname, ' ', lastname) AS fullname
FROM staff
ORDER BY salary DESC
LIMIT 5;

/*-- Задание 3 --*/
-- Посчитайте суммарную зарплату (salary) по каждой специальности (роst)
SELECT
	post as p,
    SUM(salary) AS sum 
FROM staff
GROUP BY post

/*-- Задание 4 --*/
-- Найдите кол-во сотрудников с специальностью (post) «Рабочий» в возрасте от 24 до 49 лет включительно.
SELECT
	post as p,
    COUNT(salary) AS count
FROM staff
WHERE post = 'Рабочий' and age >= 24 and age <= 49 -- Сработал до группировки
GROUP BY post;

/*-- Задание 5 --*/
-- Найдите количество специальностей
select
	COUNT(*) AS post_count
from
	(select	post FROM staff GROUP BY post) as post_unique;

/*-- Задание 6 --*/
-- Выведите  средний возрасты по специальностям
select
	post,
	AVG(age) as avg_age
FROM staff
GROUP BY post;
-- Выведите специальности, у которых средний возраст сотрудников меньше 30 лет
select
	post,
	AVG(age) as avg_age
FROM staff
GROUP BY post
having AVG(age) < 30;