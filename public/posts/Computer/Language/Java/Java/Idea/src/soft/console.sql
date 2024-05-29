set names utf8;
drop database if exists DB;
create database DB charset utf8;
use DB;

create table user
(
    user_id   int primary key auto_increment,#用户编号
    user_name varchar(40),#用户名
    user_pwd  varchar(40)                    #用户密码
);

insert into user
values (null, 'Mlkl', 'Mlkl');
insert into user
values (null, 'Mchx', 'Mchx');
insert into user
values (null, 'Mzyd', 'Mzyd');
insert into user
values (null, 'Tsl', 'Tsl');

create table classroom
(
    class_id   int primary key,#教室编号
    class_loc  varchar(40) null,#教室位置
    class_type varchar(40) null,#教室类型
    class_max  int         null#教室最大容纳人数
);

insert into classroom
values (1,'室外','操场',30);
insert into classroom
values (2,'室外','操场',30);
insert into classroom
values (3,'室外','操场',30);
insert into classroom
values (4,'三教','普通',50);
insert into classroom
values (5,'三教','普通',50);
insert into classroom
values (6,'三教','语音',50);
insert into classroom
values (7,'四教','普通',100);
insert into classroom
values (8,'三教','语音',100);
insert into classroom
values (9,'四教','语音',100);
insert into classroom
values (10,'四教','语音',100);

create table course
(
    course_id      int primary key,#课程编号
    course_name    varchar(40) null,#课程名
    course_type    varchar(40) null,#课程类型
    course_teacher varchar(40) null,#授课教师
    course_max     int         null #课程最大人数
);

#insert into course
#values (1, '高等数学', '语音', '教师A', 80);
#insert into course
#values (222, '线性代数', '教师B', 200);
#insert into course
#values (333, '概率论与数理统计', '教师C', 100);

create table classroom_course_status
(
    classroom_id int null,#教室编号
    course_id    int null,#课程编号
    week_num     int null,#星期几
    time_num     int null#第几节课
);

create function schedule1(classroomId int, courseId int, weekNum int, timeNum int, number int, type varchar(40))
    returns int
begin
    declare a, tem_num int; # 记录要排课的教室类型
    declare tem_type varchar(40); # 记录要排课的教室类型
    declare flag int;
    set flag = 1;
    select class_max into tem_num from classroom where class_id = classroomId;
    if (number <= tem_num) then
        select count(*) into a from classroom_course_status where classroom_id = classroomId and week_num = weekNUM and time_num = timeNum;
        if (a = 0) then
            select class_type into tem_type from classroom where class_id = classroomId;
            if(tem_type = type) then
                insert into classroom_course_status value (classroomId, courseId, weekNum, timeNum);
            else
                set flag = 0;
            end if;
        else
            set flag = 0;
        end if;
    else
        set flag = 0;
    end if;
    return flag;
end;

create function random_schedule(courseId int, number int, type varchar(40))
    returns int
begin
    declare a, i, max int;
    declare flag int;
    declare tem_num int;
    declare tem_type varchar(40); # 记录要排课的教室类型
    declare week, time int;

    set week = 1;
    set time = 1;
    set flag = 1;
    set i = 0;
    select count(*) from classroom into max;
    outer_label:
    begin
        while(i < max)
            do
                select class_max into tem_num from classroom limit i, 1;
                select class_type into tem_type from classroom limit i, 1;
                if (tem_num >= number) then
                    while(week < 6)
                        do
                            while (time < 6)
                                do
                                    select count(*)
                                    into a
                                    from classroom_course_status
                                    where classroom_id = i+1 and week_num = week and time_num = time;
                                    if (a = 0 AND tem_type = type) then
                                        insert into classroom_course_status value (i+1, courseId, week, time);
                                        leave outer_label;
                                    end if;
                                    set time = time + 1;
                                end while;
                            set time = 1;
                            set week = week + 1;
                        end while;
                    set week = 1;
                end if;
                set i = i + 1;
            end while;
    end outer_label;
    if (i = max) then
        set flag = 0;
    end if;
    return flag;
end;

#select random_schedule(1,  80, '语音');
#select random_schedule(111,  500);

select *
from user
where user_name = 'a';

create procedure Insert_user(user varchar(40), pwd varchar(40))
begin
    insert into user values (null, user, pwd);
end;

