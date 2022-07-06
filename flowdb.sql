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
file_check char(1) 
);

select * from flow;
set sql_safe_updates = 0; #1175에러
delete from flow where file_extension = 'eaa';

insert into flow (file_extension,file_check) values ('bat','n');
insert into flow (file_extension,file_check) values ('cmd','n');
insert into flow (file_extension,file_check) values ('com','n');
insert into flow (file_extension,file_check) values ('cpl','n');
insert into flow (file_extension,file_check) values ('exe','n');
insert into flow (file_extension,file_check) values ('scr','n');
insert into flow (file_extension,file_check) values ('js','n');

select * from flow
		order by file_num asc;

SELECT * FROM flow
		WHERE file_check like '%n%' and file_num = 1;
        
SELECT * FROM flow GROUP BY file_extension HAVING COUNT(file_extension) > 1;

insert into flow(file_extension) 
select 'aaa' from dual 
where not exists(select * from flow where flow.file_extension = 'aaa');

SELECT COUNT(*) totalCnt FROM flow where file_check is null;

DELETE FROM flow
		WHERE file_check is NULL;
commit;