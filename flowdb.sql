select user();

select database();
show databases;
use flowdb;
create database flowdb;

select user();

create user 'flow'@'%' identified by '1111';
grant all privileges on flowdb.* to 'flow'@'%';
show grants for 'flow'@'%';

drop table flow;
CREATE TABLE flow(
file_num int Auto_Increment primary key,
file_extension VARCHAR(20) not null,
file_check char(1), 
state int(10) unsigned
);

select * from flow;
set sql_safe_updates = 0; #1175에러
delete from flow where file_extension = 'eaa';

UPDATE flow
		SET file_check = 'y',state = state +1
		WHERE file_num = 1;
        
insert into flow (file_extension,file_check,state) values ('bat','n',0);
insert into flow (file_extension,file_check,state) values ('cmd','n',0);
insert into flow (file_extension,file_check,state) values ('com','n',0);
insert into flow (file_extension,file_check,state) values ('cpl','n',0);
insert into flow (file_extension,file_check,state) values ('exe','n',0);
insert into flow (file_extension,file_check,state) values ('scr','n',0);
insert into flow (file_extension,file_check,state) values ('js','n',0);

select * from flow
		order by file_num asc;

SELECT * FROM flow
		WHERE file_check like '%n%' and file_num = 1;
        
SELECT * FROM flow GROUP BY file_extension HAVING COUNT(file_extension) > 1;

insert into flow(file_extension) 
select 'aaa' from dual 
where not exists(select * from flow where flow.file_extension = 'aaa');

SELECT COUNT(*) totalCnt FROM flow where file_check is null;

alter table flow add column state int(10) unsigned;

DELETE FROM flow
		WHERE file_check is NULL;
commit;
