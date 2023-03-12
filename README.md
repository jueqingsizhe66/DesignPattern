关于设计模式的一点思考

## 2018-03-22

高内聚、低耦合（组合、依赖   封装、继承、多态）

[Mosh design pattern][11]

[java design pattern github code][12]

0. What is interface?

interface is an contract which can provide the feature to stronger the power of the product.

is an contract that specifies  the capabilities that a class should provide.(loose system)

  a. private?
    很重要的封装技能, 封锁字段修改或者函数修改，供内部类使用
    比如Account的balance字段是private，那么就不可以使用accuout.balance了，总有其他方法可以调用和修改他！

  b. module?
    模块化变成，未来的方向，所有的模块都使用module-info.java, 并且使用require, exports, open ,opens规范API的调用
    使得未来java程序升级更加的便利化！ 只要保证接口一致即可， 这也符合拓展支持、修改关闭的原则

上述操作，都是为了reduce system complexity by hiding unnecessary details(降低不必要的细节，是为了更好模块化或者协同编程)
有些信息隐藏起来，是为了建立更大的系统。 就像遥控器就那么几十个键，但是内部集成线路封装无数的引脚,处理多路信号(控制信号、数据信号)。


1. 模板

[beetl][1] 、和[jfinal enjoy][15]一款java模板引擎，你知道里面有多少种设计模式？


- 要去解释那些元素，是不是得用解释器的设计模式？
- GroupTemplate是核心功能，他是不是通过组合模式？
- 是不是还有工厂模式Configuration..?
- 正如其模板的魅力，肯定有模板模式，挖上一个窟窿，到时候填上去。



[mybatis-plus][2] 也是我挺喜欢的一款面向web端的数据库的增删查着开发工具，

- 支持分页、
- 代码生成的（帮你生成一些重复性的代码）

这是不是也是一种模板方法template pattern.

    Scan Entity----------->
            Reflection extrantion
                    ----------->
                            Analysis Table Name Column---------->
                                                             SQL Insert update delete select 
                                                                    ----->Injection Mybatis Container

这些开源软件，包含着各种各样的设计模式，值得我们去

- 学习，
- 挖掘，
- 提高（提高永远无止境,追求更好是一种态度）

这就好像策略模式有很多针对具体问题的解决方式一样，我们也许只需要一种即可，但为了适合不同场景，我们又
需要很多其他策略。

我们的原则是`拓展开放，修改关闭`, 指向性(子类赋值给父类)约束(方法调用，采用子类方法),指向性调用,
尽量在不改变原先code基础上，对代码系统进行修改

多态原则：子类可指向父类，在方法调用时候使用子类的覆盖方法.**很重要啦！**
父类类型的对象可以指向子类类型的对象，调用父类类型的方法是子类的实现。【特别重要】


2. 接口和抽象函数

接口是什么？……

- Collection接口，
- 文件流

Hessian接口，

1. 搭建Hessian接口
2. Hessian服务器
3. Hessian客户端(代理模式的运用, https文本代理，rpc二进制代理)

![hessian][6]
牛顿说："世界要接口，于是接口无处不在"



3. 动态分派和静态分派

在[访问者模式][4]中, 我才明白参数和接收者的意思，明白java是接收者动态分配【按子类调用 对应 被操作对象.accept
(行为访问类)】，动态分配置换掉某个方法，发生在运行期，而
针对于参数则是使用静态方式【发生在编译期】，也就是使用父类方式，对应visitor的vistor.visit(this)

一定要考虑好两个窟窿， 接收者.\(参数者\)

也就是

a. 重载的分派是根据静态类型(父类)进行的(同一个类中，只是修改函数的参数，参数的类型和个数)--参数静态分配(分配内存?)--consumer 形参
b. 重写的分派是根据动态类型(子类)进行的(不同类中)--子类动态分配---接收者：右边项  实参


提问获得发现，参与获得改变；参数：参与的数据，可以改变

形参决定能力的数量
实参决定的能力的表现形式和质量



类似于数学公式

```
     Y = AX + b
```

X部分相当于是参数方法
Y相当于对象。


有时候也可能这样，别人给你一个开源代码，相当于给你一个Y,一个展示，以及各个模块X，但是你不知道他做的怎么样？ 也就是你不知道A，不知道有多少坑！
(有些专家一辈子(GMRES--YouSef Saad[1])就搞Y=AX+B的求解，这只是一个简化型公式，用于描述流体流动的Navier-Stokes方程,
A可以包含复杂的线性和非线性张量, 并做的很

1. Saad Y , Sosonkina M . Distributed Schur Complement Techniques for General Sparse Linear Systems[J]. SIAM Journal on Scientific Computing, 1997, 21(4):1337-1356.



而如果你是一名开发者，也就是你你在从事整个设计的过程，相当于你知道所有的A和X，也就是上述的终极方程
进一步变为

```
     Y =  Ai * Xi +bi , i = 0,1,...,n
```

X代表各个子模块，子包，A代表坑的多少(存在非线性的迭代过程，非线性的一阶、二阶算子），做到的程度， Y就是你设计的后台系统。

设计模式体现着不同的组织形式，不同形式有不同的优缺点【这句话得深入体会, 2020-04-15 得研究清楚不同的Xi的区别和联系，理清他们的本质不同】

```
        看都看得明白，自己写还是if-else

        特别是状态模式和策略模式
```

4. 枚举类

静态枚举类，enum类，通过instance调用，是最经常使用的一种单例模式。

**优先使用组合（has -a)，不要使用集成(is a)**


5. 责任链模式

必须能够生成chain，也就是setNextHandler(下一个处理人是谁)，过滤器就是典型的责任链，只要有我就过滤掉，
然后就不管了，继续处理下一个bean。

桥接模式和责任链模式的共同特点是 通过abstract继承，婢妾内置关键的抽象字段，形成链表，
访问时候有点new XX(new YY(new ZZ)).DD()的特点

单例、责任链、桥接模式都有内置静态字段。

6. 大小概念

在设计模式中，得体会这几个概念的相似

- 资源类
- 产品类【模板方法, 也可以拓展一下把一个开源软件当做一种产品去欣赏】
- 元素类【访问者模式  状态模式等】

针对动作、行为的行为类[访问者模式的visitorImpl， 策略模式的方法] 

小结： 有些设计模式针对元素进行重构，有些设计模式针对行为、方法进行重构
2020-04-15 又重新认识了设计模式的分类问题。

7. 对象繁殖

当前的对象的最基本能力就是生产下一代，培育下一代，没有其他。

每个对象有都构建、销毁的能力(构成了他们的生命周期)。

基于这种thinking也可能帮助account for the design patterns.

8. 访问者模式

在访问者模式有写到

- ASTParser
- html解析
- xml解析等， 

他们都是包含节点的概念，也就是节点是一个抽象概念，比如在html有

- body
- div
- ul
- li节点等，

在ASTParser有

- function
- method
- class
- 变量类型节点， 

这些节点构成了系统的骨骼元素;

而解析的时候，我们可能需要看到对应的相应状态，也就是添加一个visitor，其实这跟
观察真模式有点像，比如在观察者模式Observer pattern中对D://aaa文件夹的

- 创建文件 
- 删除文件 
- 创建文件夹 
- 删除文件夹 
- 修改文件等行为进行观察，如果发生相应动作该怎么办;

最终report的内容就不一样【让我想起了Perl语言， Practical extraction and report language】
这就有点像解释器模式，因为其实程序本身就是一个解释器！【最好的理解方式是通过[scheme写一个解释器][5]出来】

访问者模式只不过是解释器的一种简化对象模式，对象可能比较少，解释器要求是一个模态空间的全部、完备对象。
很多解释器都是用visitor模式进行编写

- 而[策略模式][13]、
- 观察者模式、
- 责任链模式等都是针对你的行为进行`轮询` or `Iterator`的过程,

代理模式则是针对行为进行`替换`的操作。

9. 插上一个private洞变量

很多设计模式都喜欢插上private窟窿变量， 比如

- 组合模式
- adpater模式等。

10. AOPInject

- 了解动态代理的生成原理(invoke)
- 了解注解的执行过程(@Fluid)

11. what's the difference between decrator and vistor?

简单的说，
          修饰模式是接口不变，但是接口的内部逻辑扩展；
          访问者模式是，增加了接口，以定义新的访问方式。  
          访问者模式：可拓展接口的设计模式

你写的内容一定得保持前后一致性，不允许存在逻辑的跳跃过程。
![fluid][7]

12. 每一张设计模式构成了你的玻璃纸

![design pattern][8]

13. 相关学习资源

- [JAVA图解设计模式][10] 源代码： [DesignPatter][9]
- [HEAD First Design Pattern][15]
- [Java Design Pattern][12]

14. 桥接模式特点

- 1个待实现的接口字段
- 1个抽象类 包含该接口字段的单参构造函数
- main函数使用new XX(new YY()).ZZ()进行方法调用

[1]:http://ibeetl.com/guide/#beetl 
[2]:http://mp.baomidou.com/#/?id=%E7%AE%80%E4%BB%8B 
[3]:http://hessian.caucho.com/ 
[4]:https://blog.csdn.net/anxpp/article/details/51224293 
[5]:http://jueqingsizhe66.github.io/blog/2015/05/18/the-little-scheme-and-part-of-tss/ 
[6]:https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/Hessian.png
[7]:https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/AOPInject.png
[8]:https://github.com/jueqingsizhe66/DesignPattern/blob/master/image/layoutGlasses.png
[9]: https://github.com/mxg133/learnforJava_DesignPattern
[10]: https://www.bilibili.com/video/BV1G4411c7N4?from=search&seid=15872822897781241058
[11]:https://www.youtube.com/watch?v=NU_1StN5Tkk 
[12]:https://github.com/iluwatar/java-design-patterns 
[13]:https://www.youtube.com/watch?v=v9ejT8FO-7I 
[14]:https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/strategy 
[15]:https://gitee.com/jfinal/enjoy 