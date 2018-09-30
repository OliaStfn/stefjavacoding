CREATE TABLE employee (
    employee_id INT(11) UNSIGNED AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    salary DOUBLE NOT NULL,
    address_id INT(11) UNSIGNED NOT NULL,
    PRIMARY KEY (employee_id),
    UNIQUE KEY address_id (address_id),
    CONSTRAINT FOREIGN KEY (address_id)
        REFERENCES addresses (address_id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE addresses (
    address_id INT(11) UNSIGNED AUTO_INCREMENT,
    address VARCHAR(50) NOT NULL,
    PRIMARY KEY(address_id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

truncate table employee;
alter table employee change address_id address_id int(11) unsigned not null unique;

insert into addresses values(null,'stusa 7a');
insert into employee values(
null,
'Olga',
20000,
(select address_id from addresses where address_id=1)
);

select * from addresses;

select e.name,e.salary,a.address from employee e natural join addresses a;

delete from employee where name='Olga';

