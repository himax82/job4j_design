insert into item (item) values ('first');
insert into item (item) values ('second');

insert into users (name, item_id) values ('Ivan', 1);
insert into users (name, item_id) values ('Petr', 2);

insert into role (role, users_id) values ('Admin', 2);
insert into role (role, users_id) values ('Users', 1);

insert into rules (rules) values ('full');
insert into rules (rules) values ('limited');

insert into role_rules_compose (role_id, rules_id) values (1, 1);
insert into role_rules_compose (role_id, rules_id) values (2, 2);

insert into comments (coments, item_id) values ('tree', 1);
insert into comments (coments, item_id) values ('log', 2);

insert into attachs (attachs, item_id) values ('price', 1);
insert into attachs (attachs, item_id) values ('factura', 1);

insert into category (category, item_id) values ('urgent', 1);
insert into category (category, item_id) values ('ordinary', 2);

insert into state (state, item_id) values ('work', 1);
insert into state (state, item_id) values ('pause', 1);