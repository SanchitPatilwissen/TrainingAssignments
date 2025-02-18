CREATE TABLE authentication_details (
    id VARCHAR(10),
    name VARCHAR(20),
    password VARCHAR(255)
);

drop table authentication_details;

insert into authentication_details (id, name, password) values ('2021200089', 'Sanchit Patil', '123');

select * from authentication_details;