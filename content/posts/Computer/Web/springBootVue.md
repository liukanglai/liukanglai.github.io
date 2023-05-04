# 简单的项目

> `https://www.cnblogs.com/three-fighter/p/14332288.html`

- 前后端分离，通过 ajax 调用后端的 restuful api 进行数据交互

前端：

- vue，
- ElementPlus: a UI of VUE

后端：

- spring-boot: java 后端框架
- maven
- mybatis
- mysql

## 后端

### h 环境

- java
- idea
- mysql

### idea

- New Project-Spring Intializr
- 依赖: web, mysql, lombok

application.yml:

```yaml
server: port:9090
spring:
  application:
    name: ${APP_NAME:unnamed}
  datasource:
    url: jdbc:mysql://localhost:3306/
    username: sa
    password:
    driver-class-name: org.mysql.jdbc.Driver
    hikari:
      auto-commit: false
      connection-timeout: 3000
      validation-timeout: 3000
      max-lifetime: 60000
      maximum-pool-size: 20
      minimum-idle: 1
```

### mybatis-plus

- 不用自己写增删改查！！！

```xml
        <!--mybatis-plus依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.4.1</version>
        </dependency>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>


```

- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.url=jdbc:mysql://localhost:3306/mp-demo?characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8
- spring.datasource.username=root
- spring.datasource.password=root

## 前端

### 环境

- nodejs，npm (node -v; npm -v)
- vue-cli(npm install -g vue-cli)

- vetur, eslint, prettier
- chrome, chrome 插件：Vue.js devtools

### Ajax

- 前后端分离情况下，前后端交互的模式是前端发出异步式请求，后端返回 json 。

- axios 是一个基于 Promise 用于浏览器和 nodejs 的 HTTP 客户端，
- 本质上也是对原生 XHR 的封装，只不过它是 Promise 的实现版本，符合最新的 ES 规范。
- 在这里我们只需要知道它是非常强大的网络请求处理库，且得到广泛应用即可。

- npm install axios
- in main.ts: var axios = require('axios') Vue.prototype.$axios = axios


- 在前后端分离的情况下，比较流行的认证方案是 JWT认证 认证，和传统的session认证不同，jwt是一种无状态的认证方法，也就是服务端不再保存任何认证信息

- vuex
