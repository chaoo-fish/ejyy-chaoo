
Java版地址: https://github.com/chaoo-fish/ejyy-chaoo

项目原地址: https://gitee.com/chowa/ejyy

>  截止8.20，该项目已初步完成部分模块
>
> > 宠物模块
>
> > 投诉模块
>
> > 通知模块

项目结构

父工程：  ejyy-openlab                    用于管理项目依赖
通用模块：   |--- ejyy-common        通用模块父工程

​                               |--- ejyy-utils        用于编写通用工具类

​                               |--- ejyy-security          用于编写通用认证授权工具类

网关模块：   |--- ejyy-gateway         用于编写网关

服务模块：   |--- ejyy-service           服务模块父工程

​                              |--- ejyy-user         用户微服

​                              |--- ejyy-init           初始化微服

# 环境

> 目前使用的环境

java 11

maven 3.6.1

mysql 5.7.14

Redis 6.2.7

nacos 2.1.0

## 项目模块

- [x] ejyy-openlab
- [x] ejyy-common
    - [x] ejyy-utils
    - [x] ejyy-security
- [x] ejyy-gateway
- [x] ejyy-service
    - [x] ejyy-user
    - [x] ejyy-init
    - [x] ejyy-basic

因为模块在一开始规划的时候出了点小问题，所以我将宠物、投诉及通知都写在了basic中



## 接口

根据前端项目查找调用方法名、请求方式、所需要参数、模块名称

> 因为该项目是对原开源项目ejyy后端进行的Java版本的翻译

所以需要去修改原项目的前端请求，并将他启动即可

例如：

需要让`/user/init`指向我们的`http://localhost:8100/user/init`

> 这样做的目的其实是因为笔者不是很会vue，所以只能使用这样笨拙的方法去修改，当然，如果后端使用了网关，那么这样去改也许会轻松一些

# ejyy-init

**端口：8100**

> 这个模块主要就是用于成员初始化

# ejyy-user

**端口：8200**

> 该模块是用于用户登录
>
> > token

# ejyy-basic

**端口：8300**

> 这个模块是我后面写宠物、投诉、通知



# 配置文件

只需要修改每个模块中yml文件中的各个服务的地址即可

**注意：**因为前端接受的数据大都是以下划线去接收的，所以我将 mybatis-plus 的默认驼峰改成不启用驼峰

> mybatis 的查询默认是将数据库中的字段名称由下换线转成驼峰，这点可以从 mybatis-plus 的源码看出

```yml
server:
  port: 8200
spring:
  application:
    name: user-server

  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://192.168.33.135:3306/ejyy?useSSL=false&characterEncoding=UTF8
    username: root
    password: root
  redis:
    host: 192.168.33.135 # redis 地址
    port: 6379
    database: 0
    timeout: 18000000
    lettuce:
      pool:
        max-active: 20
        max-wait: -1
        max-idle: 5
        min-idle: 0
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.33.135:8848
mybatis-plus:
  type-aliases-package: com.chaoo.service.user.mapper
  global-config:
    db-config:
      id-type: auto # 自增长
      table-prefix: ejyy_
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    map-underscore-to-camel-case: false # 关闭驼峰
```