create table EMPLOYEE(
	eid SERIAL PRIMARY KEY,
	ename varchar(20) not null,
	eage SMALLINT NOT NULL CHECK (eage > 20 AND eage <= 60),
	esalary DECIMAL(10, 2) not null,
	edesignation varchar(10) not null,
	edepartment varchar(10) not null
);

select * from EMPLOYEE where ename like 'R%';
