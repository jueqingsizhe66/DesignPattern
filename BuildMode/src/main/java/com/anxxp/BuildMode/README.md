    Separate the construction of a complex object from its representation so that the 
    same construction process can create different representations.

    将一个复杂对象的构建与它的表示分离，使同样的构建过程可以创建不同的表示。

    何时使用：

    当系统准备为用户提供一个内部结构复杂的对象，而且在构造方法中编写创建该对象的代码无法
    满足用户需求时，就可以使用生成器模式老构造这样的对象。
    当某些系统要求对象的构造过程必须独立于创建该对象的类时。
    优点：

    生成器模式将对象的构造过程封装在具体的生成器中，用户使用不同的具体生成器就可以得到该对
    象的不同表示。
    生成器模式将对象的构造过程从创建该对象的类中分离出来，使用户无须了解该对象的具体组件。
    可以更加精细有效的控制对象的构造过程。生成器将对象的构造过程分解成若干步骤，这就是程序可
    以更加精细，有效的控制整个对象的构造。
    生成器模式将对象的构造过程与创建该对象类解耦，是对象的创建更加灵活有弹性。
    当增加新的具体的生成器是，不必修改指挥者的代码，即该模式满足开-闭原则。
    模式的重心在于分离构建算法和具体的构造实现，从而使构建算法可以重用。

    比如我们要得到一个日期，可以有不同的格式，然后我们就使用不同的生成器来实现。

    首先是这个类（产品）：