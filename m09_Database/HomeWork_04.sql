-- показать таблицы
SELECT tablename
FROM pg_tables
WHERE schemaname = 'public';

-- создать таблицу, если не существует
--DROP TABLE public.shops;	--раскомментировать для удаления
create table if not exists public.shops(
    id SERIAL PRIMARY KEY,
    shopname VARCHAR(100)
);
INSERT into
	public.shops (shopname)
VALUES
	('Четыре лапы'),
    ('Мистер Зоо'),
    ('МурзиЛЛа'),
    ('Кошки и собаки');
SELECT * FROM public.shops;

-- создать таблицу, если не существует
--DROP TABLE public.cats;	--раскомментировать для удаления
CREATE TABLE public.cats (
    name VARCHAR(100),
    id SERIAL PRIMARY KEY,
    shops_id INT,
    CONSTRAINT fk_cats_shops_id FOREIGN KEY (shops_id) REFERENCES public.shops (id)
);
INSERT into
	public.cats
VALUES 
	('Murzik',1,1),
    ('Nemo',2,2),
    ('Vicont',3,1),
    ('Zuza',4,3);
SELECT * FROM public.cats;

/*-- Задание 1 --*/
--Используя JOIN вывести всех котиков по магазинам по id (условие соединения shops.id = cats.shops_id)
select public.shops.shopname, public.cats.name
from public.shops
inner join public.cats on public.shops.id = public.cats.shops_id ;

/*-- Задание 2 --*/
--Используя JOIN вывести магазин, в котором продается кот “Мурзик” (попробуйте выполнить 2 способами)
/*-- Вариант 1 --*/
select public.shops.shopname
from public.shops
inner join public.cats on public.shops.id = public.cats.shops_id and public.cats.name = 'Murzik';
/*-- Вариант 1 --*/
select public.shops.shopname
from public.shops
inner join public.cats on public.shops.id = public.cats.shops_id
where public.cats.name = 'Murzik';

/*-- Задание 3 --*/
--Используя JOIN вывести магазины, в которых НЕ продаются коты “Мурзик” и “Zuza”
SELECT s.*
FROM public.shops s
LEFT JOIN public.cats c ON s.id = c.shops_id  AND (c.name = 'Murzik' or c.name = 'Zuza')
WHERE c.shops_id IS NULL;
--с помощью подзапроса: найти все id магазинов, в которых есть Мурзик и Зуза, а потом найти все id магазинов не из этого списка
SELECT *
FROM public.shops
WHERE id NOT IN (
    SELECT shops_id
    FROM public.cats
    WHERE name = 'Murzik' or name = 'Zuza'
);

/*---------------------------------------------------------------------*/
/*--  Задание 4  --*/

--DROP TABLE public.Analysis;	--раскомментировать для удаления
create table if not exists public.Analysis(
    an_id SERIAL PRIMARY KEY,
	an_name varchar(50),
	an_cost INT,
	an_price INT,
	an_group INT
);
INSERT into
	public.analysis (an_name, an_cost, an_price, an_group)
VALUES 
	('Общий анализ крови', 30, 50, 1),
	('Биохимия крови', 150, 210, 1),
	('Анализ крови на глюкозу', 110, 130, 1),
	('Общий анализ мочи', 25, 40, 2),
	('Общий анализ кала', 35, 50, 2),
	('Общий анализ мочи', 25, 40, 2),
	('Тест на COVID-19', 160, 210, 3);
SELECT * FROM public.analysis;

--DROP TABLE public.groupsan;	--раскомментировать для удаления
create table if not exists public.groupsan(
    gr_id SERIAL PRIMARY KEY,
    gr_name varchar(50),
    gr_temp NUMERIC(5,1),
    FOREIGN KEY (gr_id) REFERENCES Analysis (an_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT into
	groupsan (gr_name, gr_temp)
VALUES 
	('Анализы крови', -12.2),
	('Общие анализы', -20.0),
	('ПЦР-диагностика', -20.5);
SELECT * FROM groupsan;

--DROP TABLE public.Orders;	--раскомментировать для удаления
create table if not exists public.Orders(
	ord_id SERIAL PRIMARY KEY,
	ord_datetime timestamp,	-- 'YYYY-MM-DD hh:mm:ss'
	ord_an INT,
	FOREIGN KEY (ord_an) REFERENCES Analysis (an_id)
		ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO public.Orders (ord_datetime, ord_an)
VALUES 
	('2020-02-04 07:15:25', 1),
	('2020-02-04 07:20:50', 2),
	('2020-02-04 07:30:04', 1),
	('2020-02-04 07:40:57', 1),
	('2020-02-05 07:05:14', 1),
	('2020-02-05 07:15:15', 3),
	('2020-02-05 07:30:49', 3),
	('2020-02-06 07:10:10', 2),
	('2020-02-06 07:20:38', 2),
	('2020-02-07 07:05:09', 1),
	('2020-02-07 07:10:54', 1),
	('2020-02-07 07:15:25', 1),
	('2020-02-08 07:05:44', 1),
	('2020-02-08 07:10:39', 2),
	('2020-02-08 07:20:36', 1),
	('2020-02-08 07:25:26', 3),
	('2020-02-09 07:05:06', 1),
	('2020-02-09 07:10:34', 1),
	('2020-02-09 07:20:19', 2),
	('2020-02-10 07:05:55', 3),
	('2020-02-10 07:15:08', 3),
	('2020-02-10 07:25:07', 1),
	('2020-02-11 07:05:33', 1),
	('2020-02-11 07:10:32', 2),
	('2020-02-11 07:20:17', 3),
	('2020-02-12 07:05:36', 1),
	('2020-02-12 07:10:54', 2),
	('2020-02-12 07:20:19', 3),
	('2020-02-12 07:35:38', 1);
SELECT * FROM public.Orders;

--Вывести название и цену для всех анализов, которые продавались 5 февраля 2020 и всю следующую неделю.
--ПОДРОБНО ВСЕ АНАЛИЗЫ ЗА ЭТОТ ПРОМЕЖУТОК
select ord_datetime, gr_name, an_name, ord_id, an_price
from public.orders o 
inner join (
	select *
	from public.analysis a
	inner join public.groupsan g on g.gr_id = a.an_group) as report
on o.ord_an = report.an_id -- o.ord_an = report.an_group
where ord_datetime >= '2020-02-05 00:00:00' and ord_datetime <= '2020-02-11 23:59:59'	-- с начла 5 по конец 11-го числа - это 7 дней
order by ord_datetime;
--ТОЛЬКО НАЗВАНИЕ И ЦЕНА ЗА ЭТОТ ПРОМЕЖУТОК
select an_name, an_price
from public.orders o 
inner join (
	select *
	from public.analysis a
	inner join public.groupsan g on g.gr_id = a.an_group) as report
on o.ord_an = report.an_id -- o.ord_an = report.an_group
where ord_datetime >= '2020-02-05 00:00:00' and ord_datetime <= '2020-02-11 23:59:59'	-- с начла 5 по конец 11-го числа - это 7 дней
group by an_name, an_price;



