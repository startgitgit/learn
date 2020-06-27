# Arthas
启动：java -jar arthas-boot.jar

查看类：sc com.zyq.dropwizard.ServicesApplication

反编译类：jad com.zyq.dropwizard.ServicesApplication

跟踪方法执行每步耗时：trace com.zyq.dropwizard.resources.PositionResource get

查看调用栈：stack com.zyq.dropwizard.resources.PositionResource get
排列出 CPU 使用率 Top N 的线程：
排查阻塞的线程：thread -b

参数名称	参数说明
id	线程id
[n:]	指定最忙的前N个线程并打印堆栈
[b]	找出当前阻塞其他线程的线程
[i <value>]	指定cpu占比统计的采样间隔，单位为毫秒

https://alibaba.github.io/arthas/thread