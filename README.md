# 项目描述

本项目为开源项目ejyy的java版/
项目原地址:https://gitee.com/chowa/ejyy

# 项目结构

父工程：  ejyy-openlab                    用于管理项目依赖
通用模块：   |--- ejyy-common        通用模块父工程

​                               |--- ejyy-utils        用于编写通用工具类

​                               |--- ejyy-security          用于编写通用认证授权工具类

网关模块：   |--- ejyy-gateway         用于编写网关

服务模块：   |--- ejyy-service           服务模块父工程

​                              |--- ejyy-user         用户微服

​                              |--- ejyy-init           初始化微服

## 环境

> 目前的项目环境
java 11

maven 3.6.1

mysql 5.7.14

redis 

## Task

### 项目依赖

- [x] ejyy-openlab    
- [x] ejyy-common
  - [x] ejyy-utils
  - [x] ejyy-security          
- [x] ejyy-gateway
- [x] ejyy-service
  - [x] ejyy-user
  - [x] ejyy-init



## 接口

根据前端项目查找调用方法名、请求方式、所需要参数、模块名称，并填写如下表：

| 请求方式 | 请求地址            | 参数                                                         | 说明           | 返回值                                                       | 对应表名                                                     |
| -------- | ------------------- | ------------------------------------------------------------ | -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| POST     | /user/account_login | form: {     account: '',     password: '',     captcha: '' } | 用户登录       | {     code: SUCCESS,     data: {         token,         userInfo: pcUserInfo,         postInfo     } } | ejyy_property_company_user<br/>ejyy_property_company_access<br/>ejyy_wechat_official_accounts_user<br/>ejyy_property_company_auth |
| GET      | /user/captcha       |                                                              | 验证码         | {     code: SUCCESS,     data: {         img: 图片,         expire: config.session.maxAge     } |                                                              |
| GET      | /user/state         |                                                              | 用户状态       | {     code: SUCCESS,     data: {         state: ctx.session.state,         expire: config.session.maxAge     } } |                                                              |
| GET      | /user/info          |                                                              |                | {     code: SUCCESS,     data: {         userInfo: info,         postInfo     } } |                                                              |
| POST     | /user/reset         | form: {     password: undefined}                             | 重置密码       | {     code: SUCCESS,     message: '重置登录密码成功' }       | ejyy_property_company_user                                   |
| GET      | /user/logout        |                                                              | 退出登录       | {     code: SUCCESS,     message: '账号已退出' }             | ejyy_property_company_auth                                   |
| GET      | /user/info          |                                                              | 用户信息       | {     code: SUCCESS,     data: {         userInfo: info,         postInfo     } } | ejyy_property_company_user，ejyy_community_setting，ejyy_community_info，ejyy_property_company_user_access_community， |
| GET      |                     |                                                              |                |                                                              |                                                              |
| POST     | /init/run           | {     ...profile,     ...community,     province: community.address[0],     city: community.address[1],     district: community.address[2],     code,     state } | 用户信息初始化 | {     code: SUCCESS,     message: '系统初始化成功' }         | ejyy_property_company_user，ejyy_community_info，ejyy_community_setting，ejyy_property_company_user_access_community，ejyy_property_company_auth |
| GET      | /init/state         |                                                              |                | {     code: SUCCESS,     data: {         state: ctx.session.initState,         expire: config.session.maxAge     } } |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |
|          |                     |                                                              |                |                                                              |                                                              |

# ejyy-init

端口：8100

```
http://localhost:8100
```



> 初始化模块

## 成员信息初始化

```
/init/run
```



## 跨域

```java
@Controller
@RequestMapping("/init")
@CrossOrigin // 支持跨域
public class InitController {
	...	
}	
```







# ejyy-user

端口：8200

```
http://localhost:8200
```

## 登录

```
/user/account_login
```



### 状态

```
/user/state
```



### 验证码

```
/user/captcha
```





# 服务

## Redis





# Utils

## 正则查找和替换保留

<img src="https://sansisuifeng-img.oss-cn-beijing.aliyuncs.com/img/202208111117340.png" alt="image-20220811111707255" style="zoom:50%;" />

将`// aaa` 变成 `/* aaa */`

```
// (.{0,100})

/* $1 */
```



## 获取IP

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

```java
/**
 * 从 HttpServletRequest 对象中获取IP地址的工具类
 */
public final class IPUtils {
    private static final String IP_UTILS_FLAG = ",";
    private static final String UNKNOWN = "unknown";
    private static final String LOCALHOST_IP = "0:0:0:0:0:0:0:1";
    private static final String LOCALHOST_IP1 = "127.0.0.1";

    /**
     * 获取IP地址
     * <p>
     * 使用Nginx等反向代理软件，则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-
     Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = null;
        try {
            //以下两个获取在k8s中，将真实的客户端IP，放到了x-Original-Forwarded-For。而将WAF的回源地址放到了 x -Forwarded - For了。
            ip = request.getHeader("X-Original-Forwarded-For");
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Forwarded-For");
            }
            //获取nginx等代理的ip
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("x-forwarded-for");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 ||
                    UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            //兼容k8s集群获取ip
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (LOCALHOST_IP1.equalsIgnoreCase(ip) ||
                        LOCALHOST_IP.equalsIgnoreCase(ip)) {
                    //根据网卡取本机配置的IP
                    InetAddress iNet = null;
                    try {
                        iNet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        //log.error("getClientIp error: {}", e);
                        throw new RuntimeException(e.getMessage());
                    }
                    ip = iNet.getHostAddress();
                }
            }
        } catch (Exception e) {
        //e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        //使用代理，则获取第一个IP地址
        if (!StringUtils.isEmpty(ip) && ip.indexOf(IP_UTILS_FLAG) > 0) {
            ip = ip.substring(0, ip.indexOf(IP_UTILS_FLAG));
        }
        return ip;
    }
}
```

## 身份证ID

```java
/**
 * 身份证号的工具类
 */
public class IDCardUtil {
    /**
     * 15位身份证号
     */
    private static final Integer FIFTEEN_ID_CARD = 15;
    /**
     * 18位身份证号
     */
    private static final Integer EIGHTEEN_ID_CARD = 18;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据身份证号获取性别
     *
     * @param IDCard
     * @return true:男 false:女
     */
    public static boolean getSex(String IDCard) {
        // 默认为男
        boolean gender = true;
        String sex = "";
        if (StringUtils.isNotBlank(IDCard)) {
            //15位身份证号
            if (IDCard.length() == FIFTEEN_ID_CARD) {
                if (Integer.parseInt(IDCard.substring(14, 15)) % 2 == 0) {
//                    sex = "女";
                    gender =false;
                } else {
//                    sex = "男";
                    gender = true;
                }
                //18位身份证号
            } else if (IDCard.length() == EIGHTEEN_ID_CARD) {
                // 判断性别
                if (Integer.parseInt(IDCard.substring(16).substring(0, 1)) % 2 == 0) {
//                    sex = "女";
                    gender = false;
                } else {
//                    sex = "男";
                    gender = true;
                }
            }
        }
        return gender;
    }

    /**
     * 根据身份证号获取年龄
     *
     * @param IDCard
     * @return
     */
    public static Integer getAge(String IDCard) {
        Integer age = 0;
        Date date = new Date();
        if (StringUtils.isNotBlank(IDCard)) {
            //15位身份证号
            if (IDCard.length() == FIFTEEN_ID_CARD) {
                // 身份证上的年份(15位身份证为1980年前的)
                String uyear = "19" + IDCard.substring(6, 8);
                // 身份证上的月份
                String uyue = IDCard.substring(8, 10);
                // 当前年份
                String fyear = format.format(date).substring(0, 4);
                // 当前月份
                String fyue = format.format(date).substring(5, 7);
                if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) {
                    age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
                    // 当前用户还没过生
                } else {
                    age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
                }
                //18位身份证号
            } else if (IDCard.length() == EIGHTEEN_ID_CARD) {
                // 身份证上的年份
                String year = IDCard.substring(6).substring(0, 4);
                // 身份证上的月份
                String yue = IDCard.substring(10).substring(0, 2);
                // 当前年份
                String fyear = format.format(date).substring(0, 4);
                // 当前月份
                String fyue = format.format(date).substring(5, 7);
                // 当前月份大于用户出身的月份表示已过生日
                if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) {
                    age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
                    // 当前用户还没过生日
                } else {
                    age = Integer.parseInt(fyear) - Integer.parseInt(year);
                }
            }
        }
        return age;
    }

    /**
     * 获取出生日期  yyyy年MM月dd日
     *
     * @param IDCard
     * @return
     */
    public static String getBirthday(String IDCard) {
        String birthday = "";
        String year = "";
        String month = "";
        String day = "";
        if (StringUtils.isNotBlank(IDCard)) {
            //15位身份证号
            if (IDCard.length() == FIFTEEN_ID_CARD) {
                // 身份证上的年份(15位身份证为1980年前的)
                year = "19" + IDCard.substring(6, 8);
                //身份证上的月份
                month = IDCard.substring(8, 10);
                //身份证上的日期
                day = IDCard.substring(10, 12);
                //18位身份证号
            } else if (IDCard.length() == EIGHTEEN_ID_CARD) {
                // 身份证上的年份
                year = IDCard.substring(6).substring(0, 4);
                // 身份证上的月份
                month = IDCard.substring(10).substring(0, 2);
                //身份证上的日期
                day = IDCard.substring(12).substring(0, 2);
            }
            birthday = year + "年" + month + "月" + day + "日";
        }
        return birthday;
    }
}
```

## 屏蔽手机号中间4位

```java
/**
 * 屏蔽手机号中间4位
 */
public final class MaskPhone {
    /**
     * 屏蔽手机号中间4位
     * @param phone 手机号
     * @return 返回屏蔽后的号码
     */
    public static String mask(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }
}
```

