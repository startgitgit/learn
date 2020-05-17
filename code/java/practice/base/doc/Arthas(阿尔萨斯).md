# Arthas
启动：java -jar arthas-boot.jar

查看类：sc com.zyq.dropwizard.ServicesApplication

反编译类：jad com.zyq.dropwizard.ServicesApplication

跟踪方法执行每步耗时：trace com.zyq.dropwizard.resources.PositionResource get

查看调用栈：stack com.zyq.dropwizard.resources.PositionResource get
排列出 CPU 使用率 Top N 的线程：
排查阻塞的线程：thread -b