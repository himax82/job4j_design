create table book(
	id serial primary key,
	name text,
	pages integer
);
create table reader(
	id serial primary key,
	name varchar(255),
	book_id int references book(id)
);

insert into book(name, pages) values ('Гарри Поттер', 612);
insert into reader(name, book_id) values ('Ivan', 1);

select * from reader;
