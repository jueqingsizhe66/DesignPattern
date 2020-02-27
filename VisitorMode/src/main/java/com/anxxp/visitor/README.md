Represent an opration to be performed on the elements of an object structure.Visitor lets you define a new operation without changing the classes of the elements on which it oprates.

    表示一个作用于某对象结构中的各个元素的操作。它可以在不改变各个元素的类的前提下定义作用于这些元素的新操作。

## 何时使用：

    1. 一个对象结构中，比如某个集合中，包含很多对象，想对集合中的对象增加一些新的操作。
    2. 需要对集合中的对象进行很多不同的并且不相关的操作，而不想修改对象的类，就可以使用访问者模式。
    3. 访问者模式可以在Visitor类中集中定义一些关于集合中对象的操作。
    
## 优点：

    1. 可以在不改变一个集合中的元素的类的情况下，增加新的施加于该元素上的新操作。
    2. 可以将集合中各个元素的某些操作集中到访问者中，不仅便于集合的维护，也有利于集合中元素的复用。
    3. 访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。
    4. 一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。

    这个模式可能稍微难理解一点，希望读者一点一点读下去，碰到不清楚的先跳过，看完例子再回过头来基本就清楚是怎么回事了。

    在介绍访问者模式前，先介绍一下分派的概念。

**变量被声明时的类型叫做变量的静态类型(Static Type)，而变量所引用的对象的真实类型又叫做变量的实际类型(Actual Type)**，
如：

```java

List<String> list = new ArrayList<String>();

```
    这个list变量的静态类型是List，而它的实际类型是ArrayList。根据对象的类型而对方法进行的选择，就是分派(Dispatch)。分派又分为两种：静态分派和动态分派。

    静态分派(Static Dispatch)发生在编译时期，分派根据静态类型信息发生。静态分派对于我们来说并不陌生，方法重载就是静态分派。

    动态分派(Dynamic Dispatch)发生在运行时期，动态分派动态地置换掉某个方法。

    看一个例子：

```java

public class Dispatch {
    void print(FatherClass c){
        System.out.print("父类");
    }
    void print(ChildClass c){
        System.out.print("子类");
    }
    public static void main(String args[]){
        FatherClass child = new ChildClass();
        new Dispatch().print(child);
        child.print();
    }
}
class FatherClass{
    void print(){
        System.out.println("父类");
    }
}
class ChildClass extends FatherClass{
    void print(){
        System.out.print("子类");
    }
}//输出：父类子类
```

    可以看到，重载的分派是根据静态类型进行的。

1. 静态分派
2. 动态分派

    java的方法重写是根据实际类型来的（动态分派），编译器编译时并不知道其真实类型，而是运行时动态决定的。

    一个对象又叫做它所包含的方法的接收者，java中的动态分派，要调用哪一个方法，是由这个对象的真实类型决定的。

    如果能够根据参数和接收者来动态的决定调用某个方法，这就是动态的多分派语言，如果可以根据这两种方式来动态的决定方法调用，就是动态双重分派，但前面已经说了，java中重载是根据静态类型进行的，所以java只能动态的根据接收者来进行方法调用，即java是动态单分派语言，如果要实现双重分派，就必须通过设计模式来完成。

    OK，讲到重点了，访问者模式正是实现双重分派的模式。java中通过两次方法调用来实现两次分派。
    
 *重载的分派是根据静态类型进行的*
 
 java的方法重写是根据实际类型来的（动态分派），编译器编译时并不知道其真实类型，而是运行时动态决定的。 
 __
 1. 参数【决定调用那个方法 ,这时候得看是哪个静态类,父类】 **之前一直没注意到这个问题**
    也就是java的重载是根据静态类型进行的，所以java只能动态的根据接收者来进行方法调用，即java是
    动态单分派语言，如果要实现双重分派，就得设计设计
 2. 接收者【父类决定什么方法可调用, 方法的具体实现这时候得看是哪个动态类，子类】
 3. 子类【决定方法的具体实现】