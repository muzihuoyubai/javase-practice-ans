## 目的
熟悉jar打包的相关命令行操作

## 练习
dist下的main.jar 中缺少了club/banyuan/animal/Dog.class和META-INF/MANIFEST.MF。
请编译src下的Dog.java生成Dog.class。
1. 将Dog.class打包成Dog.jar，放置到lib路径下，使用java运行main.jar中club.banyuan.Main类中的main方法
2. 将Dog.class添加到main.jar中，使用java -jar main.jar 运行程序(需要增加META-INF/MANIFEST.MF到jar包中，指定Main-Class)。

程序成功运行后输出
<pre>
训练狗狗小强
小强: 汪汪
狗狗小强和猫咪汤姆一起玩
汤姆: 喵..
</pre>

## 练习解析
1. 将Dog.class打包成Dog.jar，放置到lib路径下，使用java运行main.jar中club.banyuan.Main类中的main方法
```
# 保证终端在src路径下
javac -d ../out club/banyuan/animal/Dog.java
jar ufe ../dist/main.jar club.banyuan.Main -C ../out/ club/banyuan/animal/Dog.class
java -jar ../dist/main.jar
```

2. 将Dog.class添加到main.jar中，使用java -jar main.jar 运行程序(需要增加META-INF/MANIFEST.MF到jar包中，指定Main-Class)。
```
# 保证终端在src路径下
javac -d ../out club/banyuan/animal/Dog.java
jar cf ../lib/dog.jar -C ../out/ ./club/banyuan/animal/Dog.class
java -cp ../lib/dog.jar:../dist/main.jar club.banyuan.Main
```


## 备注
测试jar包制作方式
```
# 保证终端在src路径下

javac -d ../out club/banyuan/animal/* club/banyuan/human/* club/banyuan/Main.java 
jar cfe ../dist/main.jar club.banyuan.Main -C ../out/ .

# 运行jar包
# java -jar ../dist/main.jar 

zip -d ../dist/main.jar META-INF/*
zip -d ../dist/main.jar club/banyuan/animal/Dog.class

jar tf ../dist/main.jar 
```

