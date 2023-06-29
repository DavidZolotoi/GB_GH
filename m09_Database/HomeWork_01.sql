/* 
 * USE в основном относится к MySQL. Вот отрывок из чата с ChatGPT:
 * Обычно для подключения к конкретной базе данных в SQL-запросах используется строка подключения, 
 * определенная в настройках клиента или приложения, а не команды SQL.
*/

-- показать базы
SELECT datname FROM pg_catalog.pg_database;

-- создание и удаление БД
CREATE DATABASE phone_db;
DROP DATABASE IF EXISTS phone_db;

-- показать таблицы
SELECT tablename
FROM pg_tables
WHERE schemaname = 'public';

-- удалить если существует
-- DROP TABLE IF EXISTS public.phones;
-- создать таблицу, если не существует
CREATE TABLE IF NOT EXISTS public.phones (
	id int NOT NULL GENERATED ALWAYS AS IDENTITY,
	productname varchar(45) NULL,
	manufacturer varchar(45) NULL,
	productcount int NULL,
	price decimal null
);

-- добавление строк
INSERT INTO public.phones
(productname, manufacturer, productcount, price)
values
('iPhone X', 'Apple', 3, 76000),
('iPhone8', 'Apple', 2, 51000),
('Galaxy S9', 'Samsung', 2, 56000),
('Galaxy S8', 'Samsung', 1, 41000),
('P 20 Pro', 'Huawei', 5, 36000);

-- показать полностью таблицу
SELECT * FROM public.phones;

-- Выведите название, производителя и цену для товаров,
-- количество которых превышает 2 (SQL - файл, скриншот, либо сам код)
select manufacturer, price
from public.phones
where productcount > 2;

-- Выведите весь ассортимент товаров марки “Samsung”
select *
from public.phones
where manufacturer  = 'Samsung';

-- Выведите информацию о телефонах, где суммарный чек больше 100 000 и меньше 145 000**
select manufacturer, sum(price) as summa
from public.phones
group by manufacturer
having sum(price) > 100000 and sum(price) < 145000;
