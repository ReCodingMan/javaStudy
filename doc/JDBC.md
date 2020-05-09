#### 概念：

_Java DataBase connectivity_
<br>
_Java 数据库l连接，Java语言操作数据库_

---

#### 快速入门：

##### 步骤：
1. 导入驱动包 xxxx.jar
    1. 复制 xxxx.jar 到项目的 libs 目录下
    2. 右键 --> Add As Library
2. 注册驱动
3. 获取数据库连接对象 Connection
4. 定义 sql
5. 获取执行 sql 语句的对象 Statement
6. 执行 sql，接受返回结果
7. 处理结果
8. 释放资源

---

#### 详解各个对象：
1. DriverManager：驱动管理对象
2. Connection：数据库连接对象
3. Statement：执行 sql 的对象
4. ResultSet：结果集对象
5. PreparedStatement：执行 sql 的对象