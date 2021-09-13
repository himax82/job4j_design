create table teens (
	id serial primary key,
	name varchar(50),
	gender varchar(10)
);

insert into teens(name, gender) values ('Иван', 'Мужчина');
insert into teens(name, gender) values ('Анна', 'Женщина');
insert into teens(name, gender) values ('Егор', 'Мужчина');
insert into teens(name, gender) values ('Алена', 'Женщина');
insert into teens(name, gender) values ('Татьяна', 'Женщина');
insert into teens(name, gender) values ('Ульяна', 'Женщина');
insert into teens(name, gender) values ('Максим', 'Мужчина');

select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender != t2.gender;