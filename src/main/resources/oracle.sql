select * from user_tables order by table_name;
select * from user_objects where object_name='USERS'

select * from user_sequences;


select * from company_details;

select * from users for update; 
select * from NATIONALITY for update; 
select * from ADDRESS

drop table users cascade CONSTRAINTS;
drop table ADDRESS;


select * from request for update; 
select * from req_cpip;
select * from req_port_details
select * from req_container
select * from req_preapproval

select * from container_product for update; 
select * from product_batch

select * from attachment for update; 

truncate table container_product
truncate table product_batch

alter table request drop constraint FKMDRA9E0RMVXETJAIQ78GYAWOI;



drop table request cascade CONSTRAINTS;
drop table req_cpip cascade CONSTRAINTS;
drop table req_container cascade CONSTRAINTS;
drop table req_port_details cascade CONSTRAINTS;
drop table req_preapproval cascade CONSTRAINTS;

drop table container_product cascade CONSTRAINTS;
drop table product_batch;

alter table attachment modify file_content clob;
alter table attachment drop column file_content;



