CREATE TYPE CAR_FUEL_TYPE AS ENUM('PETROL', 'DIESEL', 'POWER', 'CNG', 'EV');

CREATE TYPE CAR_TYPE_VALUES AS ENUM('SUV', 'SEDAN', 'TRUCK', 'BUS');

drop table company;

drop table car;

CREATE TABLE COMPANY(
	COMPANY_NAME VARCHAR(20) PRIMARY KEY
);

insert into company (COMPANY_NAME) values ('Maruti Suzuki');

CREATE TABLE CAR (
	CAR_ID SERIAL PRIMARY KEY,
	COMPANY_NAME varchar(20),
	MODEL VARCHAR(10) NOT NULL,
	SEATER SMALLINT NOT NULL,
	FUEL_TYPE CAR_FUEL_TYPE NOT NULL,
	CAR_TYPE CAR_TYPE_VALUES NOT NULL,
	PRICE DECIMAL(9,2) NOT NULL,
	SOLD BOOLEAN NOT NULL,
	CONSTRAINT FK_COMPANY FOREIGN KEY (COMPANY_NAME) REFERENCES COMPANY (COMPANY_NAME)
);

INSERT INTO CAR (COMPANY_NAME, MODEL, SEATER, FUEL_TYPE, CAR_TYPE, PRICE, SOLD) 
values ('Maruti Suzuki', 7, 4, 'PETROL', 'SUV', 800000, TRUE);

select * from car;