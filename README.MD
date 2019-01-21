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

## 上传到github
把项目上传到github之后，每个项目的target/文件夹也一起上传了，下面我们把target文件夹从github上面删除掉.
查看命令:
```text
$ git rm -h
usage: git rm [<options>] [--] <file>...

    -n, --dry-run         dry run(演习)
    -q, --quiet           do not list removed files(不列出删除的文件)
    --cached              only remove from the index(只从索引区删除)
    -f, --force           override the up-to-date check(忽略文件更新状态检查)
    -r                    allow recursive removal(允许递归删除)
    --ignore-unmatch      exit with a zero status even if nothing matched(即使没有匹配，也以零状态退出)

```

接下来递归删除target文件夹
```text
git rm -r --cached target
```

每次增加文件或删除文件，都要commit 然后直接 git push -u origin master，就可以同步到github上了
```text
git commit -m "删除target文件夹"
git push -u origin master
```

