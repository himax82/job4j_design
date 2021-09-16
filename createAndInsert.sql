create table departmens (
	id serial primary key,
	name varchar(50)
);

create table emploers (
	id serial primary key,
	name varchar(50),
	departmens_id int references departmens(id)
);

insert into departmens(name) values ('Здравоохранения');
insert into departmens(name) values ('Образования');
insert into departmens(name) values ('Культуры');
insert into departmens(name) values ('Сельского хозяйства');
insert into departmens(name) values ('По охране окружающей среды');

insert into emploers(name, departmens_id) values ('Иван', 1);
insert into emploers(name, departmens_id) values ('Евгений', 2);
insert into emploers(name, departmens_id) values ('Игорь', 3);
insert into emploers(name, departmens_id) values ('Максим', 4);
insert into emploers(name, departmens_id) values ('Руслан', 5);
insert into emploers(name, departmens_id) values ('Михаил', 2);
insert into emploers(name, departmens_id) values ('Денис', 1);
insert into emploers(name, departmens_id) values ('Владимир', 3);
insert into emploers(name, departmens_id) values ('Егор', 5);
insert into emploers(name, departmens_id) values ('Андрей', 1);