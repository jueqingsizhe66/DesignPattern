# I.使用JDK的动态代理实现了简单地AOP思想编程

重点看invoke部分的不同

1. AOPMethod字段加入前后的对比
2. invoke方法中加入before和after对比

# II. 使用反射结合JDK动态代理实现了类似于Spring框架的简单“ @xxx(xx="xxxx") ”的数据注入

重点看DogImpl使用注解方式取代字段方式为注解方式

重点考Annotation.java类的解析
1. 所有字段值注入
2. 所有方法类注入和执行

[1]: https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/AOPInject.png
