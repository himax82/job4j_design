create table star_system (
	id serial primary key,
	name varchar(255)
);

create table star (
	id serial primary key,
	name varchar(255),
	spectrum varchar(255),
	star_system_id int references star_system(id)
);

insert into star_system(name) values ('Солнечная система');
insert into star_system(name) values ('a-Центавра');
insert into star_system(name) values ('Сириус');

insert into star(name, spectrum, star_system_id)
values ('Солнце', 'G2V', 1);
insert into star(name, spectrum, star_system_id)
values ('Проксима Центавра', 'М5', 2);
insert into star(name, spectrum, star_system_id)
values ('а-Центавра А', 'G2V', 2);
insert into star(name, spectrum, star_system_id)
values ('а-Центавра B', 'K1V', 2);
insert into star(name, spectrum, star_system_id)
values ('Сириус А', 'A1V', 3);
insert into star(name, spectrum, star_system_id)
values ('Сириус B', 'DA2', 3);

select ss.name, ss.spectrum, s.name from star as ss join star_system as s on ss.star_system_id = s.id;
select s.name, ss.name, ss.spectrum from star as ss join star_system as s on ss.star_system_id = s.id;
select s.name as Звездная_система, ss.name as Звезда, ss.spectrum as Излучаемый_спектр from star as ss join star_system as s on ss.star_system_id = s.id;