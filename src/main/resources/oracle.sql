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

select * from attachment 

truncate table container_product
truncate table product_batch

update req_cpip set NO_OF_CONTAINERS=0;
alter table req_cpip drop column NO_OF_CONTAINERS;
alter table req_cpip drop column NO_OF_CONTAINERS2;
alter table req_cpip drop column PRODUCT_COUNT;


alter table request add constraint FKmdra9e0rmvxetjaiq78gyawoi foreign key (created_by) references users (user_name)
alter table request drop constraint FKmdra9e0rmvxetjaiq78gyawoi;
alter table request drop constraint FKMDRA9E0RMVXETJAIQ78GYAWOI;

SELECT constraint_name, table_name
FROM user_constraints
WHERE table_name = 'REQUEST'
AND constraint_type = 'R';

alter table req_preapproval drop column RELEASE_WITH_DETENTION_WAREHOUSE_ID;



drop table request cascade;
drop table req_cpip cascade;
drop table req_container cascade;
drop table req_port_details cascade;
drop table req_preapproval;

drop table request cascade CONSTRAINTS;
drop table req_cpip cascade CONSTRAINTS;
drop table req_container cascade CONSTRAINTS;
drop table req_port_details cascade CONSTRAINTS;
drop table req_preapproval cascade CONSTRAINTS;

drop table container_product cascade CONSTRAINTS;
drop table product_batch;

alter table attachment modify file_content clob;
alter table attachment drop column file_content;


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

select * from TBL_STUDENT for update; 

create sequence CPIP_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

select * from user_sequences where sequence_name='CPIP_SEQ';

select * from categories;
select * from posts;
select * from comments;

