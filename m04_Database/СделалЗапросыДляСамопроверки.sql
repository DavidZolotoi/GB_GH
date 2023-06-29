create table People (Id int, LFname text, Date text, Status text)
insert into People values (1, 'Иванов И. И.', '12.02.1990', 'женат')
insert into People values (2, 'Иванов И. И.', '18.09.2001', 'холост')
insert into People values (3, 'Петров П. П.', '23.04.1983', 'женат')
insert into People values (4, 'Васильев В. В.', '21.05.1998', 'холост')
insert into People values (25, 'Кузьмин К.К.', '21.05.2020', 'холост')
select * from People

create table Adres (Chei int, Adres text, Coment text)
insert into Adres values (1, 'Можга', 'Место рождения')
insert into Adres values (1, 'Казань', 'По прописке')
insert into Adres values (1, 'Москва', 'Рабочий')
insert into Adres values (2, 'Санкт-Петербург', 'По прописке')
insert into Adres values (3, 'Москва', 'По прописке')
insert into Adres values (4, 'Белгород', 'По прописке')
insert into Adres values (5, 'Уфа', 'По прописке')
insert into Adres values (6, 'Сочи', 'По прописке')
insert into Adres values (7, 'Киров', 'Рабочий')
insert into Adres values (8, 'Владивосток', 'Место рождения')
insert into Adres values (9, 'Рязань', 'Рабочий')
insert into Adres values (10, 'Хабаровск', 'Место рождения')
select * from Adres

select * from People INNER JOIN Adres ON Id = Chei
select * from People LEFT JOIN Adres ON Id = Chei
select * from People RIGHT JOIN Adres ON Id = Chei
select * from People FULL JOIN Adres ON Id = Chei
SELECT LFname, Adres, Coment FROM People RIGHT JOIN Adres ON Id = Chei
