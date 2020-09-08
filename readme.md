#培训笔记
## spring 书籍的知识总结
### 单例模式
	1.恶汉模式 
	```java
		public class SingleObject {
	 
	   //创建 SingleObject 的一个对象
	   private static SingleObject instance = new SingleObject();//创建时就自动加载实例对象
	 
	   //让构造函数为 private，这样该类就不会被实例化
	   private SingleObject(){}
	 
	   //获取唯一可用的对象
	   public static SingleObject getInstance(){
	      return instance;
	   }
	 
	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
	}
	```
	2. 懒加载方式
	```java
		//双重锁模式（线程安全和指令重排）
		public class Singleton {  
	    private volatile static Singleton singleton;  //禁止指令的重排优化
	    private Singleton (){}  
	    public static Singleton getSingleton() {  
	    if (singleton == null) {  
	        synchronized (Singleton.class) { //原子锁 
	        if (singleton == null) {  
	            singleton = new Singleton();  
	        }  
	        }  
	    }  
	    return singleton;  
	    }  
		}
	```
	3. 代理模式

##idea安装
###idea常用的目录
1. vmoption 虚拟机的配置文件
	xms 初始堆大小
	xmx 最大堆大小
2. propertities 文件
	（log文件路径）
	idea.max.intellisense.filesize=2500

	idea.max.content.load.filesize=20000

	idea.cycle.buffer.size=1024


###构建项目
1. 项目打包
	在projectstruct 中artifact设置项目模块，设置完成后，在build中点击build artifact 中打包
	打包完成在项目目录下\classes\artifacts下查看jar包
	
#maven 使用
##解决依赖包冲突
1. 对版本不兼容的包<exclusion></exclusion>在pom文件中

##resource文件配置
1. new----resourcebundle下创建Properties文件
	Properties properties = new Properties();
	properties.getProperty(key);
	进行获取


2. 多模块
	projectstruct 中模块添加依赖关系；
	在需要依赖的pom文件中导入被依赖的模块
```	
        <dependency>
            <groupId>org.carrot</groupId>
            <artifactId>firstweek-01</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```
firstweek02 调用firstweek01的config的读取properties配置

3. web项目
   	在配置tomcat时，deploy选项要调至web模块的webapp文件夹下才能运行成功

#tomcat 使用
## tomcat 认识
1. servlet server java表达式和websocket的开源实现
2. 目录结构，webapp 存放我们的可能的应用文件
3. model模块构建web项目时,想在prostruct中把模块引入，在将模块进行war包配置
4. 配置虚拟目录conf中的servre.xml中添加Context,设置完成后要重启Tomcat
	          ``` xml
	          <Context path="/f04" docBase="D:\springen\training\firstweek04"></Context>
	          ```
5. 可以在\conf\Catalina\localhost，新建xml文件,指向虚拟目录,无需重启
	```
	<?xml version='1.0' encoding='utf-8'?>
	<Context docBase="D:\springen\training\firstweek04"/>
	```

6. 参数调整
	root.xml改root链接路径，server.xml修改端口，更改首页web.xml 中修改
	修改hosts文件

#mysql
## 基本知识
1. 存储过程 data--table--database;
2. DBMS:
    文件共享的access
    CS 架构的client --server

## mysql 常见命令
	use /show  database;
	show /desc tables;

	规范--投产步骤注意使用use table/database来区别sql执行语句

## sql的查询
   1. select '字段' 用以区分；
   2. 字符串拼接CONCAT(id,',',IFNULL(serial,0))；
   3. 模糊查询 like 包含han字符的 like '%han%'
   		between and 包含临界值，且无法调换顺序
   		in 判断字段是否在列表中，列表字段类型必须一致，，无法支持通配符。
   		<=>安全等于
4. 连接 sql92 where 连接条件
		sql99 inner|left|right join table2 on 连接条件

6. 常用函数 max min avg count sum datediff(日期之差) lengh

5. 分组查询的字段限制，
	可以表达式分组：
	```sql
		SELECT LENGTH(e.ename) as len,COUNT(*)
		FROM emp e
		GROUP BY LENGTH(e.ename);
	```
	多字段分组
		```sql
		SELECT e.deptno,e.job,AVG(e.sal)
		FROM emp e
		GROUP BY e.deptno,e.job;
		```

7. 连接查询：
	等值连接：可以三张表连接
	自连接：对于一张表可以查找多次，且相互关联
	内连接： inner 可以省略 与等值连接的效果相同
			非等值连接

	外连接：主表有，从表没有的记录集合，a+ab或b+ab
			left/right + 主表

	全外连接：相当于集合的并 a+b-ab

8. 限定条件是最高，最低，可以order by col desc/asc limit  1;

9. union 查询是去重合并

10. alter table 

## 数据操作语言

1. 插入 insert into table (col) values(cl1...)类型一致或兼容,支持插入多条记录
		insert into table set col=val, col=val;
2. 更新 update table set col=val,,,, where condition;

3. 删除 delete from table where condition;有返回值，可以回滚。
		truncate table ;整个表数据全删，无返回值，
		多表删除，加上连接删除；
		自增长列：delete后，自增长列从断点开始；truncate,从1开始；



##数据库事务
1. 特性ACID
2. 隐式事务：delete set  create
3. commit |rollback
4. 事务流程
	```````
	set autocommit=0 
	start transaction
	commit;
	```````

5. 事物的隔离级别(set transaction isolation level + ...)
	read uncommitted
	read commited
	repeated read

6. savepoint 使用
	在事务内部使用
	savepoint a;
	rollback to a;
7. 视图--->临时表
		1). create view 视图名
			as
			查询语句;
		2). create or replace view  视图名
			as
			查询语句;




##java学习
###collection
1. 有list 和set
	list 有序，可重复，有下标（arraylist, linkedlist,vector）
	set  无序，无可重复
	collection api
	遍历：	1） for(object o:)
			2) iterator it=collection.iterator();迭代器使用中不能做做删除操作
			it.hasnext

2.	list add,remove,clear,
	遍历： for 下标
		  iterator 迭代器
		  list iterator 方向任意（hasprevious,set替换）








