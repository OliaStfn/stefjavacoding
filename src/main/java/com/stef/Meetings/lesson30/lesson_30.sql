show tables;
desc goods;
alter table goods
change name
goods_name varchar(30);
select * from goods;
insert into goods values(null,'salat','30','NEW YORK PIZZA',curdate(),adddate(curdate(),2));
update goods set vendor='new york pizza' where id=last_insert_id();
update goods set price=20 where production_date='2017-04-23' limit 2;
delete from goods where goods_name='burger' and price!=20 and production_date!='2017-04-23';
truncate table gooods;


