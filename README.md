# create database
```
CREATE DATABASE test CHARACTER SET utf8;
USE test;
```

# create table User
```
CREATE TABLE User (
  userId       INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户Id',
  userName     VARCHAR(100) COMMENT '用户名称',
  userPassword VARCHAR(100) COMMENT '用户密码'
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
```
# insert into User
```
INSERT INTO User (userName, userPassword) VALUES ("test1", "test1");
INSERT INTO User (userName, userPassword) VALUES ("test2", "test2");

SELECT * FROM User;
```