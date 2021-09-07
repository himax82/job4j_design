create table book(
	id serial primary key,
	name text,
	pages integer
);
create table reader(
	id serial primary key,
	name varchar(255)
);

create table libr(
	id serial primary key,
	reader_id int references reader(id),
	book_id int references book(id)
);

insert into book(name, pages) values ('Гарри Поттер', 612);
insert into book(name, pages) values ('Властелин колец', 1028);
insert into book(name, pages) values ('Песнь льда и пламени', 1325);
insert into reader(name) values ('Иван');
insert into reader(name) values ('Петр');
insert into reader(name) values ('Евгений');

insert into libr(reader_id, book_id) values (1, 3);
insert into libr(reader_id, book_id) values (1, 2);
insert into libr(reader_id, book_id) values (2, 1);
insert into libr(reader_id, book_id) values (3, 3);

select * from libr;
select * from reader;
