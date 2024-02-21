-- колонка `status` будет заполняться из `enum TaskStatus {NOT_STARTED, IN_PROGRESS, COMPLETED;}`
insert into sometasks (description, status)
values ('Задача из долгого ящика', 0); --'NOT_STARTED');

insert into sometasks (description, status)
values ('Задача в процессе', 1); -- 'IN_PROGRESS');

insert into sometasks (description, status)
values ('Задача выполненв', 2); -- 'COMPLETED');