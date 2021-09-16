insert into role (role) values ('Admin');
insert into role (role) values ('Users');

insert into category (category) values ('urgent');
insert into category (category) values ('ordinary');
insert into state (state) values ('work');
insert into state (state) values ('pause');

insert into users (name, role_id) values ('Ivan', 1);
insert into users (name, role_id) values ('Petr', 2);

insert into item (item, users_id, category_id, state_id) values ('first', 1, 2, 1);
insert into item (item, users_id, category_id, state_id) values ('second', 2, 1, 2);

insert into rules (rules) values ('full');
insert into rules (rules) values ('limited');

insert into role_rules_compose (role_id, rules_id) values (1, 1);
insert into role_rules_compose (role_id, rules_id) values (2, 2);

insert into comments (comment, item_id) values ('tree', 1);
insert into comments (comment, item_id) values ('log', 2);

insert into attachs (attachs, item_id) values ('price', 1);
insert into attachs (attachs, item_id) values ('factura', 1);

