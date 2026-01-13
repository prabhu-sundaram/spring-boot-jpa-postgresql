&
select * from dba_users;
select * from all_users;

select * from product_component_version;
SELECT * FROM v$version;

SELECT DBMS_UTILITY.current_instance FROM   dual;
SELECT DBMS_UTILITY.port_string FROM   dual;

create user spring identified by spring123;
grant all privileges to spring;
alter user spring account unlock;
alter user spring identified by spring123;


alter user scott identified by oracle;

select * from tab;
select * from user_tables order by 
select * from emp;
create user user1 identified by user1;
grant all privileges to user1;

select * from user_tables order by table_name;
select * from user_objects where object_name='USERS'
select * from user_objects where object_name='USERS'
select OBJECT_TYPE,count(1) from user_objects GROUP BY rollup(OBJECT_TYPE)
select * from user_objects where status <> 'VALID';
EXEC UTL_RECOMP.RECOMP_PARALLEL(4);
EXEC UTL_RECOMP.RECOMP_SERIAL('SPRING');
EXEC DBMS_UTILITY.COMPILE_SCHEMA('SPRING');
EXEC DBMS_UTILITY.COMPILE_SCHEMA(schema=>'SPRING',compile_all=>FALSE);

SELECT * FROM user_dependencies WHERE referenced_name = 'EMP';

select * from user_sequences;
---------------------------

SELECT * FROM tutorials;
create table tutorials (id number(19,0) not null, description varchar2(255), published boolean, title varchar2(255), primary key (id));

select * from TBL_STUDENT --for update; 

create table TBL_STUDENT
(
  student_id    NUMBER(19) not null,
  email_address VARCHAR2(255 CHAR) not null,
  first_name    VARCHAR2(255 CHAR) not null,
  last_name     VARCHAR2(255 CHAR) not null,
  school_id     NUMBER,
  age           NUMBER(3),
  birth_date    TIMESTAMP(6),
  status        NUMBER(1),
  active        BOOLEAN(1)
);

alter table TBL_STUDENT modify status default 1;
alter table TBL_STUDENT modify active default true;

select * from TBL_STUDENT order by student_id


select * from course
select * from student_course_map
select * from course_material
select * from teacher
select * from school
select * from guardian

select * from categories for update; 
select * from posts for update; 
select * from comments;

select * from passenger_info
select * from payment_info

select * from book_details for update; 
select * from user4 order by id;
select * from country for update; 
select * from invoice for update; 
------------------------------------------------------

--Single Table Inheritance (STI)
select * from my_product;

--Joined/Class Table Inheritance (CTI)
select * from animal;
select * from pet;

--Table per Class/Concrete Table Inheritance (a.k.a. Table-per-Concrete-Class)
select * from vehicle;
select * from car;
------------------------------------------------------

--MappedSuperclass
select * from person3
select * from my_employee;

--PolymorphicQueries
select * from laptop;
select * from bag;

------------------------------------------------------

select * from users;

drop table users cascade CONSTRAINTS;
drop table ADDRESS;

select * from company_details;

select * from users for update; 
select * from NATIONALITY for update; 
select * from ADDRESS


alter table request add constraint FKmdra9e0rmvxetjaiq78gyawoi foreign key (created_by) references users (user_name)
alter table request drop constraint FKmdra9e0rmvxetjaiq78gyawoi;
alter table request drop constraint FKMDRA9E0RMVXETJAIQ78GYAWOI;

SELECT constraint_name, table_name
FROM user_constraints
WHERE table_name = 'REQUEST'
AND constraint_type = 'R';

create sequence CPIP_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

select * from user_sequences where sequence_name='CPIP_SEQ';

SELECT CPIP_SEQ.NEXTVAL FROM DUAL

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


-----------------
select sys_guid() from dual;
select * from v$instance
select * from v$database;
select DBMS_RANDOM.value from dual;
select TO_CHAR(DBMS_RANDOM.value(low => 1, high => 10)) from dual
select TO_CHAR(round(DBMS_RANDOM.value(low => 1, high => 999))) from dual

select DBMS_UTILITY.is_cluster_database from dual;
SELECT inst_id, instance_name FROM gv$instance;
SELECT * FROM v$instance;


CREATE TABLE employees (
   emp_id     NUMBER PRIMARY KEY,
   emp_name   VARCHAR2(100),
   emp_data   CLOB CHECK (emp_data IS JSON)   -- JSON constraint
);

SELECT jt.*
FROM   employees e,
       JSON_TABLE(
         e.emp_data,
         '$'
         COLUMNS (
           dept   VARCHAR2(30) PATH '$.department',
           title  VARCHAR2(30) PATH '$.jobTitle'
         )
       ) jt;


create table tab1
(
col1 decimal
);

select * from tab1 for update; 

create table customers
(
customer_id  number primary key,
name varchar2(50)
);

ALTER TABLE customers DROP COLUMN customer_id;

ALTER TABLE customers 
ADD customer_id NUMBER GENERATED BY DEFAULT AS IDENTITY;

exec get_customers(1,10);

begin 
  get_customers(1,10);
end;

select * from customers for update; 

SELECT * FROM customers 
ORDER BY customer_id DESC
FETCH FIRST ROWS ONLY;

select ROUND(10.354,2),ROUND(10.355,2),ROUND(10.356,2) from dual;

SELECT count(*),count(1) FROM customers 
SELECT count(ALL name),count(distinct name) FROM customers 

SELECT * FROM customers for update; 
insert into customers(name) values(null);

select listagg(name) as customer_names from customers;
select listagg(name,',') as customer_names from customers;
select listagg(name,',') within group(order by null) as customer_names from customers;
select listagg(name,',') within group(order by nulls last) as customer_names from customers;

select listagg(name,',') within group(order by name) as customer_names from customers;
select listagg(name,',') within group(order by customer_id) as customer_names from customers;

---------
--date

SELECT CURRENT_DATE,CURRENT_TIMESTAMP,sysdate,SYSTIMESTAMP,LOCALTIMESTAMP 
,DBTIMEZONE 
,SESSIONTIMEZONE 
,EXTRACT(DAY FROM SYSDATE)	
,EXTRACT(MONTH FROM SYSDATE)	
,EXTRACT(YEAR FROM SYSDATE)	
,SYS_EXTRACT_UTC(SYSTIMESTAMP)
FROM dual

select 
ADD_MONTHS( DATE '2016-02-29', 1 )
,ADD_MONTHS( DATE '2016-02-29', -1 )
,NEXT_DAY( DATE '2000-01-01', 'SUNDAY' )	
,NEXT_DAY( DATE '2025-11-25', 'SUNDAY' )	
,MONTHS_BETWEEN( DATE '2017-07-01', DATE '2017-01-01' )	
,MONTHS_BETWEEN( DATE '2017-01-01', DATE '2017-07-01' )	
,LAST_DAY(DATE '2016-02-01')	
from dual;


select 
ROUND(DATE '2017-07-16', 'DD')	
,ROUND(DATE '2017-07-16', 'MM')	
,ROUND(DATE '2017-07-16', 'MONTH')	
,ROUND(DATE '2017-07-16', 'YYYY')	
, TRUNC(DATE '2017-07-16', 'DD')	
, TRUNC(DATE '2017-07-16', 'MM')	
, TRUNC(DATE '2017-07-16', 'MONTH')	
, TRUNC(DATE '2017-07-16', 'YYYY')	
from dual;

select 
TO_CHAR( DATE '2017-01-01', 'DL' )	
,TO_CHAR(sysdate, 'DD/MM/YYYY' )	
,TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS')
,TO_CHAR(SYSDATE, 'DD-MON-YYYY HH PM:MI:SS')

,TO_DATE( '01 Jan 2017', 'DD MON YYYY' )	
from dual;
 
 

select FROM_TZ(TIMESTAMP '2017-08-08 08:09:10', '-09:00')	 
,TZ_OFFSET( 'Europe/London' )	
,NEW_TIME( TO_DATE( '08-07-2017 01:30:45', 'MM-DD-YYYY HH24:MI:SS' ), 'AST', 'PST' )	
from dual;

SELECT MONTHS_BETWEEN(DATE '2025-02-28', DATE '2025-01-31') FROM dual;
select * from emp
SELECT trunc(MONTHS_BETWEEN(SYSDATE, hiredate)/12) AS exp_years FROM emp;

select MONTHS_BETWEEN(to_date('23-07-2007','DD-MM-YYYY'), to_date('30-09-2025','DD-MM-YYYY'))/12


select 
sysdate + 15
,sysdate + '15'
,sysdate + INTERVAL '15' DAY    
,sysdate + 12 MONTH--wrong
,sysdate + '12' MONTH--wrong
,sysdate + INTERVAL '12' MONTH
from dual;

SELECT INTERVAL '30' DAY - INTERVAL '12' DAY FROM dual;
select sysdate + NUMTOYMINTERVAL(3,'MONTH') from dual;
select sysdate + NUMTODSINTERVAL(2, 'HOUR') from dual;


---------
--string

select 
ASCII('A')  
,CHR('65')  
,'Hello ' || 'World'
,CONCAT('A','BC') 
,CONVERT( 'Ä Ê Í', 'US7ASCII', 'WE8ISO8859P1' ) 
,DUMP('A')  
from dual;

select 
INITCAP('hi  there') 
,LOWER('Abc')  
,UPPER('Abc')  
,REVERSE('HELLO')
,LENGTH('ABC') 
,LPAD('ABC',5,'*') 
,RPAD('ABC',5,'*')  
,LTRIM(' ABC ')  
,LTRIM('xxxytest', 'x')
,RTRIM(' ABC ')  
,RTRIM('testxyz', 'xyz')
,TRIM(' ABC ') 
,SOUNDEX('sea')  
from dual;

select 
LENGTH('Oracle')
,INSTR( 'This is a playlist', 'is') 
,SUBSTR('Oracle Substring', 1, 6 ) 
,REPLACE('JACK AND JOND','J','BL')
,REPLACE('2025-12-03', '-', '/')
,TRANSLATE('12345', '143', 'bx') 
,TRANSLATE('ABC', 'ABC', '123')
,REGEXP_COUNT('1 2 3 abc','\d') 
,REGEXP_INSTR( 'Y2K problem','\d+') 
--,REGEXP_LIKE( 'Year of 2017','\d+' )
,CASE 
         WHEN REGEXP_LIKE('Year of 2017', '\d+') THEN 'TRUE'
         ELSE 'FALSE'
       END AS result
,REGEXP_REPLACE( 'Year of 2017','\d+', 'Dragon' ) 
,REGEXP_SUBSTR( 'Number 10', '\d+' )  
from dual;

SELECT 


select 
replace(replace('+919976414940','+'),'91')
,translate('+919976414940','+','')
from dual;
---------

select * from user_tab_identity_cols


CREATE TABLE messages(
    id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY START WITH 10 INCREMENT BY 10 primary key,
    description VARCHAR2(100) not null
);
select * from user_sequences

    
select * from plch_orders;    
select * from plch_invalid_orders;
select * from plch_special_orders;    

delete from plch_invalid_orders;
delete from plch_special_orders;

  
DECLARE
   l_orders   plch_pkg.plch_orders_aat;
BEGIN
   SELECT *
     BULK COLLECT INTO l_orders
     FROM plch_orders;

   plch_pkg.separate_orders (l_orders);

   FOR rec IN (SELECT 'Invalid ' || cust_id text FROM plch_invalid_orders
               UNION
               SELECT 'Special ' || cust_id FROM plch_special_orders
               ORDER BY 1)
   LOOP
      DBMS_OUTPUT.put_line (rec.text);
   END LOOP;
END;

select * from cars for update; 

INSERT INTO cars (brand, model, year)
VALUES ('Ford', 'Mustang', 1964);

INSERT ALL 
INTO cars (brand, model, year)
VALUES  ('Volvo', 'p1800', 1968)
INTO cars (brand, model, year)
VALUES  ('BMW', 'M1', 1978)
INTO cars (brand, model, year)
VALUES  ('Toyota', 'Celica', 1975)
SELECT * FROM dual;

drop table if exists categories;
drop table categories;

select * from user_constraints where TABLE_NAME=upper('categories');
select * from user_cons_columns where TABLE_NAME=upper('categories');

SELECT a.table_name
FROM user_constraints c
JOIN user_cons_columns a 
     ON c.constraint_name = a.constraint_name
WHERE c.constraint_type = 'R'
  AND c.r_constraint_name = (
        SELECT constraint_name
        FROM user_constraints
        WHERE table_name = UPPER('categories')
          AND constraint_type = 'P'
      );

select * from POSTS

DROP TABLE categories_food;
DROP TABLE categories_food CASCADE CONSTRAINTS;

CREATE TABLE categories_food (
  category_id number generated by default as identity  NOT NULL PRIMARY KEY,
  category_name VARCHAR2(255),
  description VARCHAR2(255)
);
CREATE TABLE categories_food (
  category_id number generated by default on null as identity  NOT NULL PRIMARY KEY,
  category_name VARCHAR2(255),
  description VARCHAR2(255)
);

select * from categories_food;
select * from user_tab_columns where table_name=upper('categories_food')


select * from user_sequences where sequence_name = 'ISEQ$$_80773';
drop sequence ISEQ$$_80770;

TRUNCATE TABLE categories_food REUSE STORAGE;

INSERT 
  INTO categories_food (category_name, description)
    VALUES ('Beverages', 'Soft drinks, coffees, teas, beers, and ales');
    
INSERT ALL
  INTO categories_food (category_name, description)
    VALUES ('Beverages', 'Soft drinks, coffees, teas, beers, and ales')
  INTO categories_food (category_name, description)
    VALUES ('Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings')
  INTO categories_food (category_name, description)
    VALUES ('Confections', 'Desserts, candies, and sweet breads')
  INTO categories_food (category_name, description)
    VALUES ('Dairy Products', 'Cheeses')
  INTO categories_food (category_name, description)
    VALUES ('Grains/Cereals', 'Breads, crackers, pasta, and cereal')
  INTO categories_food (category_name, description)
    VALUES ('Meat/Poultry', 'Prepared meats')
  INTO categories_food (category_name, description)
    VALUES ('Produce', 'Dried fruit and bean curd')
  INTO categories_food (category_name, description)
    VALUES ('Seafood', 'Seaweed and fish')
SELECT 1 FROM dual;

INSERT INTO categories_food (category_name, description)
SELECT 'Beverages', 'Soft drinks, coffees, teas, beers, and ales' FROM dual
UNION ALL
SELECT 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings' FROM dual
UNION ALL
SELECT 'Confections', 'Desserts, candies, and sweet breads' FROM dual
UNION ALL
SELECT 'Dairy Products', 'Cheeses' FROM dual
UNION ALL
SELECT 'Grains/Cereals', 'Breads, crackers, pasta, and cereal' FROM dual
UNION ALL
SELECT 'Meat/Poultry', 'Prepared meats' FROM dual
UNION ALL
SELECT 'Produce', 'Dried fruit and bean curd' FROM dual
UNION ALL
SELECT 'Seafood', 'Seaweed and fish' FROM dual;


select * from user_indexes where TABLE_NAME=upper('categories');
select * from user_ind_columns where TABLE_NAME=upper('categories');

select * from categories

select * from customers;

drop table if exists customers;

CREATE TABLE customers (
  customer_id number generated by default on null as identity NOT NULL PRIMARY KEY,
  customer_name VARCHAR2(255),
  contact_name VARCHAR2(255),
  address VARCHAR2(255),
  city VARCHAR2(255),
  postal_code VARCHAR2(255),
  country VARCHAR2(255)
);

CREATE TABLE products (
  product_id number generated by default on null as identity NOT NULL PRIMARY KEY,
  product_name VARCHAR2(255),
  category_id int,
  unit VARCHAR2(255),
  price number(10, 2)
);
select * from products

CREATE TABLE orders (
  order_id number generated by default on null as identity NOT NULL PRIMARY KEY,
  customer_id INT,
  order_date DATE
);

CREATE TABLE order_details (
  order_detail_id number generated by default on null as identity NOT NULL PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT
);

select * from order_details;

CREATE TABLE testproducts (
  testproduct_id number generated by default on null as identity NOT NULL PRIMARY KEY,
  product_name VARCHAR2(255),
  category_id INT
);

select * from testproducts;
select * from dept
select * from emp
select * from BONUS
select * from SALGRADE

grant execute on dbms_crypto to spring;

select * from emp;
select listagg(ename) as emp_names from emp;
select listagg(ename,',') as emp_names from emp;
select deptno,listagg(ename,',') within group(order by ename) as emp_names from emp 
group by deptno order by deptno;



select avg(sal) from emp;
select DEPTNO,avg(sal) from emp group by DEPTNO order by DEPTNO;
select DEPTNO,avg(sal) from emp group by all order by 1;
select DEPTNO,avg(sal) from emp group by all order by 2;


--analytical
select 
e.*
,avg(sal) over() as avg_sal
from emp e

select 
e.*
,avg(sal) over(partition by deptno) as dept_avg_sal
from emp e;

select 
e.*
,first_value(sal) over(partition by deptno) as dept_first_sal
from emp e
--order by e.deptno,e.sal;

select 
e.*
,min(sal) over(partition by deptno) as dept_low_sal
from emp e;


select e2.* from 
(select 
e.*
,min(sal) over(partition by deptno) as dept_low_sal
from emp e
) e2
order by e2.deptno,e2.sal;

select 
e.*
,first_value(sal) over(order by sal rows between 1 preceding and current row) as prev_sal
,last_value(sal) over(order by sal rows between current row and 1 following) as next_sal
from emp e

select
e.*
,hiredate-first_value(hiredate) over(partition by deptno order by hiredate) as day_gap
from emp e


-----------
select 
e.*
,count(1) over(partition by deptno order by deptno) as dept_emp_count
from emp e


select 
e.*
,max(sal) over(partition by deptno) as dept_high_sal
from emp e;

select e2.* from (
select 
e.*
,max(sal) over(partition by deptno) as dept_high_sal
from emp e
)e2
order by e2.deptno,e2.sal desc;

select 
e.*
,row_number() over(partition by deptno order by hiredate nulls last) as seniority
from emp e


select 
e.*
,row_number() over(partition by deptno order by sal)
from emp e

select 
e.*
,row_number() over(partition by deptno order by sal desc)
from emp e

select 
e.*
,rank() over(partition by deptno order by sal desc)
from emp e

select 
e.*
,dense_rank() over(partition by deptno order by sal desc)
from emp e

select * from products

with cte_prod_rnk
(product_name,list_price,rnk) as
( 
select
product_name,list_price
,dense_rank() over(order by list_price) as rnk
from
products p
)
select 
product_name,list_price,rnk
from cte_prod_rnk
where rnk<=10;


with cte_prod_rnk
(product_name,CATEGORY_ID,list_price,rnk) as
( 
select
product_name,CATEGORY_ID,list_price
,dense_rank() over(partition by CATEGORY_ID order by list_price) as rnk
from
products p
)
select 
product_name,CATEGORY_ID,list_price,rnk
from cte_prod_rnk
where rnk<=10;



select * from user_tables
where table_name in
('ORDER_ITEMS','ORDERS','INVENTORIES','PRODUCTS','PRODUCT_CATEGORIES','WAREHOUSES','EMPLOYEES','CONTACTS','CUSTOMERS','LOCATIONS','COUNTRIES','REGIONS')

select * from CUSTOMERS
select * from ORDERS
select * from PRODUCTS

alter table CUSTOMERS rename to CUSTOMERS2;
alter table ORDERS rename to ORDERS2;
alter table ORDER_DETAILS rename to ORDER_DETAILS2;
alter table PRODUCTS rename to PRODUCTS2;

select
e.*
,lag(sal) over(partition by deptno order by sal) as prev_low_sal
,lead(sal) over(partition by deptno order by sal) as next_high_sal
from emp e

select
e.*
,lag(sal) over(partition by deptno order by sal desc) as prev_high_sal
,lead(sal) over(partition by deptno order by sal desc) as next_low_sal
from emp e

select
e.*
,lag(sal,1,0) over(partition by deptno order by sal desc) as prev_high_sal
,lead(sal,1,0) over(partition by deptno order by sal desc) as next_low_sal
from emp e


SELECT
  salesman_id,
  year,
  sales
FROM
  salesman_performance
ORDER BY
  salesman_id,
  year,
  sales;
  
SELECT
  salesman_id,
  year,
  sales
  ,lag(sales) over(partition by salesman_id order by year) as prev_year_sales
  ,lead(sales) over(partition by salesman_id order by year) as next_year_sales
FROM
  salesman_performance sp
ORDER BY
  salesman_id,
  year,
  sales;
  
  
with cte_sales_perf(salesman_id,
  year,
  sales,
  prev_year_sales,
  next_year_sales)
as
(SELECT
  salesman_id,
  year,
  sales
  ,lag(sales) over(partition by salesman_id order by year) as prev_year_sales
  ,lead(sales) over(partition by salesman_id order by year) as next_year_sales
FROM
  salesman_performance sp)
select   
salesman_id,
year,
sales,
prev_year_sales,
next_year_sales,
case when prev_year_sales is null then 'N/A' else to_char(((sales-prev_year_sales)*100/sales), '999999.99') end as sales_growth_per 
  ,case when prev_year_sales is null then 'N/A' else to_char(round((sales-prev_year_sales)*100/sales,2)) end as sales_growth_per2
from cte_sales_perf
-----------
---RUNNING TOTAL in SQL---
--Who Reached 100k Target First --
SELECT salesperson_name,
MIN (sale_date) as target_reached
FROM
(SELECT *,
SUM(amount)
OVER (partition by salesperson_name
order by sale_date)
as run_total
FROM sales_data) as subquery
WHERE run_total >= 100000
GROUP BY salesperson_name
ORDER BY 2


--Population Density--
--Highest and Lowest Pop. Density --
select t.city,t.density from
(select
city,
population/area as density,
rank() over(order by
population/area desc) rankup,
rank() over(order by
population/area asc) rankdown
from cities_data
where area <> 0) t
where t.rankup =1 or t.rankdown=1

-------------
SELECT *
FROM (
    SELECT empno, ename, deptno, sal,
           ROW_NUMBER() OVER (PARTITION BY deptno ORDER BY sal DESC) rn
    FROM emp
)
WHERE rn = 1;


SELECT empno, ename, deptno, sal
FROM emp
QUALIFY
  ROW_NUMBER() OVER (PARTITION BY deptno ORDER BY sal DESC) = 1;
  
SELECT empno, ename, deptno, sal
FROM emp
QUALIFY
  DENSE_RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) = 2;
  
SELECT order_id,
       order_date,
       SUM(amount) OVER (ORDER BY order_date) AS running_total
FROM orders
QUALIFY
  running_total > 100000;


SELECT empno, deptno, sal
FROM emp
QUALIFY
    ROW_NUMBER() OVER (PARTITION BY deptno ORDER BY sal DESC) <= 3
AND sal > AVG(sal) OVER (PARTITION BY deptno);

-------------


create table countries2
(
name varchar2(255),
population number
);

select * from countries2 for update; 

SELECT name, RATIO_TO_REPORT(population) OVER () AS population_ratio
     FROM countries2
     ORDER BY population_ratio DESC
     FETCH FIRST 10 ROWS ONLY;
     
SELECT name,
            ROUND(100 * RATIO_TO_REPORT(population) OVER (), 2) AS population_percent
     FROM countries2
     ORDER BY population_percent DESC
     FETCH FIRST 10 ROWS ONLY;
       
SELECT name, population_percent
     FROM (
      SELECT name,
             ROUND(100 * RATIO_TO_REPORT(population) OVER (), 2) AS population_percent
      FROM countries2
     )
     WHERE population_percent >= 1
     ORDER BY population_percent DESC;
     
SELECT name,
         ROUND(100 * RATIO_TO_REPORT(population) OVER (), 2) AS population_percent
     FROM countries2
     QUALIFY population_percent >= 1
     ORDER BY population_percent DESC;
     
   
-----------------
select * from emp

SELECT mgr, ename, sal,
   SUM(sal) OVER (PARTITION BY mgr ORDER BY sal
   RANGE UNBOUNDED PRECEDING) l_csum
   FROM emp
   ORDER BY mgr, ename, sal, l_csum;


-----------------


CREATE TABLE members (
  member_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  first_name VARCHAR2 (100) NOT NULL,
  last_name VARCHAR2 (100) NOT NULL,
  gender CHAR(1) NOT NULL,
  dob DATE NOT NULL,
  email VARCHAR2 (255) NOT NULL
);

select * from members

select * from user_indexes

CREATE INDEX members_last_name_i 
ON members(last_name);

EXPLAIN PLAN FOR
SELECT * FROM members
WHERE last_name = 'Harse';

SELECT
  PLAN_TABLE_OUTPUT
FROM
  TABLE (DBMS_XPLAN.DISPLAY ());
  
DROP INDEX index_name;

CREATE INDEX members_name_i
ON members(last_name,first_name);

EXPLAIN PLAN FOR
SELECT * 
FROM members
WHERE last_name LIKE 'A%' 
    AND first_name LIKE 'M%';    
    
SELECT 
    PLAN_TABLE_OUTPUT 
FROM 
    TABLE(DBMS_XPLAN.DISPLAY());
	
DBMS_XPLAN.DISPLAY_CURSOR	
-------------
--hierarchical

select 
level
from dual
connect by level <= 100;

SELECT  DATE '2025-01-01' + LEVEL-1 AS dt
FROM    dual
CONNECT BY LEVEL <= 10;

SELECT  DATE '2025-01-01' + LEVEL - 1 AS dt
FROM    dual
CONNECT BY LEVEL <= (DATE '2025-01-10' - DATE '2025-01-01') + 1;

--Generate only weekdays between two dates
select * from (
SELECT  DATE '2025-12-01' + LEVEL - 1 AS dt
FROM    dual
CONNECT BY LEVEL <= (DATE '2025-12-10' - DATE '2025-12-01') + 1)
where to_char(dt,'DY') not in ('SAT','SUN')


SELECT
    employee_id,
    first_name,
    manager_id,
    LEVEL,
    CONNECT_BY_ISLEAF AS IsLeaf
FROM
    employees
START WITH
    manager_id IS NULL
CONNECT BY
    PRIOR employee_id = manager_id;
	
select * from emp


SELECT level
,LPAD(' ', 2*(LEVEL-1)) || ename AS tree
,SYS_CONNECT_BY_PATH(ename,'/') AS path
,CONNECT_BY_ROOT ename root_name
,CONNECT_BY_ISLEAF AS leaf
,ename, empno, mgr
FROM emp
--where CONNECT_BY_ISLEAF = 1
--WHERE PRIOR empno IS NULL

START WITH mgr IS NULL
--START WITH empno = 7698
--CONNECT BY PRIOR empno = mgr
CONNECT BY NOCYCLE PRIOR empno = mgr
ORDER SIBLINGS BY ename;




DROP TABLE tab1 PURGE;

CREATE TABLE tab1 (
  id        NUMBER,
  parent_id NUMBER,
  CONSTRAINT tab1_pk PRIMARY KEY (id),
  CONSTRAINT tab1_tab1_fk FOREIGN KEY (parent_id) REFERENCES tab1(id)
);

CREATE INDEX tab1_parent_id_idx ON tab1(parent_id);

INSERT INTO tab1 VALUES (1, NULL);
INSERT INTO tab1 VALUES (2, 1);
INSERT INTO tab1 VALUES (3, 2);
INSERT INTO tab1 VALUES (4, 2);
INSERT INTO tab1 VALUES (5, 4);
INSERT INTO tab1 VALUES (6, 4);
INSERT INTO tab1 VALUES (7, 1);
INSERT INTO tab1 VALUES (8, 7);
INSERT INTO tab1 VALUES (9, 1);
INSERT INTO tab1 VALUES (10, 9);
INSERT INTO tab1 VALUES (11, 10);
INSERT INTO tab1 VALUES (12, 9);
COMMIT;


SELECT id,
       parent_id,
       RPAD('.', (level-1)*2, '.') || id AS tree,
       level,
       CONNECT_BY_ROOT id AS root_id,
       LTRIM(SYS_CONNECT_BY_PATH(id, '-'), '-') AS path,
       CONNECT_BY_ISLEAF AS leaf,
       CONNECT_BY_ISCYCLE AS cycle
FROM   tab1
--START WITH parent_id IS NULL
START WITH id = 1
--CONNECT BY parent_id = PRIOR id
CONNECT BY NOCYCLE parent_id = PRIOR id
ORDER SIBLINGS BY id;

-------------


create table boolean_test (
  id        number generated always as identity,
  active    boolean,
  archived  bool
);

select * from boolean_test;

insert into boolean_test (active, archived) values
  (true, false),
  (TRUE, FALSE),
  ('true', 'false'),
  ('TRUE', 'FALSE'),
  ('yes', 'no'),
  ('YES', 'NO'),
  ('on', 'off'),
  ('ON', 'OFF'),
  (1, 0),
  ('1', '0'),
  ('t', 'f'),
  ('T', 'F'),
  ('y', 'n'),
  ('Y', 'N');

commit;

select *--count(*)
from   boolean_test
where  active;

insert into boolean_test (active, archived) values (null, null);
commit;


select *
from   boolean_test
where  active is null;

select count(*)
from   boolean_test
where  active is true;

select *--count(*)
from   boolean_test
where  active and not archived;

select count(*)
from   boolean_test
where  active or archived;

select count(*)
from   boolean_test
where  active is null;

select *--count(*)
from   boolean_test
where  active > archived;


select to_boolean('true'),
       to_boolean('false'),
       to_number(active),
       to_number(archived),
       to_char(active),
       to_char(archived),
       to_nchar(active),
       to_nchar(archived)
from   boolean_test
where  id = 1;

-----------
select owner, object_type, status, count(*)
from   t1
group by all
order by 1, 2;

-------
CREATE TYPE person_t AS OBJECT (
  id   NUMBER,
  name VARCHAR2(50)
) NOT FINAL;
/

CREATE TYPE employee_t UNDER person_t (
  salary NUMBER
);
/


CREATE TABLE people OF person_t;

INSERT INTO people VALUES (person_t(1, 'John'));
INSERT INTO people VALUES (employee_t(2, 'Scott', 50000));
select * from people;

SELECT 
  p.name,
  TREAT(VALUE(p) AS employee_t).salary AS emp_salary
FROM people p;

SELECT p.*
FROM people p
WHERE TREAT(VALUE(p) AS employee_t) IS NOT NULL;

CREATE TABLE dept2 (
  dept_id NUMBER,
  mgr REF person_t
);

SELECT 
  d.dept_id,
  TREAT(d.mgr AS REF employee_t).salary
FROM dept2 d;

SELECT TREAT(VALUE(e) AS employee_t).salary
FROM TABLE(p.staff) e;
--------
CREATE TYPE vehicle_t AS OBJECT (
  id NUMBER,
  name VARCHAR2(50)
) NOT FINAL;
/

CREATE TYPE car_t UNDER vehicle_t (
  fuel_type VARCHAR2(10)
);
/

CREATE TABLE vehicles OF vehicle_t;

INSERT INTO vehicles VALUES (vehicle_t(1, 'Truck'));
INSERT INTO vehicles VALUES (car_t(2, 'Sedan', 'Petrol'));

select * from vehicles v

SELECT
  v.name,
  TREAT(VALUE(v) AS car_t).fuel_type AS fuel
FROM vehicles v;

----------
CREATE OR REPLACE TYPE number_nt AS TABLE OF NUMBER;
/

SELECT number_nt(1,2,3) MULTISET UNION number_nt(3,4,5) AS result
FROM dual;
---------
select * from UM_LOG




----------
GRANT EXECUTE ON DBMS_PROFILER TO spring;
@$ORACLE_HOME/rdbms/admin/profload.sql

select * from emp

declare
v_out sys_refcursor;
BEGIN
    get_employee(p_emp_id => 7369,
               p_out => v_out);
end;
               
               
declare
v_out sys_refcursor;
BEGIN
  DBMS_PROFILER.START_PROFILER('My test run');

    get_employee(p_emp_id => 7369,
               p_out => v_out);

  DBMS_PROFILER.STOP_PROFILER;
END;
/

select * from PLSQL_PROFILER_RUNS;
select * from PLSQL_PROFILER_UNITS;
select * from PLSQL_PROFILER_DATA;


SELECT u.unit_name, d.line#, d.total_time
FROM   plsql_profiler_data d
JOIN   plsql_profiler_units u 
       ON d.unit_number = u.unit_number
ORDER BY d.total_time DESC;
------------

GRANT CREATE ANY DIRECTORY TO spring;
CREATE DIRECTORY plsql_profiler_dir AS 'F:\plsql\plsql_profiler_dir';
GRANT EXECUTE ON DBMS_HPROF TO spring;

declare
v_out sys_refcursor;
BEGIN
  DBMS_HPROF.START_PROFILING(
    location => 'PLSQL_PROFILER_DIR',
    filename => 'hprof_output.txt'
  );

    get_employee(p_emp_id => 7369,
               p_out => v_out);

  DBMS_HPROF.STOP_PROFILING();
END;
/

@$ORACLE_HOME/rdbms/admin/hprof_analyze.sql

--------

EXEC DBMS_TRACE.SET_PLSQL_TRACE(DBMS_TRACE.TRACE_ALL_CALLS);

declare
v_out sys_refcursor;
BEGIN
    get_employee(p_emp_id => 7369,
               p_out => v_out);
end;
/

EXEC DBMS_TRACE.CLEAR_PLSQL_TRACE();

select * from USER_PLSQL_TRACE_EVENTS

SELECT * FROM all_objects WHERE object_name = 'DBMS_TRACE';
--------------

EXEC DBMS_SESSION.SET_SQL_TRACE(TRUE);
/

declare
v_out sys_refcursor;
BEGIN
    get_employee(p_emp_id => 7369,
               p_out => v_out);
end;
/

EXEC DBMS_SESSION.SET_SQL_TRACE(FALSE);
/

tkprof tracefile.trc output.txt
tkprof orcl_ora_15277.trc output.txt sys=no sort=exeela


SELECT value FROM v$diag_info WHERE name = 'Diag Trace';
--C:\APP\PRABHU\PRODUCT\26AI\diag\rdbms\free\free\trace

SELECT value FROM v$diag_info WHERE name='Default Trace File';
C:\APP\PRABHU\PRODUCT\26AI\diag\rdbms\free\free\trace\free_ora_19796.trc

SELECT
    s.sid,
    s.serial#,
    p.spid    AS os_pid,
    t.tracefile
FROM  v$session s
JOIN  v$process p ON s.paddr = p.addr
JOIN  v$diag_info d ON d.name = 'Diag Trace'
JOIN  v$sesstat ss ON ss.sid = s.sid
JOIN  gv$session t ON t.sid = s.sid
WHERE s.audsid = USERENV('SESSIONID');


----------
--AWR
SELECT * FROM dba_hist_sqlstat WHERE parsing_schema_name='SPRING';
---------


with
/*look for first order of each customer*/
customer_first_order as (
select
customer_id,
order_date as first_date,
initial_value,
rank() over (partition by customer_id order by order_date asc) as rank
from
orders
group by
customer_id
),
/*look for first orders with high value using the above CTE*/
high_value_customers as (
select
customer_id
from
customer_first_order
where
rank = 1
and initial_value > 1000)
select
count(distinct hvc.customer_id) as high_value_customer_count,
count(distinct cfo.customer_id) as total_customer_count
from
customer first order as cfo
left join high_value_customers as hvc
on hvc.customer id cfo.customer_id
where
cfo.rank=1

select count(comm) from emp;
------------------
DECLARE
    ex_dml_errors EXCEPTION;
    PRAGMA EXCEPTION_INIT(ex_dml_errors, -24381);
    type t_ids is table of emp.empno%type
    index by pls_integer;
    v_ids t_ids;
BEGIN
    FORALL i IN 1..v_ids.COUNT SAVE EXCEPTIONS
        UPDATE emp SET sal = sal * 1.1
        WHERE empno = v_ids(i);
EXCEPTION
    WHEN ex_dml_errors THEN
        FOR j IN 1..SQL%BULK_EXCEPTIONS.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE('Error: ' || 
                SQL%BULK_EXCEPTIONS(j).ERROR_INDEX || ' - ' ||
                SQL%BULK_EXCEPTIONS(j).ERROR_CODE);
        END LOOP;
END;

-------
create table t3
(
col1 number
);

select * from t3 for update; 

select * from t3 
where col1 in (select col1 from(select col1,count(1) from t3 group by all having count(1)>1))

delete from t3
where col1 in
(select col1 from(select col1,count(1) from t3 group by all having count(1)>1))

DELETE FROM t3 o
WHERE ROWID > (
    SELECT MIN(ROWID) FROM t3 i
    WHERE i.col1 = o.col1
);


select
col1,
row_number() over(partition by col1 order by col1) as rn
from t3

delete from t3 where col1 in 
(select col1 from
(select
col1,
row_number() over(partition by col1 order by col1) as rn
from t3) 
where rn>1)

delete from t3 where rowid in 
(select rid from
(select
rowid as rid,
row_number() over(partition by col1 order by col1) as rn
from t3) 
where rn>1)

select * from user_procedures;
select * from user_proc_params
SELECT DBMS_METADATA.GET_DDL('TABLE', 'DUAL', 'SYS') FROM DUAL;
SELECT DBMS_METADATA.GET_DDL('TABLE', 'EMPLOYEES') FROM DUAL;

DBMS_UTILITY.comma_to_table

BEGIN
  DBMS_LOCK.sleep(seconds => 5.01);
END;
/


--9i
SET SERVEROUTPUT ON SIZE 1000000
DECLARE
  l_seed  BINARY_INTEGER;
BEGIN
  l_seed := TO_NUMBER(TO_CHAR(SYSDATE,'YYYYDDMMSS'));
  DBMS_RANDOM.initialize (val => l_seed);
  FOR cur_rec IN 1 ..10 LOOP
    DBMS_OUTPUT.put_line('----');
    DBMS_OUTPUT.put_line('value                      : ' || TO_CHAR(DBMS_RANDOM.value));
    DBMS_OUTPUT.put_line('value(low => 1, high => 10): ' || TO_CHAR(DBMS_RANDOM.value(low => 1, high => 10)));
  END LOOP;
  DBMS_RANDOM.terminate;
END;
/

-- Oracle 10g Release 1 Upwards.
SET SERVEROUTPUT ON SIZE 1000000
BEGIN
  FOR cur_rec IN 1 ..10 LOOP
    DBMS_OUTPUT.put_line('----');
    DBMS_OUTPUT.put_line('value                      : ' || TO_CHAR(DBMS_RANDOM.value));
    DBMS_OUTPUT.put_line('value(low => 1, high => 10): ' || TO_CHAR(DBMS_RANDOM.value(low => 1, high => 10)));
  END LOOP;
END;
/

SET SERVEROUTPUT ON
BEGIN
  IF DBMS_UTILITY.is_cluster_database THEN
    DBMS_OUTPUT.put_line('Clustered');
  ELSE
    DBMS_OUTPUT.put_line('Not Clustered');
  END IF;
END;
/

SET SERVEROUTPUT ON
DECLARE
  l_instance_table  DBMS_UTILITY.instance_table;
  l_instance_count  NUMBER;
BEGIN
  DBMS_UTILITY.active_instances (instance_table => l_instance_table,
                                 instance_count => l_instance_count);

  IF l_instance_count > 0 THEN
    FOR i IN 1 .. l_instance_count LOOP
      DBMS_OUTPUT.put_line(l_instance_table(i).inst_number || ' = ' || l_instance_table(i).inst_name);
    END LOOP;
  END IF;
END;
/

SET SERVEROUTPUT ON
DECLARE
  l_version  VARCHAR2(100);
  l_compatibility  VARCHAR2(100);
BEGIN
  DBMS_UTILITY.db_version (version       => l_version,
                           compatibility => l_compatibility);
  DBMS_OUTPUT.put_line('Version: ' || l_version || '  Compatibility: ' || l_compatibility);
END;
/

SET SERVEROUTPUT ON
DECLARE
  l_list1   VARCHAR2(50) := 'A,B,C,D,E,F,G,H,I,J';
  l_list2   VARCHAR2(50);
  l_tablen  BINARY_INTEGER;
  l_tab     DBMS_UTILITY.uncl_array;
BEGIN
  DBMS_OUTPUT.put_line('l_list1 : ' || l_list1);

  DBMS_UTILITY.comma_to_table (
     list   => l_list1,
     tablen => l_tablen,
     tab    => l_tab);

  FOR i IN 1 .. l_tablen LOOP
    DBMS_OUTPUT.put_line(i || ' : ' || l_tab(i));
  END LOOP;

  DBMS_UTILITY.table_to_comma (
     tab    => l_tab,
     tablen => l_tablen,
     list   => l_list2);

  DBMS_OUTPUT.put_line('l_list2 : ' || l_list2);
END;
/

CREATE OR REPLACE TYPE t_emp AS OBJECT (
  empno NUMBER,
  ename VARCHAR2(100)
);


CREATE OR REPLACE TYPE t_emp_table AS TABLE OF t_emp;


CREATE OR REPLACE FUNCTION fn_get_emps
RETURN t_emp_table PIPELINED
IS
BEGIN
  FOR r IN (SELECT empno, ename FROM emp ORDER BY empno)
  LOOP
    PIPE ROW (t_emp(r.empno, r.ename)); -- stream out row
  END LOOP;

  RETURN;
END;

SELECT * FROM TABLE(fn_get_emps);

CREATE OR REPLACE FUNCTION fn_clean_emps
RETURN t_emp_table PIPELINED
IS
BEGIN
  FOR r IN (SELECT empno, ename FROM emp)
  LOOP
    PIPE ROW (t_emp(r.empno, UPPER(TRIM(r.ename))));
  END LOOP;
  RETURN;
END;


SELECT * FROM TABLE(fn_clean_emps);

CREATE OR REPLACE FUNCTION fn_get_dept_emps (p_deptno NUMBER)
RETURN t_emp_table PIPELINED
IS
BEGIN
  FOR r IN (SELECT empno, ename FROM emp WHERE deptno = p_deptno)
  LOOP
    PIPE ROW (t_emp(r.empno, r.ename));
  END LOOP;

  RETURN;
END;


SELECT * FROM TABLE(fn_get_dept_emps(10));

select * from v$sql
select * from v$sql_history


SET AUTOTRACE TRACE EXPLAIN

-- Return 10 rows.
SELECT *
FROM   fn_get_dept_emps(10);


SET AUTOTRACE OFF

create table t_virtual (
  id              number,
  product         varchar2(50),
  price           number(10,2),
  price_with_tax  number(10,2) generated always as (round(price*1.2,2)) virtual
);

insert into t_virtual (id, product, price) values (1, 'computer', 1500);
insert into t_virtual (id, product, price) values (2, 'bike', 1000);
commit;

select * from t_virtual

CREATE OR REPLACE FUNCTION add_numbers(a NUMBER, b NUMBER)
  RETURN NUMBER
  PARALLEL_ENABLE
  RESULT_CACHE
AS
  PRAGMA UDF;  -- marks as SQL-friendly and pure
BEGIN
  RETURN a + b;
END;
/

select add_numbers(1,2) from dual;


select e.* 
,nvl(comm,0)
,nvl2(comm,'not null','null')
,COALESCE(comm,mgr,0)
,NULLIF(comm, 0)
from emp e;

select substr(ename,1,2) from emp;

BEGIN
    DBMS_FGA.add_policy(
        object_schema   => 'SPRING',
        object_name     => 'EMP',
        policy_name     => 'salary_access_audit',
        audit_condition => 'salary > 100000',
        audit_column    => 'SAL'
    );
END;

BEGIN
    DBMS_FGA.add_policy(
        object_schema   => 'SPRING',
        object_name     => 'EMP',
        policy_name     => 'salary_access_audit',
        audit_condition => 'salary > 100000'
    );
END;
/


BEGIN
    DBMS_FGA.drop_policy(
        object_schema => 'SPRING',
        object_name   => 'EMP',
        policy_name   => 'salary_access_audit'
    );
END;
/



select * from emp for update; 

SELECT * FROM DBA_FGA_AUDIT_TRAIL;


SELECT
  customer,
  category,
  SUM(sales_amount) total_sales_amount
FROM
  customer_category_sales
GROUP BY
  GROUPING SETS ((customer, category), (customer), (category), ())
ORDER BY
  customer,
  category;
  


SELECT rownum,
       JSON_OBJECT(
         'EMPNO' : empno,
         'ENAME' : ename,
         'JOB' : job
       )
FROM   emp;




Fact table
transaction_id |
customer_id |
transaction_date |
amount |
1001
123
2025-03-15
1108
Customer dimension (SCD2)
| customer_id |
valid_from |
valid_to
I
address
123
| 2024-01-01
2825-02-28 |
123 Old St |
123
2025-83-81
9999-12-31
456 New Ave |

-The join pattern:
from fact_table f
join customer_dimension d
on f.customer_id= d.customer_id
and f.transaction_date between d.valid_from and d.valid_to

--JOIN query
select
f.transaction_id,
f.transaction_date,
f.amount,
d.address
from transactions f
join customers d
on f.customer_id= d.customer_id
and f.transaction_date between d.valid_from and d.valid_to;
-- Result: Transaction gets "456 New Ave" (valid on 2025-03-15)
Date range handling options:
--Inclusive (record valid through end date): and f.date between d.valid_from and d.valid_to
-- Exclusive (record valid until end date): and f.date >= d.valid_from and f.dated.valid_to

if there is null data for valid_to 
--condition to be added --OR valid_to is null -- nvl(valid_to 
--then index wont be considered so add default date like 9999-12-31

select * from user_queue_tables;
select * from user_queues;
select * from USER_QUEUE_SUBSCRIBERS;


CREATE OR REPLACE TYPE country2 AS OBJECT (
       country_code VARCHAR2(2),
       name         VARCHAR2(100),
       population   NUMBER,
       region       VARCHAR2(100)
     );
 
select * from regions
select * from countries

CREATE OR REPLACE FUNCTION get_country_by_code( p_country_code IN VARCHAR2 )
       RETURN country
       AS MLE LANGUAGE JAVASCRIPT
     {{
         const result = session.execute(
             `SELECT c.country_code,
                     c.name,
                     c.population,
                     r.name AS region
                FROM countries c
                 JOIN regions r ON (c.region_id = r.region_id)
               WHERE c.country_code = :code`,
             { code: P_COUNTRY_CODE }
         );
    
         return result.rows[0];
     }};


select get_country_by_code('AT') AS country;
SELECT DBMS_MLE.VERSION FROM dual;

SELECT *
FROM v$session_connect_info
WHERE sid = SYS_CONTEXT('USERENV','SID');



