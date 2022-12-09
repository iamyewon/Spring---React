use grp;

create table customer(
    id bigint not null auto_increment,
    username varchar(50),
    passwd varchar(200),
    email varchar(100),
    address varchar(100),
    contact varchar(30),
    primary key(id)
);