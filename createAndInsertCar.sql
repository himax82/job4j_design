create table body (
	id serial primary key,
	name varchar(50)
);

create table engine (
	id serial primary key,
	name varchar(50)
);

create table transmission (
	id serial primary key,
	name varchar(50)
);

create table car (
	id serial primary key,
	name varchar(50),
	body_id int references body(id) NOT NULL,
	engine_id int references engine(id) NOT NULL,
	transmission_id int references transmission(id) NOT NULL
);

insert into body(name) values ('Седан');
insert into body(name) values ('Универсал');
insert into body(name) values ('Минивен');
insert into body(name) values ('Внедорожник');

insert into engine(name) values ('Бензин');
insert into engine(name) values ('Дизель');
insert into engine(name) values ('Гибрид');

insert into transmission(name) values ('Автомат');
insert into transmission(name) values ('Механика');
insert into transmission(name) values ('Вариатор');

insert into car(name, body_id, engine_id, transmission_id) values ('Тойота Камри', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Лада Веста', 1, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Тойота Прадо', 4, 2, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('ВАЗ 2102', 2, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Ниссан Кашкай', 3, 1, 3);
insert into car(name, body_id, engine_id, transmission_id) values ('Тойота Приус', 2, 3, 3);

