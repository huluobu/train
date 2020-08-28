#培训笔记
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

6. 小参数调整
	root.xml改root链接路径，server.xml修改端口，更改首页web.xml 中修改
	修改hosts文件

#mysql

