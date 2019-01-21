#springboot多模块项目练习

## 参考文章:
[SpringBoot多模块项目实践（Multi-Module）](https://segmentfault.com/a/1190000011367492?utm_source=tag-newest#articleHeader11)
[github地址](https://github.com/yizhiwazi/springboot-socks/tree/master/springboot-integration)

##修改参考:
[Maven学习总结(八)——使用Maven构建多模块项目](https://www.cnblogs.com/xdp-gacl/p/4242221.html)

## 解决项目之间依赖错误:
1.dependencyManagement
修改父项目(springboot-integration)pom.xml
原来：
```xml
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>com.teenyda</groupId>
				<artifactId>mm-web</artifactId>
				<version>0.0.1-SNAPSHOP</version>
			</dependency>
		</dependencies>
</dependencyManagement>
```

修改后(去掉version):
```xml
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>com.teenyda</groupId>
				<artifactId>mm-web</artifactId>
			</dependency>
		</dependencies>
</dependencyManagement>
```

2.groupId
子模块 pom.xml 删除<groupId>com.teenyda</groupId>,让其继承父项目

3.version
子模块 pom.xml 删除<version>1.0.0.RELEASE</version>,让其继承父项目


[JPA + SpringData 操作数据库原来可以这么简单 ---- 深入了解 JPA - 1](https://www.cnblogs.com/crawl/p/7703679.html)


## 打包并运行
在idea右侧打开Maven Project，打开springboot-integration项目->Lifecycle->clean -> package(打包)
打包好之后，会在mm-web\target目录下生成mm-web.jar文件
运行:java -jar mm-web.jar