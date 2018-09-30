select * from goods;
#unique;
show tables;
desc goods;

alter table client 
add unique(phone_number);

alter table goods 
add index(price);

alter table goods 
add key(vendor), add key(goods_name);

select * from goods group by production_date;

select count(*), goods_name from goods group by goods_name;
select count(*) from goods where production_date='2017-04-23';

select min(price) as min_price, max(price), avg(price) from goods;

select group_concat(goods_name separator ', ') as product_name, production_date from goods group by production_date;
select sum(price) from goods where production_date='2017-04-23';

select count(*),production_date from goods group by production_date  having count(*)>1;
select group_concat(goods_name separator ', ') as product_name, production_date from goods group by production_date having count(*)>1;

select * from goods where price>(select avg(price)from goods);

(select * from goods  where price>(select avg(price)from goods)) 
union
(select * from goods where goods_name like '%r%'); 


