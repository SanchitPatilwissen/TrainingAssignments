create table EMPLOYEE(
	eid SERIAL PRIMARY KEY,
	ename varchar(20) not null,
	eage SMALLINT NOT NULL CHECK (AGE > 20 AND AGE <= 60),
	esalary DECIMAL(10, 2) not null,
	edesignation varchar(10) not null,
	edepartment varchar(10) not null
);

drop 