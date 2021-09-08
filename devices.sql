create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Мышка', 350);
insert into devices(name, price) values ('Клавиатура', 475);
insert into devices(name, price) values ('Монитор', 8970);
insert into devices(name, price) values ('системный блок', 27750);
insert into devices(name, price) values ('Вебкамера', 1300);
insert into devices(name, price) values ('Ноутбук', 34120);
insert into devices(name, price) values ('Геймпад', 1900);
insert into devices(name, price) values ('Принтер', 6120);
insert into devices(name, price) values ('Сканер', 4700);

insert into people(name) values ('Иван');
insert into people(name) values ('Егор');
insert into people(name) values ('Петр');
insert into people(name) values ('Максим');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (4, 1);
insert into devices_people(device_id, people_id) values (7, 1);
insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (3, 2);
insert into devices_people(device_id, people_id) values (4, 2);
insert into devices_people(device_id, people_id) values (5, 2);
insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (6, 3);
insert into devices_people(device_id, people_id) values (1, 4);
insert into devices_people(device_id, people_id) values (2, 4);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (4, 4);
insert into devices_people(device_id, people_id) values (8, 4);
insert into devices_people(device_id, people_id) values (9, 4);

select avg(price) from devices;

select ss.people_id, avg(s.price) from devices_people
as ss join devices s on ss.device_id = s.id group by ss.people_id;

select ss.people_id, avg(s.price) from devices_people
as ss join devices s on ss.device_id = s.id group by ss.people_id
having avg(s.price) > 8000;

