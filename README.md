关于设计模式的一点思考

## 2018-03-22

1. 模板

[beetl][1] 我挺喜欢的一款java模板引擎，你知道里面有多少种设计模式？

a. 要去解释那些元素，是不是得用解释器的设计模式？
b. GroupTemplate是核心功能，他是不是通过组合模式？
c. 是不是还有工厂模式Configuration..?
d. 正如其模板的魅力，肯定有模板模式，挖上一个窟窿，到时候填上去。


[mybatis-plus][2] 也是我挺喜欢的一款面向web端的数据库的增删查着开发工具，支持分页、代码生成的（帮你生成一些重复性的代码），这是不是也是一种模板方法template pattern.

    Scan Entity----------->
            Reflection extrantion
                    ----------->
                            Analysis Table Name Column---------->
                                                             SQL Insert update delete select 
                                                                    ----->Injection Mybatis Container

这些开源软件，包含着各种各样的设计模式，值得我们去学习，挖掘，提高（提高永远无止境,追求更好是一种态度）
这就好像策略模式有很多针对具体问题的解决方式一样，我们也许只需要一种即可，但为了适合不同场景，我们又
需要很多其他策略。

我们的原则是`拓展开放，修改关闭`, 指向性(子类赋值给父类)约束(方法调用，采用子类方法),指向性调用,
尽量在不改变原先code基础上，对代码系统进行修改

多态原则：子类可指向父类，在方法调用时候使用子类的覆盖方法.**很重要啦！**


2. 接口和抽象函数

接口是什么？ Collection接口，文件流
Hessian接口，搭建Hessian接口，Hessian服务器，Hessian客户端(代理模式的运用, https文本代理，rpc二进制代理)

牛顿说："世界要接口，于是接口无处不在"



3. 动态分派和静态分派

在[访问者模式][4]中, 我才明白参数和接收者的意思，明白java是接收者动态分配【按子类调用 对应 被操作对象.accept
(行为访问类)】，动态分配置换掉某个方法，发生在运行期，而
针对于参数则是使用静态方式【发生在编译期】，也就是使用父类方式，对应visitor的vistor.visit(this)

4. 枚举类

静态枚举类，enum类，通过instance调用，是最经常使用的一种单例模式。

5. 责任链模式

必须能够生成chain，也就是setNextHandler(下一个处理人是谁)，过滤器就是典型的责任链，只要有我就过滤掉，
然后就不管了，继续处理下一个bean。

[1]:http://ibeetl.com/guide/#beetl 
[2]:http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B 
[3]:http://hessian.caucho.com/ 
[4]:https://blog.csdn.net/anxpp/article/details/51224293 