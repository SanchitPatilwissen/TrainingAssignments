create table Sales(
	sales_id serial,
	sales_date DATE not null,
	customer_name varchar(20) not null,
	amount decimal not null
);

drop table sales;

insert into Sales(sales_date, customer_name, amount) 
values 
('2024-01-21', 'Kaif Ali Sayyad', 1000);

select customer_name, to_char(sales_date, 'Month') sales_month, sum(amount) as amount
	from Sales 
	group by customer_name, to_char(sales_date, 'Month')
	order by 1;

select *
from crosstab('select customer_name, to_char(sales_date, ''Month'') sales_month, sum(amount) as amount
	from Sales 
	group by customer_name, to_char(sales_date, ''Month'')
	order by 1', 
	'values (''January''), (''February''), (''March''), (''April''), (''May''), (''June'')
	, (''July''), (''August''), (''September''), (''October''), (''November''), (''December'')')
as (
	customer varchar, January numeric, February numeric, March numeric, April numeric, May numeric, June numeric, 
	July numeric, August numeric, September numeric, October numeric, November numeric, December numeric
);

select * from Sales;

-- JSON Format storage

create Table employees(
	id serial primary key,
	data JSONB
);

select * from employees;

drop table employees;

SELECT data->>'ename' AS name
FROM employees;

select * from employees order by data->>'ename';