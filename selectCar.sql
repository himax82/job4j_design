select c.name as Модель, d.name as Кузов, e.name as Двигатель, t.name as Трансмиссия
from car c left join body d on c.body_id = d.id
left join engine e on c.body_id = e.id
left join transmission t on c.body_id = t.id;

select b.name from body b left join car c on b.id = c.body_id where c.body_id is Null;
select e.name from engine e left join car c on e.id = c.engine_id where c.body_id is Null;
select t.name from transmission t left join car c on t.id = c.transmission_id where c.body_id is Null;