insert into role (role) values ('Admin');
insert into role (role) values ('Users');

insert into users (name, role_id) values ('Ivan', 1);
insert into users (name, role_id) values ('Petr', 2);

insert into item (item, users_id) values ('first', 1);
insert into item (item, users_id) values ('second', 2);

insert into rules (rules) values ('full');
insert into rules (rules) values ('limited');

insert into role_rules_compose (role_id, rules_id) values (1, 1);
insert into role_rules_compose (role_id, rules_id) values (2, 2);

insert into comments (comment, item_id) values ('tree', 1);
insert into comments (comment, item_id) values ('log', 2);

insert into attachs (attachs, item_id) values ('price', 1);
insert into attachs (attachs, item_id) values ('factura', 1);

insert into category (category, item_id) values ('urgent', 1);
insert into category (category, item_id) values ('ordinary', 2);

insert into state (state, item_id) values ('work', 1);
insert into state (state, item_id) values ('pause', 1);