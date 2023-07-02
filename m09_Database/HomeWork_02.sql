-- показать таблицы
SELECT tablename
FROM pg_tables
WHERE schemaname = 'public';

/*-- Задание 1 --*/

-- создать таблицу, если не существует
CREATE TABLE if not exists public.sales (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	order_date timestamp NULL,
	count_product integer NULL
);

-- удаление таблицы
--DROP TABLE public.sales;

-- добавление строк
INSERT INTO public.sales
(order_date, count_product)
VALUES
('2022-01-01 10:30:00', 156),
('2022-01-02 10:30:00', 180),
('2022-01-03 10:30:00', 21),
('2022-01-04 10:30:00', 124),
('2022-01-05 10:30:00', 341);

-- показать полностью таблицу
SELECT * FROM public.sales;

/* Для данных таблицы “sales” укажите тип заказа в зависимости от кол-ва : 
меньше 100  -    Маленький заказ
от 100 до 300 - Средний заказ
больше 300  -     Большой заказ */
SELECT id,
case
	when count_product < 100
			then 'Маленький заказ'
	when (count_product >= 100) and (count_product < 300)
			then 'Средний заказ'
	when count_product >= 300
			then 'Большой заказ'
end as Order_type
FROM public.sales;

/*-- Задание 2 --*/

-- создать таблицу, если не существует
CREATE TABLE if not exists public.orders (
	id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
	employee_id varchar(5) NULL,
	amount decimal NULL,
	order_status varchar(20) NULL
);

-- добавление строк
INSERT INTO public.orders
(employee_id, amount, order_status)
VALUES
('e03',	15.00,	'OPEN'),
('e01',	25.50,	'OPEN'),
('e05',	100.70,	'CLOSED'),
('e02',	22.18,	'OPEN'),
('e04',	9.50,	'CANCELLED');

-- показать полностью таблицу
SELECT * FROM public.orders;

-- создание колонки с применением условий
SELECT id, 
case
	when order_status = 'OPEN'
			then 'Order is in open state'
	when order_status = 'CLOSED'
			then 'Order is closed'
	when order_status = 'CANCELLED'
			then 'Order is cancelled'
end as full_order_status
from public.orders;

/*-- Задание 3 --*/

--DROP TABLE public.users;
create table if not exists users
(
    id    integer UNIQUE NOT NULL GENERATED ALWAYS AS IDENTITY,
    login varchar(255),
    pass  varchar(255),
    male  integer 
);

INSERT INTO users (login, pass, male) VALUES ('alex', '$2y$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO users (login, pass, male) VALUES ('Mikle', '$ws$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO users (login, pass, male) VALUES ('Olia', '$2y$10$88zbBCKLJklStIgTqBKIluijJUnbeZ5WqJI4RJgkksnFZon5kH14y', 2);
INSERT INTO users (login, pass, male) VALUES ('Tom', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH20y', 1);
INSERT INTO users (login, pass, male) VALUES ('Margaret', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ4wqIu4RJgkksnFZon5kH20y', 2);
INSERT INTO users (login, pass, male) VALUES ('alex', '$2y$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO users (login, pass, male) VALUES ('Tom', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH20y', 1);

SELECT * FROM public.users;

--

--DROP TABLE public.clients;
create table if not exists clients
(
    id    integer unique NOT NULL GENERATED ALWAYS AS IDENTITY,
    login varchar(255),
    pass  varchar(255),
    male  integer      
);

INSERT INTO clients (login, pass, male) VALUES ('alexander', '$2y$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Mikle', '$ws$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Olia', '$2y$10$88zbBCKLJklStIgTqBKIluijJUnbeZ5WqJI4RJgkksnFZon5kH14y', 2);
INSERT INTO clients (login, pass, male) VALUES ('Dmitry', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH20y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Margaret', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ4wqIu4RJgkksnFZon5kH20y', 2);
INSERT INTO clients (login, pass, male) VALUES ('Leonid', '$2y$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Mikle', '$ws$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Olga', '$2y$10$88zbBCKLJklStIgTqBKIluijJUnbeZ5WqJI4RJgkksnFZon5kH14y', 2);
INSERT INTO clients (login, pass, male) VALUES ('Tom', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH20y', 1);
INSERT INTO clients (login, pass, male) VALUES ('Masha', '$2y$20$6SzbBCNRNklStIgTqBKIluijJUnbeZ4wqIu4RJgkksnFZon5kH20y', 2);
INSERT INTO clients (login, pass, male) VALUES ('alex', '$2y$10$6SzbBCMENklStIgTqBKIluijJUnbeZ5WqIu4RJgkksnFZon5kH14y', 1);

SELECT * FROM public.clients;

--

--DROP TABLE public.posts;
create table if not exists posts
(
    id		  integer UNIQUE NOT NULL GENERATED ALWAYS AS IDENTITY,
    title     varchar(255),
    full_text text,
    user_id   integer
);

INSERT INTO posts (title, full_text, user_id) VALUES ('lorem ipsum', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 1);
INSERT INTO posts (title, full_text, user_id) VALUES ('Why do we use it?', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 2);
INSERT INTO posts (title, full_text, user_id) VALUES ('Where does it come from?', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', 3);
INSERT INTO posts (title, full_text, user_id) VALUES ('Where can I get some?', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don''t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn''t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.', 4);
INSERT INTO posts (title, full_text, user_id) VALUES ('Mauris fermentum', 'Mauris fermentum sapien feugiat, facilisis augue ac, volutpat eros. Vestibulum faucibus urna arcu, eget dignissim libero varius ut. Etiam sit amet massa elit. Aliquam vitae tellus turpis. Vivamus tempor at odio vitae ullamcorper. Vivamus elementum fermentum mauris nec bibendum. Etiam ut felis eu purus fermentum fringilla eu nec lectus. Pellentesque porta eros sit amet lectus semper, at tristique leo interdum. Duis in elementum odio. Morbi at ultrices velit. Vestibulum ut dui lacus.', 5);
INSERT INTO posts (title, full_text, user_id) VALUES ('Vivamus sagittis dolor', 'Vivamus sagittis dolor eget finibus consequat. Duis imperdiet aliquam felis, sed auctor libero finibus eu. Duis sodales nisi ut semper accumsan. Aliquam ultricies nec sapien eu eleifend. Etiam ultricies, sem non eleifend tincidunt, dui lacus viverra felis, eget pulvinar sem diam ac nibh. Vestibulum hendrerit, ante eu porttitor viverra, elit nulla gravida ex, nec scelerisque purus magna malesuada turpis. Fusce eu nunc condimentum augue malesuada cursus vitae pulvinar leo. Fusce semper et risus at congue. Nullam tristique ac mauris sed tristique. Donec eu dolor non mi rutrum pulvinar quis quis ex. Nulla efficitur odio vel turpis iaculis volutpat. Proin aliquam blandit purus, at eleifend felis ullamcorper vitae.', 6);
INSERT INTO posts (title, full_text, user_id) VALUES ('Aenean aliquam', 'Aenean aliquam sem ut tristique commodo. Aenean sed tincidunt elit, nec consectetur est. Phasellus sagittis erat non mi dignissim semper. Donec libero eros, sodales eu sapien eget, rhoncus viverra urna. Donec augue magna, faucibus at metus in, fringilla consequat sem. Etiam iaculis sagittis feugiat. Etiam eleifend ipsum vulputate mi egestas imperdiet. Duis consectetur diam pulvinar lectus pulvinar, a scelerisque dolor sodales. Aliquam at velit et sapien viverra dignissim.', 7);
INSERT INTO posts (title, full_text, user_id) VALUES ('Etiam ornare', 'Etiam ornare augue vitae leo bibendum tristique. Nam libero augue, fermentum eu velit at, ultricies varius ligula. Nam mi nisl, tristique sed enim imperdiet, blandit aliquet velit. Mauris ullamcorper sodales urna vitae venenatis. Integer diam dolor, efficitur in orci in, semper bibendum nulla. Morbi at mattis odio. Donec rhoncus, sem eget varius aliquet, mauris magna egestas lectus, eget gravida ante justo sed urna.', 2);
INSERT INTO posts (title, full_text, user_id) VALUES ('Sed ac ultricies eros', 'Sed ac ultricies eros. Aliquam vulputate quam turpis, quis vestibulum sem pretium nec. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus commodo, velit vitae varius bibendum, elit metus lacinia ligula, sed finibus mauris dui a orci. Praesent viverra erat ut faucibus tristique. Vestibulum eu nisl quam. Vivamus nunc turpis, pretium quis elit et, condimentum varius dolor. Fusce aliquet consequat lorem ac gravida. Praesent arcu nisl, euismod at velit et, placerat tempor justo. Duis non faucibus enim. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris eu semper ligula.', 3);

SELECT * FROM public.posts;

--

-- Используя оператор ALTER TABLE, установите внешний ключ users-posts
ALTER TABLE posts
ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
REFERENCES users (id);

SELECT * FROM public.posts;

--

-- Без оператора JOIN, верните заголовок публикации, текст с описанием, идентификатор клиента, опубликовавшего публикацию и логин данного клиента.
select
	p.title,
	p.full_text,
	p.user_id,
	(select u.login FROM public.users u WHERE u.id = p.user_id) AS login
FROM public.posts p;

-- Выполните поиск по публикациям, автором которых является клиент "Mikle".
select
	u.login,
	p.title,
	p.full_text
FROM users u INNER JOIN posts p
on (u.id = p.user_id) and  (u.login = 'Mikle');





