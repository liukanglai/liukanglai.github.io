---
title: "Sql"
date: 2023-03-28T12:49:43+08:00
draft: false
tags: ["sql"]
author: "liukanglai"
description: " "
---

# mysql

## install

1. mariadb

- mariadb-install-db --user=mysql --basedir=/usr --datadir=/var/lib/mysql
- systemctl start mariadb.service

> etc/my.cnf.d/mysql-clients.cnf, and add auto-rehash under mysql

## run

- sudo mysql -u root -p
  > Note: The default password is empty. Press Enter to log in.

```mysql
MariaDB> CREATE USER 'monty'@'localhost' IDENTIFIED BY 'some_pass';
MariaDB> GRANT ALL PRIVILEGES ON mydb.* TO 'monty'@'localhost';
MariaDB> quit
```

- FLUSH PRIVILEGES; quit

## constraint

        # change/delete constraint: alter
        primary key
        not null
        unique
        foreign key name references
        auto_increment

        create user 'name'@'localhost' identified by 'password';
        drop user 'name'@'localhost'

        host：指定在哪个主机上登陆，本地用户可用localhost，让该用户可以从任意远程主机登陆，%
        password：密码可以为空，可以不需要密码登陆

        grant all on mydb.* (*.*) to 'monty'@'localhost';
        grant privileges on databasename.tablename to 'username'@'host' with grant option;

        all, select, update, delete

        set password for 'username'@'localhost' = password('...');
        set password = password('...'); -- current user

        revoke privileges on database.table from 'username'@'localhost'

- 假如你在给用户'pig'@'%'授权的时候是这样的（或类似的）：
- GRANT SELECT ON test.user TO 'pig'@'%'，REVOKE SELECT ON _._ FROM 'pig'@'%';
- 命令并不能撤销该用户对 test 数据库中 user 表的 SELECT 操作
- 如果授权使用的是 GRANT SELECT ON _._ TO 'pig'@'%';
- 则 REVOKE SELECT ON test.user FROM 'pig'@'%';
- 命令也不能撤销该用户对 test 数据库中 user 表的 Select 权限。
- 具体信息可以用命令 SHOW GRANTS FOR 'pig'@'%'; 查看。

## sql

> DDL DML DQL DCL

- 用 ; 表示一句结束
- ingore case
- comment: -- #; `/* */`

## DDL(Data Definition Language)

1. basic types

- char(n)

      create database Student;
      create database if not exists Student;
      create database Student character set utf-8;

      show databases;
      show create database Student;

      alter database Student character set utf-8;

      drop database Student;
      drop database if exists Student;

      select database();
      use Student;

## DML(Data Manipulation Language)

> Except number, all other types need to use '' or "" to include.

        create table Sc(
            name varchar(20),
            age int,
            score double (3, 7),
            birthday data,
            birthday datatime,
            insert_time timestamp,
            );
        # copy:
        create table Sc like some;

        show tables;
        desc Sc;

        select * from Sc;
        select name, age from Sc;
        select 字段列表, from 表名列表, where 条件列表, group by 分组字段, having 分组之后的条件, order by 排序, limit 分页限定

        alter table Sc rename to Sc1;
        alter table Sc add height int;
        alter table Sc change height height1 int;
        alter table Sc modify height double;
        alter table Sc drop height;

        insert into Sc(name, age) values('j', 12);

        update Sc set name = 'j' where age = 11;

        drop table Sc;
        drop table if exists Sc;

        distinct # eliminate repetition

        delete from Sc where age < 10;
        delete from 表名；-- 不推荐使用。有多少条记录就会执行多少次删除操作。
        TRUNCATE TABLE 表名； -- 推荐使用，效率更高 先删除表，然后再创建一张一样的表。

        if null(name, Name);
        as;

## 逻辑符

        >,<,>=,<=,=,<>
        BETWEEN...AND
        IN(集合)
        LIKE
        IS NULL
        and or &&
        or or ||
        not or !

## 函数

        order by name (asc);
        order by name desc;

        count(*)
        max
        min
        sum
        avg

        group by name;

        limit 1;

---
