create table library_card(
	id serial primary key,
	card_number integer
);

create table reader(
	id serial primary key,
	name varchar(255)
	library_card_id int references library_card(id) unique
);

insert into library_card(card_number) values (555);
insert into library_card(card_number) values (554);
insert into library_card(card_number) values (556);
insert into reader(name, library_card_id) values ('Иван', 1);
insert into reader(name, library_card_id) values ('Петр', 2);
insert into reader(name, library_card_id) values ('Максим', 3);

select * from reader;
select * from library_card;
