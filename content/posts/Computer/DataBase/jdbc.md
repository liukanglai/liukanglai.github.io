---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---# idea

`https://wiki.archlinux.org/title/JDBC_and_MySQL`

> in /etc/my.cnf: should #skip-networking, bind-address = *

- 导入 jar 包
- yay -S mariadb-jdbc
- ln -s /usr/share/java/mariadb-jdbc/mariadb-java-client.jar /usr/lib/jvm/default-runtime/jre/lib/ext

# connect database

```
package com.MTngCat.Person.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC连接数据库的步骤：
 * @author MTing
 * 步骤：
 *         1.注册驱动
 *         2.获取连接
 *        3.获取传输器
 *        4.通过传输器发送SQL到服务器质性并且返回执行结果
 *        5.数据处理
 *        6.释放资源
 */
public class connectionBasic {
    
    public static void main(String[] args) throws Exception {
        
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //MySQL版本在8.0之前的驱动的全限定类名是"com.mysql.jdbc.Driver"
        //MySQL版本在8.0之后的驱动的全限定类名是"com.mydql.cj.jdbc.Driver"
        //2.获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testjdbc_db?characterEncoding=UTF-8&serverTimezone=GMT%2B8&useServerPrepStms=true&cachePrepStms=true",
                "root",
                "MTingCat819"
                );
        //3.获取传输器
        Statement st = conn.createStatement();
        //4.通过传输器发送SQL到服务器执行并且返回执行结果
        String sql = "select * from account";
        ResultSet rs = st.executeQuery(sql);
        //5.数据处理
        while( rs.next() ) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id + ":" + name + ":" + money );
        }
        //6.释放资源
//        rs.close();
//        st.close();
//        conn.close();
        if( rs != null ) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }
        if( st != null ) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                st = null;
            }
        }
        if( conn != null ) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }
    
}

```


# tomcat

- chmod -R 777 conf
