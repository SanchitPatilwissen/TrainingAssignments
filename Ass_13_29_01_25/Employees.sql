create table EMPLOYEE(
	eid SERIAL PRIMARY KEY,
	ename varchar(20) not null,
	eage SMALLINT NOT NULL CHECK (eage > 20 AND eage <= 60),
	esalary DECIMAL(10, 2) not null,
	edesignation varchar(10) not null,
	edepartment varchar(10) not null
);

select * from EMPLOYEE;

create table DEPARTMENT(
	edepartment varchar(10) primary key,
	HOD varchar(20) not null
)

create table EMPLOYEE_PERSON(
	eid SERIAL PRIMARY KEY,
	ename varchar(20) not null,
	eage SMALLINT NOT NULL CHECK (eage > 20 AND eage <= 60),
	esalary DECIMAL(10, 2) not null,
	edesignation varchar(10) not null,
	edepartment varchar(10) not null,
	CONSTRAINT department_name FOREIGN KEY (edepartment) REFERENCES DEPARTMENT (edepartment)
);

create table SALARY(
	eid SERIAL PRIMARY KEY,
	basic DECIMAL(10, 2) not null,
	hra DECIMAL(10, 2) not null,
	ta DECIMAL(10, 2) not null,
	da DECIMAL(10, 2) not null,
	pf DECIMAL(10, 2) not null,
	CONSTRAINT salary_constraint FOREIGN KEY (eid) REFERENCES EMPLOYEE_PERSON (eid)
);

insert into SALARY values (3, 60000, 20000, 6000, 4000, 10000);

select * from SALARY;

drop TABLE SALARY;

insert into department values ('FINANCE', 'PRIYA DESHPANDE');

select * from department;

insert into employee_person (ename, eage, esalary,edesignation, edepartment) values ('Michael Schott', 50, 100000, 'MANAGER', 'HR');

select * from employee_person;

create TABLE designation (
 edesignation varchar(20) PRIMARY KEY
);

INSERT INTO DESIGNATION VALUES (
	'PROGRAMMAR'
),
(
	'MANAGER'
),
(
	'CLERK'
);

select * from Designation;

