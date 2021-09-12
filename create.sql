create table role (
	id serial primary key,
	role text
);

create table users (
	id serial primary key,
	name text,
	role_id int references role(id)
);

create table item (
	id serial primary key,
	item text,
	users_id int references users(id)
);

create table rules (
	id serial primary key,
	rules text
);

create table role_rules_compose (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table comments (
	id serial primary key,
	comment text,
	item_id int references item(id)
);

create table attachs (
	id serial primary key,
	attachs text,
	item_id int references item(id)
);

create table category (
	id serial primary key,
	category text,
	item_id int references item(id)
);

create table state (
	id serial primary key,
	state text,
	item_id int references item(id)
	);