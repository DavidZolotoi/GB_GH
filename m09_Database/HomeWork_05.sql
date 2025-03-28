-- показать таблицы
SELECT tablename
FROM pg_tables
WHERE schemaname = 'public';

/*---------------------------------------------------------------------*/

-- создать таблицу, если не существует
--DROP TABLE public.cars;	--раскомментировать для удаления
create table if not exists public.cars(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    cost INT
);
INSERT into
	public.cars (id, name, cost)
VALUES
	(1, 'Audi', 52642),
    (2, 'Mercedes', 57127),
    (3, 'Skoda', 9000 ),
    (4, 'Volvo', 29000),
	(5, 'Bentley', 350000),
    (6, 'Citroen', 21000), 
    (7, 'Hummer', 41400), 
    (8, 'Volkswagen', 21600);
SELECT * FROM public.cars;

/*--  Задание 1  --*/
-- Создайте представление, в которое попадут автомобили стоимостью  до 25 000 долларов
CREATE view
	low_cost_cars
AS
	SELECT id, name, cost
	FROM cars
	WHERE cost <= 25000;

/*--  Задание 2  --*/
-- Изменить в существующем представлении порог для стоимости: пусть цена будет до 30 000 долларов (используя оператор OR REPLACE) 
CREATE OR REPLACE view
	low_cost_cars
AS
	SELECT id, name, cost
	FROM cars
	WHERE cost <= 30000;

/*--  Задание 3  --*/
-- Создайте представление, в котором будут только автомобили марки “Skoda” и “Audi”
CREATE view
	skoda_audi_cars
AS
	SELECT *
	FROM cars
	WHERE name IN ('Skoda', 'Audi');

/*--  Задание 4  --*/
-- Добавьте новый столбец под названием «время до следующей станции».
-- Чтобы получить это значение, мы вычитаем время станций для пар смежных станций.
-- Мы можем вычислить это значение без использования оконной функции SQL, но это может быть очень сложно.
-- Проще это сделать с помощью оконной функции LEAD.
-- Эта функция сравнивает значения из одной строки со следующей строкой, чтобы получить результат.
-- В этом случае функция сравнивает значения в столбце «время» для станции со станцией сразу после нее.

-- создать таблицу, если не существует
--DROP TABLE public.train_shedule;	--раскомментировать для удаления
create table if not exists public.train_shedule(
    train_id INT,
	station VARCHAR(20),
	station_time TIME(0)
);
INSERT INTO train_shedule
  (train_id, station, station_time)
VALUES 
	(110, 'San Francisco', '10:00:00'),
    (110, 'Redwood City', '10:54:00'),
    (110, 'Paolo Alto', '11:02:00'),
    (110, 'San Jose', '12:35:00'),
    (120, 'San Francisco', '11:00:00'),
    (120, 'Paolo Alto', '12:49:00'),
    (120, 'San Jose', '13:30:00');
SELECT * FROM train_shedule;

select
	train_id,
	station,
	station_time,
    case when train_id = LEAD(train_id) OVER (PARTITION BY train_id ORDER BY train_id, station_time)
    THEN LEAD(station_time) OVER (PARTITION BY train_id ORDER BY train_id, station_time) - station_time
    ELSE NULL
    END AS difference
FROM train_shedule;

