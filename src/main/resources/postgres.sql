select version();



select * from company_details;

select * from request;
select * from req_cpip;
select * from req_port_details;
select * from req_container;
select * from req_preapproval;
select * from container_product;
select * from product_batch;

select req.* 
from request req
where req.request_number in
(
select cpip.request_number 
	from req_cpip cpip
	inner join req_port_details port on port.request_number = cpip.request_number
	inner join req_container con on con.request_number = cpip.request_number
	inner join req_preapproval pre on pre.request_number = cpip.request_number
	where cpip.request_number=req.request_number
	--and port.bill_number=1
	--and con.container_number=1
	--and pre.dip=1
)


drop table request cascade;
drop table req_cpip cascade;
drop table req_container cascade;
drop table req_port_details cascade;
drop table req_preapproval;



select * from animal;
select * from pet;

select * from my_employee;

select * from my_product;

select * from vehicle;
select * from car;

select * from laptop;
select * from bag;


SELECT * FROM tutorials;


CREATE TABLE cars (
  brand VARCHAR(255),
  model VARCHAR(255),
  year INT
);

SELECT * FROM cars;


INSERT INTO cars (brand, model, year)
VALUES ('Ford', 'Mustang', 1964);

INSERT INTO cars (brand, model, year)
VALUES
  ('Volvo', 'p1800', 1968),
  ('BMW', 'M1', 1978),
  ('Toyota', 'Celica', 1975);
  
ALTER TABLE cars
ADD color VARCHAR(255);


UPDATE cars
SET color = 'red'
WHERE brand = 'Volvo';
